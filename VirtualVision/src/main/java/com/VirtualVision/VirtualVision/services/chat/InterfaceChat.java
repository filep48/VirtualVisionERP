package com.VirtualVision.VirtualVision.services.chat;

import java.util.ArrayList;

import com.VirtualVision.VirtualVision.dao.IChatDao;
import com.VirtualVision.VirtualVision.domain.Chat;

public interface InterfaceChat {
    public ArrayList<Chat> listAllChats();
    
}
