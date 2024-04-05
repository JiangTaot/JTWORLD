package com.jt.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jt.admin.bo.AdminUserDetails;
import com.jt.admin.entity.JtAdmin;
import com.jt.admin.mapper.JtAdminMapper;
import com.jt.admin.service.JTAdminCacheService;
import com.jt.admin.service.JtAdminService;
import com.jt.admin.vo.LoginVo;
import com.jt.secure.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Service
@Slf4j
public class JtAdminServiceImpl extends ServiceImpl<JtAdminMapper, JtAdmin> implements JtAdminService {
    @Value("${secure.salt}")
    private String salt;
    private JwtTokenUtil jwtTokenUtil;
    private JTAdminCacheService jtAdminCacheService;
    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    @Lazy
    public void setJtAdminCacheService(JTAdminCacheService jtAdminCacheService) {
        this.jtAdminCacheService = jtAdminCacheService;
    }

    @Override
    public LoginVo login(String username, String password) throws AuthenticationException {
        String token;
        UserDetails userDetails = loadUserByUsername(username);
        if (!StrUtil.equals(SecureUtil.md5(password + salt), userDetails.getPassword())) {
            log.info("密码错误: {}", password);
            throw new AuthenticationException("密码错误");
        }
        if (!userDetails.isEnabled()) {
            log.info("用户被禁用: {}", username);
            throw new AuthenticationException("用户被禁用");
        }
        UsernamePasswordAuthenticationToken authenticated = UsernamePasswordAuthenticationToken.authenticated(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticated);
        token = jwtTokenUtil.generateToken(userDetails);
        return LoginVo.builder().token(token).username(username).build();
    }

    @Override
    public JtAdmin getAdminById(Long adminId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        JtAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            return new AdminUserDetails(admin);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    public JtAdmin getAdminByUsername(String username) {
        //先从缓存中获取数据
        JtAdmin admin = jtAdminCacheService.getAdmin(username);
        if (admin != null) return admin;
        //缓存中没有从数据库中获取
        List<JtAdmin> adminList = this.baseMapper.selectList(new LambdaQueryWrapper<JtAdmin>().eq(JtAdmin::getUsername, username));
        if (CollUtil.isNotEmpty(adminList)) {
            admin = adminList.get(0);
            //将数据库中的数据存入缓存中
            jtAdminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }
}
