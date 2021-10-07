package com.anttribe.docgenerator.out;

import com.anttribe.docgenerator.out.typehandler.DefaultFileTypeHandler;
import com.anttribe.docgenerator.out.typehandler.FileTypeHandler;

import lombok.Getter;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Getter
public enum FileType {

    HTML(".html", ""), TXT(".txt", ""), MAKEDOWN(".md", ""), WORD(".docx", "");

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 文件处理器
     */
    private FileTypeHandler fileTypeHandler;

    private FileType(String fileSuffix) {
        this(fileSuffix, "", new DefaultFileTypeHandler());
    }

    private FileType(String fileSuffix, String description) {
        this(fileSuffix, description, new DefaultFileTypeHandler());
    }

    private FileType(String fileSuffix, String description, FileTypeHandler fileTypeHandler) {
        this.fileSuffix = fileSuffix;
        this.description = description;
        this.fileTypeHandler = fileTypeHandler;
    }

}
