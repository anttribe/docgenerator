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
public abstract class AbstractOutputFileHandler implements OutputFileHandler {

    @Override
    public void postHandle(Output output) {
        try (Writer out = new FileWriter(output.getOutputFile())) {
            out.write(output.getOutString());
            out.flush();
        } catch (IOException e) {
            throw new DocGeneratorException(e);
        }
    }

}
