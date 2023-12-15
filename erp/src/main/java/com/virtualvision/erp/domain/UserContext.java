package com.virtualvision.erp.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserContext {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String userType;

    public UserContext(Long id, String username, String name, String surname, String email, String phone,
            String address,
            String userType) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.userType = userType;
    }

    public UserContext() {
    }

}
