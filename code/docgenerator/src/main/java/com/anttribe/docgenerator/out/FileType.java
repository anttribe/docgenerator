package com.anttribe.docgenerator.out;

import com.anttribe.docgenerator.out.handler.DefaultOutputFileHandler;
import com.anttribe.docgenerator.out.handler.HtmlOutputFileHandler;
import com.anttribe.docgenerator.out.handler.MakedownOutputFileHandler;
import com.anttribe.docgenerator.out.handler.OutputFileHandler;
import com.anttribe.docgenerator.out.handler.WordOutputFileHandler;

import lombok.Getter;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Getter
public enum FileType {

    /** 生成HTML文件 */
    HTML(".html", new HtmlOutputFileHandler()),
    /** 生成TXT文件 */
    TXT(".txt"),
    /** 生成MAKEDOWN文件 */
    MAKEDOWN(".md", new MakedownOutputFileHandler()),
    /** 生成WORD文件 */
    WORD(".docx", new WordOutputFileHandler());

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 文件处理器
     */
    private OutputFileHandler fileTypeHandler;

    private FileType(String fileSuffix) {
        this(fileSuffix, new DefaultOutputFileHandler());
    }

    private FileType(String fileSuffix, OutputFileHandler outputFileHandler) {
        this.fileSuffix = fileSuffix;
        this.fileTypeHandler = fileTypeHandler;
    }

}
