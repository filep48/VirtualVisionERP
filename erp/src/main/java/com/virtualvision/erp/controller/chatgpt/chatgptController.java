package com.virtualvision.erp.controller.chatgpt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtualvision.erp.service.chatgpt.Chatbot;

@Controller
public class chatgptController {
    private final Chatbot chatbot;
    private final List<String> conversation = new ArrayList<>();

    public chatgptController(Chatbot chatbot) {
        this.chatbot = chatbot;
    }

    @GetMapping("/chat")
    public String chatPage(Model model) {
        model.addAttribute("conversation", conversation);
        return "/views/chatgpt/chat"; // Nombre del archivo HTML (sin la extensión .html)
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message, Model model) {
        conversation.add("Tú: " + message);
        String response = chatbot.chatGPT(message);
        // convierte de string a stringBuild
        conversation.add("GPT: " + response);
        model.addAttribute("conversation", conversation);
        return "/views/chatgpt/chat";
    }

}
