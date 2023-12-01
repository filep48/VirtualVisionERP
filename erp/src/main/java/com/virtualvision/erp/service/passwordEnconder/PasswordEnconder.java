package com.virtualvision.erp.service.passwordEnconder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEnconder {
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
