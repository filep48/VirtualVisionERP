package com.virtualvision.erp.controller.companyEvent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.CompanyEvent;
import com.virtualvision.erp.service.companyEvent.ICompanyEventService;

@Controller
public class CompanyEventController {
    @Autowired
    private ICompanyEventService companyEventService;

    // Lista todos los eventos
    @GetMapping("/companyEvent")
    public String listCompanyEvents(Model model) {
        List<CompanyEvent> events = companyEventService.findAllCompanyEvents();
        model.addAttribute("events", events);
        return "views/companyEvents/listCompanyEvents";
    }

    // Formulario para añadir eventos
    @GetMapping("/companyEvent/addEvent")
    public String addCompanyEventForm(Model model) {
        model.addAttribute("event", new CompanyEvent());
        model.addAttribute("editMode", false);
        return "views/companyEvents/addEvent";
    }

    // Guardar eventos
    @PostMapping("/companyEvent/saveEvent")
    public String saveCompanyEvent(CompanyEvent event) {
        companyEventService.saveCompanyEvent(event);
        return "redirect:/companyEvent";
    }

    // Eliminar eventos
    @GetMapping("/companyEvent/deleteEvent/{id}")
    public String deleteCompanyEvent(@PathVariable Long id) {
        companyEventService.deleteCompanyEvent(id);
        return "redirect:/companyEvent";
    }

    // Editar eventos
    @GetMapping("/companyEvent/editEvent/{id}")
    public String editCompanyEventForm(@PathVariable Long id, Model model) {
        CompanyEvent event = companyEventService.findCompanyEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("editMode", true);
        return "views/companyEvents/addEvent";
    }
}
