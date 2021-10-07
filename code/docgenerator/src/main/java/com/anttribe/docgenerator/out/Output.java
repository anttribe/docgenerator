package com.anttribe.docgenerator.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;

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

}
