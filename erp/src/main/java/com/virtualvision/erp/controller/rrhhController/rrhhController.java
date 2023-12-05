package com.virtualvision.erp.controller.rrhhController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.virtualvision.erp.dao.IPayroll;
import com.virtualvision.erp.domain.Payroll;

@Controller
public class rrhhController {
    @Autowired
    private IPayroll payrollService;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/rrhh/{employeeId}/payrolls")
    public String showPayrollsForEmployee(@PathVariable Long employeeId, Model model) {
        // Obtener la lista de nóminas para el empleado por su ID
        List<Payroll> payrolls = payrollService.PayrollListById(employeeId);

        // Agregar la lista al modelo con el nombre "payrolls"
        model.addAttribute("payrolls", payrolls);

        // Devolver la vista que mostrará la lista de nóminas
        return "/views/RRHH/RHPanel";
    }

}