package com.VirtualVision.VirtualVision;

import java.security.Provider.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.VirtualVision.VirtualVision.domain.Chat;
import com.VirtualVision.VirtualVision.services.chat.ChatService;
import com.VirtualVision.VirtualVision.services.user.UserService;

@SpringBootApplication
public class VirtualVisionApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(VirtualVisionApplication.class, args);
		try {
			UserService servicesInterface = context.getBean(UserService.class);
			ChatService chatService = context.getBean(ChatService.class);
			System.out.println(servicesInterface.listAllUsers());
			
			System.out.println(chatService.listAllChats());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
