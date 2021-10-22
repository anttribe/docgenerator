package com.anttribe.docgenerator.config;

import com.anttribe.docgenerator.out.FileType;
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
    private FileType outputFileType = FileType.MAKEDOWN;

    /**
     * 输出文件命名处理类
     */
    @Builder.Default
    private NamingHandler namingHandler = new UuidNamingHandler();

}
