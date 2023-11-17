package com.VirtualVision.VirtualVision;

import java.security.Provider.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.VirtualVision.VirtualVision.services.ServicesInterface;

@SpringBootApplication
public class VirtualVisionApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(VirtualVisionApplication.class, args);
		try {
			ServicesInterface servicesInterface = context.getBean(ServicesInterface.class);
			System.out.println(servicesInterface.listarUsuarios());
			int existe = 6;

			String resultado = existe > 5 ? "Es mayor a 5" : "Es menor a 5";

			System.out.println(resultado);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
