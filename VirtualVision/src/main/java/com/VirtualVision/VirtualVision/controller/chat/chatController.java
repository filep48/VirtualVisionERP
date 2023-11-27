package com.VirtualVision.VirtualVision.controller.chat;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class chatController {
    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}

