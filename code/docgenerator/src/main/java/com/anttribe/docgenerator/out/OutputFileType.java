package com.anttribe.docgenerator.out;

import com.anttribe.docgenerator.out.handler.OutputFileHandler;

/**
 * @author zhaoyong
 * @date 2021/11/25 0025
 */
public interface OutputFileType {

    /**
     * 文件后缀
     *
     * @return String
     */
    String getFileSuffix();

    /**
     * 输出文件处理类
     *
     * @return Class<? extends OutputFileHandler>
     */
    Class<? extends OutputFileHandler> getOutputFileHandlerClass();

}
