package com.VirtualVision.VirtualVision.services.user;

import java.util.ArrayList;

import com.VirtualVision.VirtualVision.domain.User;

public interface UserService {
    ArrayList<User> listAllUsers();
    User buscarUsuario(Long id);
}
