package com.anttribe.docgenerator.out.handler;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.anttribe.docgenerator.exception.DocGeneratorException;
import com.anttribe.docgenerator.out.Output;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @author zhaoyong
 * @date 2021/11/21 0021
 */
public class PdfOutputFileHandler extends AbstractOutputFileHandler {

    /**
     * 默认黑体
     */
    private static final String DEFAULT_PDF_FONT = "fonts/simhei.ttf";

    private Document document;

    private PdfWriter pdfWriter;

    @Override
    public void preHandle(Output output) {
        document = new Document(PageSize.A4);
        try {
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(output.getOutputFile()));
            document.open();
        } catch (DocumentException | FileNotFoundException e) {
            throw new DocGeneratorException(e);
        }
    }

    @Override
    public void postHandle(Output output) {
        // 文档内容
        String content = output.getOutString();

        XMLWorkerFontProvider xmlWorkerFontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        xmlWorkerFontProvider.register(DEFAULT_PDF_FONT);
        try {
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document,
                new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null, Charset.forName("UTF-8"),
                xmlWorkerFontProvider);
        } catch (IOException e) {
            throw new DocGeneratorException(e);
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }
}
