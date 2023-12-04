package com.virtualvision.erp.SpringCRUDAuthentication.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Albert Grau
 */
public class passwordEncript {

    public static String passwordEncript(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
