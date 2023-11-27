package com.VirtualVision.VirtualVision.services.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VirtualVision.VirtualVision.dao.UserDao;
import com.VirtualVision.VirtualVision.domain.User;

@Service
public class RegisterService implements RegisterInterface {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean RegisterUser(User user) {
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            return false;
        } else {
            userDao.save(user);
            return true;
        }
    }

}
