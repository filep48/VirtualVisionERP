package com.VirtualVision.VirtualVision.controller.pdf;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VirtualVision.VirtualVision.domain.User;
import com.VirtualVision.VirtualVision.services.pdf.PdfService;
import com.VirtualVision.VirtualVision.services.user.UserServiceImpl;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;
    @Autowired
    private UserServiceImpl UserService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf() {
        String content = "Este es el contenido del PDF";
        User user = UserService.buscarUsuario(1L);
        ByteArrayInputStream bis = pdfService.generatePdf(content, user);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=pdf-from-springboot.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(bis.readAllBytes());
    }
}