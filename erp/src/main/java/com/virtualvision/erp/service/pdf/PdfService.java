package com.virtualvision.erp.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.domain.Sale;

@Service
public class PdfService {

    public ByteArrayInputStream generatePdf(Sale sale, Customer customer) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PdfFont titleFont = null;
        try {
            titleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            Paragraph title = new Paragraph("Resumen de Venta")
                    .setFont(titleFont)
                    .setFontSize(16)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(title);
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        // Estilo de fuente en negrita para la tabla
        PdfFont boldFont = null;
        try {
            boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        } catch (IOException e) {
            e.printStackTrace();
        
        }

        // Creación de la tabla para los detalles de la venta
        Table saleTable = new Table(new float[] { 1, 3 }).useAllAvailableWidth();

        // Añadir encabezados de la tabla
        saleTable.addCell(new Cell().add(new Paragraph("Campo").setFont(boldFont)));
        saleTable.addCell(new Cell().add(new Paragraph("Detalle").setFont(boldFont)));

        // Añadir filas con detalles de la venta
        saleTable.addCell("ID de Venta");
        saleTable.addCell(sale.getId().toString());
        saleTable.addCell("Cliente");
        saleTable.addCell(customer.getName());
        saleTable.addCell("Cantidad");
        saleTable.addCell(Integer.toString(sale.getQuantity()));
        saleTable.addCell("Valor de Impuesto");
        saleTable.addCell(Double.toString(sale.getTaxValue()));
        saleTable.addCell("Fecha de Venta");
        saleTable.addCell(sale.getSaleDate().toString());
        saleTable.addCell("Producto");
        saleTable.addCell(sale.getProducts().toString());
        saleTable.addCell("Evento");
        saleTable.addCell(sale.getEvents().toString());

        document.add(saleTable);

        // ... [Código existente para añadir detalles del cliente] ...

        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
    
}
