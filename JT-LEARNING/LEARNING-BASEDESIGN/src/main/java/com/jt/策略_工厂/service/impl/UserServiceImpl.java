package com.jt.策略_工厂.service.impl;

import com.jt.策略_工厂.service.factory.UserFactory;
import com.jt.策略_工厂.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("default")
public class UserServiceImpl implements UserService {

    @Resource
    @Lazy
    private UserFactory userFactory;

    @Override
    public String getUser(String userId) {
        String user = null;
        try {
            user = userFactory.getUserServiceFactory().get(userId).getUser(userId);
        } catch (Exception e) {
            return "用户不存在";
        }
        return user;
    }
}
