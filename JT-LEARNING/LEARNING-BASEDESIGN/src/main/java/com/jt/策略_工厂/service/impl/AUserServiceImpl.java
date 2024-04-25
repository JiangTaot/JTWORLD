package com.jt.策略_工厂.service.impl;

import com.jt.策略_工厂.service.UserService;
import org.springframework.stereotype.Service;

@Service("A")
public class AUserServiceImpl implements UserService {
    @Override
    public String getUser(String userId) {
        return "A";
    }
}
