package com.virtualvision.erp.SpringCRUDAuthentication.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordEncrypter {


    public static String passwordEncrypter(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
