package com.VirtualVision.VirtualVision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.VirtualVision.VirtualVision.services.user.UserService;

@SpringBootApplication
public class VirtualVisionApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(VirtualVisionApplication.class, args);
		try {
			UserService servicesInterface = context.getBean(UserService.class);
			System.out.println(servicesInterface.listAllUsers());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
