package com.virtualvision.erp.controller.pdf;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.domain.Sale;
import com.virtualvision.erp.service.pdf.PdfService;
import com.virtualvision.erp.service.sale.SaleServiceImp;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    private final PdfService pdfService;
    private final SaleServiceImp saleService; // Asume que tienes un servicio para obtener detalles de ventas

    public PdfController(PdfService pdfService, SaleServiceImp saleService) {
        this.pdfService = pdfService;
        this.saleService = saleService;
    }

    @GetMapping("/sale/generarpdf/{id}")
    public void generatePdf(@PathVariable Long id, HttpServletResponse response) {
        try {
            Sale sale = saleService.findSaleById(id); // Obtiene la venta por ID
            if (sale == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Venta no encontrada");
                return;
            }

            Customer customer = sale.getCustomer(); // Obtiene el cliente asociado a la venta

            // Generar el PDF
            ByteArrayInputStream pdfStream = pdfService.generatePdf(sale, customer); // Cambio aquí

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=sale_" + id + ".pdf");

            byte[] buffer = new byte[pdfStream.available()];
            pdfStream.read(buffer);
            response.getOutputStream().write(buffer);
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // crea un contructor que String y Customer

}
