package com.VirtualVision.VirtualVision.services.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.VirtualVision.VirtualVision.dao.UserDao;
import com.VirtualVision.VirtualVision.domain.User;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    
    
    @Override
    public ArrayList<User> listAllUsers() {
        return (ArrayList<User>) userDao.findAll();
    }
    @Override
    public User buscarUsuario(Long id) {
        return userDao.findById(id).orElse(null);
    }
}
