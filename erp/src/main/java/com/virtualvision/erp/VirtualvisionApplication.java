package com.virtualvision.erp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtualvision.erp.domain.Payroll;
import com.virtualvision.erp.service.CustomerServiceImp;
import com.virtualvision.erp.service.rrhh.rrhhService;

@SpringBootApplication
public class VirtualvisionApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(VirtualvisionApplication.class, args);
	}
}
