package com.jt.controiler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class LoginController {

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}
