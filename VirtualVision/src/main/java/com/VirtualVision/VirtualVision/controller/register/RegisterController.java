package com.VirtualVision.VirtualVision.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.VirtualVision.VirtualVision.domain.User;
import com.VirtualVision.VirtualVision.services.register.RegisterInterface;

@Controller
public class RegisterController {

    @Autowired
    private RegisterInterface registerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Procesar los datos del formulario de registro
    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        if (!registerService.RegisterUser(user)) {
            model.addAttribute("errorMessage", "El usuario ya existe");
            return "register";
        } else {
            return "login";
        }
    }
}
