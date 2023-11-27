package com.VirtualVision.VirtualVision.services.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VirtualVision.VirtualVision.dao.UserDao;

@Service
public class LoginService implements LoginInterface {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean iniciarSesion(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password) != null;
    }

}
