package com.anttribe.docgenerator.out.handler;

import com.anttribe.docgenerator.out.Output;

/**
 * 文件处理机
 *
 * @author zhaoyong
 * @date 2021/10/7 0007
 */
public interface OutputFileHandler {

    /**
     * 预处理输出文件
     *
     * @param output
     *            Output
     */
    void preHandle(Output output);

    /**
     * 后处理输出文件
     *
     * @param output
     *            Output
     */
    void postHandle(Output output);

}
