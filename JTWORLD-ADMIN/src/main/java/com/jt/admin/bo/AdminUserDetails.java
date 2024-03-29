package com.jt.admin.bo;

import com.jt.admin.entity.JtAdmin;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * SpringSecurity需要的用户信息封装类
 * Created by macro on 2018/4/26.
 */
@AllArgsConstructor
public class AdminUserDetails implements UserDetails {
    //后台用户
    private final JtAdmin jtAdmin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户所拥有的资源
        return null;
    }

    @Override
    public String getPassword() {
        return jtAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return jtAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return jtAdmin.getStatus().equals(1);
    }
}
