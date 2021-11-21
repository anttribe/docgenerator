package com.anttribe.docgenerator.out.handler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.anttribe.docgenerator.exception.DocGeneratorException;
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
