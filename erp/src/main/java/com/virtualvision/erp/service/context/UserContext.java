package com.virtualvision.erp.service.context;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserContext {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String userType;

    public UserContext(String username, String name, String lastname, String email, String phone, String address,
            String userType) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.userType = userType;
    }

    public UserContext() {
    }

}
