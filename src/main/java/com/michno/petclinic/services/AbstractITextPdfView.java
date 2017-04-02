package com.michno.petclinic.services;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by arkad on 27.03.2017.
 */
public abstract class AbstractITextPdfView extends AbstractView {

    public AbstractITextPdfView() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = createTemporaryOutputStream();

        Document document = newDocument();
        PdfWriter pdfWriter = newWriter(document, baos);
        prepareWriter(model, pdfWriter, request);
        buildPdfMetaData(model, document, request);

        document.open();
        buildPdfDocument(model, document, pdfWriter, request, response);
        document.close();

        writeToResponse(response, baos);
    }

    protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws DocumentException, Exception;

    protected void buildPdfMetaData(Map<String, Object> model, Document document, HttpServletRequest request) {

    }

    protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request) {
        writer.setViewerPreferences(getViewerPreferences());
    }

    protected PdfWriter newWriter(Document document, ByteArrayOutputStream baos) throws DocumentException {
        return PdfWriter.getInstance(document, baos);
    }

    protected Document newDocument() {
        return new Document(PageSize.A4);
    }

    public int getViewerPreferences() {
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

}
