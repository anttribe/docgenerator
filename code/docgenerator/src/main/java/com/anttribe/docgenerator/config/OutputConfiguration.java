package com.anttribe.docgenerator.config;

import com.anttribe.docgenerator.out.OutputFileType;
import com.anttribe.docgenerator.out.SupportedOutputFileType;
import com.anttribe.docgenerator.out.handler.OutputFileHandler;
import com.anttribe.docgenerator.utils.naming.NamingHandler;
import com.anttribe.docgenerator.utils.naming.single.UuidNamingHandler;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Builder
@Getter
@ToString
public class OutputConfiguration {

    /**
     * 输出文件目录
     */
    @Builder.Default
    private String outputDirectory = System.getProperty("user.dir");

    /**
     * 输出文件类型
     */
    @Builder.Default
    private OutputFileType outputFileType = SupportedOutputFileType.TXT;

    /**
     * 输出文件处理器
     */
    private Class<? extends OutputFileHandler> outputFileHandlerClass;

    /**
     * 输出文件命名处理类
     */
    @Builder.Default
    private NamingHandler namingHandler = new UuidNamingHandler();

}
