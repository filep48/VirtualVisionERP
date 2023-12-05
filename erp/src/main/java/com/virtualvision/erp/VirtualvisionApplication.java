package com.virtualvision.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtualvision.erp.service.CustomerServiceImp;
import com.virtualvision.erp.service.employee.EmployeServiceImp;

@SpringBootApplication
public class VirtualvisionApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(VirtualvisionApplication.class, args);
		try {
			CustomerServiceImp customerService = context.getBean(CustomerServiceImp.class);
			EmployeServiceImp employeeService = context.getBean(EmployeServiceImp.class);
			System.out.println(customerService.FindAll());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
