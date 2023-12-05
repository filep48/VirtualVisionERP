package com.virtualvision.erp.service.context;

import lombok.Data;

@Data
public class UserContext {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String address;

    public UserContext(String username, String name, String lastname, String email, String phone, String address) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

}
