package com.VirtualVision.VirtualVision.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.VirtualVision.VirtualVision.domain.User;
import com.VirtualVision.VirtualVision.services.login.LoginInterface;

@Controller
public class LoginController {
    Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginInterface loginService;

    @GetMapping("/")
    public String showLogin(User user, Model model) {
        log.info("///////// Esta en el Get: " + user.getUsername() + "" + "/////////");
        return "login";
    }

    @PostMapping("/")
    public String iniciarSesion(User user, Model model) {
        if (loginService.iniciarSesion(user.getUsername(), user.getPassword())) {
            return "home";
        } else {
            return "login";
        }
    }

    @GetMapping("/home")
    public String showHome(User user, Model model) {
        return "home";
    }
}
