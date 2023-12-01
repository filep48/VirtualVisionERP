package com.virtualvision.erp.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.virtualvision.erp.domain.Customer;

@Service
public class PdfService {

    public ByteArrayInputStream generatePdf(String content, Customer user) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Añadir cabecera con título "VisualVision"
        Color orangeColor = new DeviceRgb(255, 113, 0);
        PdfFont headerFont = null;
        try {
            headerFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            Paragraph header = new Paragraph("VisualVision")
                    .setFont(headerFont)
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(orangeColor)
                    .setBold();
            document.add(header);
        } catch (IOException e) {
            e.printStackTrace();
            // Considera manejar esta excepción de manera más adecuada.
        }

        document.add(new Paragraph(content));

        // Estilo de fuente en negrita para la tabla
        PdfFont boldFont = null;
        try {
            boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        } catch (IOException e) {
            e.printStackTrace();
            // Considera manejar esta excepción de manera más adecuada.
        }

        // Creación de la tabla
        float[] columnWidths = { 1, 3, 2 };
        Table table = new Table(UnitValue.createPercentArray(columnWidths))
                .useAllAvailableWidth();

        // Añadir celdas de cabecera en negrita
        table.addCell(new Cell().add(new Paragraph("Nombre").setFont(boldFont)));
        table.addCell(new Cell().add(new Paragraph("Apellido").setFont(boldFont)));
        table.addCell(new Cell().add(new Paragraph("Telefono").setFont(boldFont)));

        // Añadir celdas con datos del usuario
        table.addCell(user.getName());
        table.addCell(user.getSurname());
        table.addCell(user.getPhone());

        document.add(table);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
