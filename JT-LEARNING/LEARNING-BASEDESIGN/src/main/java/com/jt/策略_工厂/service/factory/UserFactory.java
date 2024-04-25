package com.jt.策略_工厂.service.factory;

import com.jt.策略_工厂.service.UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class UserFactory {
    private final Map<String, UserService> userServiceFactory = new HashMap<>();

    public UserFactory(Map<String, UserService> userServiceFactory){
        this.userServiceFactory.clear();
        this.userServiceFactory.putAll(userServiceFactory);
    }

    public Map<String, UserService> getUserServiceFactory() {
        return userServiceFactory;
    }
}
