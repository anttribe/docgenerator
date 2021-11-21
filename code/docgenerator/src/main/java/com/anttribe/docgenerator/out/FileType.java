package com.anttribe.docgenerator.out;

import com.anttribe.docgenerator.out.handler.DefaultOutputFileHandler;
import com.anttribe.docgenerator.out.handler.HtmlOutputFileHandler;
import com.anttribe.docgenerator.out.handler.MakedownOutputFileHandler;
import com.anttribe.docgenerator.out.handler.OutputFileHandler;
import com.anttribe.docgenerator.out.handler.PdfOutputFileHandler;
import com.anttribe.docgenerator.out.handler.WordOutputFileHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Getter
@AllArgsConstructor
public enum FileType {

    /** 生成HTML文件 */
    HTML(".html", HtmlOutputFileHandler.class),
    /** 生成TXT文件 */
    TXT(".txt", DefaultOutputFileHandler.class),
    /** 生成MAKEDOWN文件 */
    MAKEDOWN(".md", MakedownOutputFileHandler.class),
    /** 生成WORD文件 */
    WORD(".docx", WordOutputFileHandler.class),
    /** 生成WORD文件 */
    PDF(".pdf", PdfOutputFileHandler.class);

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 输出文件处理类
     */
    private Class<? extends OutputFileHandler> outputFileHandlerClass;

}
