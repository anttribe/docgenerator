package com.anttribe.docgenerator.out.typehandler;

import java.io.File;

/**
 * 文件处理机
 *
 * @author zhaoyong
 * @date 2021/10/7 0007
 */
public interface FileTypeHandler {

    /**
     * 处理输出文件
     *
     * @param outputFile
     */
    void handle(File outputFile);

}
