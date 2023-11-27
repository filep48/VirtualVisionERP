package com.VirtualVision.VirtualVision.services.chat;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VirtualVision.VirtualVision.dao.IChatDao;

import com.VirtualVision.VirtualVision.domain.Chat;

@Service
public class ChatService implements InterfaceChat{
    //create a function that returns a list of all chats
    @Autowired
    private IChatDao chatDao;

    @Override
    public ArrayList<Chat> listAllChats() {
        return (ArrayList<Chat>) chatDao.findAll();
    }

}
    

