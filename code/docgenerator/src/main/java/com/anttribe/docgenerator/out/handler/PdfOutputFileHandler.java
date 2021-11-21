package com.anttribe.docgenerator.out.handler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.anttribe.docgenerator.exception.DocGeneratorException;
import com.anttribe.docgenerator.out.Output;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author zhaoyong
 * @date 2021/11/21 0021
 */
public class PdfOutputFileHandler extends AbstractOutputFileHandler {

    private Document document;

    @Override
    public void preHandle(Output output) {
        document = new Document(PageSize.A4);
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(output.getOutputFile()));
            document.open();
        } catch (DocumentException | FileNotFoundException e) {
            throw new DocGeneratorException(e);
        }
    }

    @Override
    public void postHandle(Output output) {
        try {
            // 添加内容
            document.add(new Paragraph(output.getOutString()));
        } catch (DocumentException e) {
            throw new DocGeneratorException(e);
        } finally {
            document.close();
        }
    }
}
