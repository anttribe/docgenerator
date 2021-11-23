package com.anttribe.docgenerator.out.handler;

import com.anttribe.docgenerator.out.Output;

/**
 * @author zhaoyong
 * @date 2021/10/7 0007
 */
public class DefaultOutputFileHandler extends AbstractOutputFileHandler {

    @Override
    public void preHandle(Output output) {
        // do something
    }

    @Override
    public void postHandle(Output output) {
        super.postHandle(output);
    }
}
