package com.michno.petclinic.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.michno.petclinic.entity.Owner;
import com.michno.petclinic.entity.Pet;
import com.michno.petclinic.entity.Vet;

/**
 * Created by arkad on 27.03.2017.
 */
public class PDFBuilder extends AbstractITextPdfView {

    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Pet> thePets = (List<Pet>) model.get("pets");
        document.add(new Paragraph("Pets in Clinic added today"));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{3.0f, 3.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(4);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Type", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Age", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Owner", font));
        table.addCell(cell);

        List<Pet> thePetsOfToday = new ArrayList<Pet>();
        for(Pet thePet : thePets)
            if(thePet.getLocalDate().equals(LocalDate.now()))
                thePetsOfToday.add(thePet);

        for (Pet thePet : thePetsOfToday) {
            table.addCell(thePet.getName());
            table.addCell(thePet.getType());
            table.addCell(thePet.getAge());
            table.addCell(thePet.getOwnerName());
        }
        document.add(table);

    }
}
