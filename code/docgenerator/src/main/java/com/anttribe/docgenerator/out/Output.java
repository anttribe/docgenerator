package com.anttribe.docgenerator.out;

import java.io.File;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Getter
@Setter
@ToString
public class Output {

    /**
     * 输出文件
     */
    private File outputFile;

    /**
     * 输出字符串
     */
    @ToString.Exclude
    private String outString;

}
