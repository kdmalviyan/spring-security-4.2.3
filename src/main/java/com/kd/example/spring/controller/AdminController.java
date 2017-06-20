package com.kd.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kd.example.spring.security.AuthenticationHelper;

@Controller
public class AdminController {

    @RequestMapping(value = { "/admin/home", "/admin" })
    public ModelAndView adminHome(ModelAndView modelAndView) {
        modelAndView.setViewName("admin_home");
        modelAndView.addObject("username", AuthenticationHelper.getUserName());
        return modelAndView;
    }
}
