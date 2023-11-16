package com.VirtualVision.VirtualVision.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.VirtualVision.VirtualVision.dao.UserDao;
import com.VirtualVision.VirtualVision.domain.User;


@Service
public class UserService implements ServicesInterface{
    @Autowired
    private UserDao userDao;
    
    @Override
    public ArrayList<User> listarUsuarios() {
        return (ArrayList<User>) userDao.findAll();
    }
}
