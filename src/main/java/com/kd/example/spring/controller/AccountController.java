package com.kd.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kd.example.spring.dao.AccountDao;
import com.kd.example.spring.model.Account;
import com.kd.example.spring.model.Role;

@Controller
public class AccountController {
    @Autowired
    AccountDao accountDao;
    @Autowired
    StandardPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/j_spring_security_logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        System.out.println("Logged out successfully...");
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(ModelMap modelMap) {
        return "logout";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderSignup(ModelMap modelMap) {

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignup(ModelMap modelMap, String firstName, String lastName, String email, String password) {
        Account account = new Account();
        account.setAccountNonExpired(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
        account.setEnabled(true);
        account.setUsername(email);
        account.setPassword(passwordEncoder.encode(password));
        List<Role> roles = new ArrayList<Role>();
        roles.add(new Role("Admin"));
        account.setRoles(roles);
        accountDao.save(account);
        return "redirect:/login";
    }

}
