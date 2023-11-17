package com.VirtualVision.VirtualVision.services;

import java.util.ArrayList;

import com.VirtualVision.VirtualVision.domain.User;

public interface ServicesInterface {
    ArrayList<User> listarUsuarios();
    User buscarUsuario(Long id);
    
}
