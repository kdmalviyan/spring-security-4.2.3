package com.kd.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kd.example.spring.security.AuthenticationHelper;

@Controller
public class HomeController {

    @RequestMapping(value = { "/", "/home" })
    public String homeAuthenticated(ModelMap modelMap) {
        System.out.println("Entering into Home Method...");
        modelMap.put("msg", "Hello World!");
        modelMap.put("username", AuthenticationHelper.getUserName());
        System.out.println("Rendering Home...");
        return "Home";
    }

    @RequestMapping(value = { "/public" })
    public String homeAnonymus(ModelMap modelMap) {
        modelMap.put("username", AuthenticationHelper.getUserName());
        System.out.println("Rendering Home...");
        return "Home";
    }
}
