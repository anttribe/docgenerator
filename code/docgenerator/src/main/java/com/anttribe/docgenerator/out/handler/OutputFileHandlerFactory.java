package com.anttribe.docgenerator.out.handler;

import com.anttribe.docgenerator.exception.DocGeneratorException;
import com.anttribe.docgenerator.out.FileType;

/**
 * @author zhaoyong
 * @date 2021/11/21 0021
 */
public class OutputFileHandlerFactory {

    /**
     * <私有>
     */
    private OutputFileHandlerFactory() {}

    public static OutputFileHandlerFactory me() {
        return OutputFileHandlerFactoryInstance.INSTANCE;
    }

    /**
     * 获取OutputFileHandler，根据FileType生成对应handler对象
     *
     * @param fileType
     *            FileType
     * @return OutputFileHandler
     */
    public OutputFileHandler getOutputFileHandler(FileType fileType) {
        Class<? extends OutputFileHandler> outputFileHandlerClass = null;
        if (null != fileType) {
            outputFileHandlerClass = fileType.getOutputFileHandlerClass();
        }

        if (null == outputFileHandlerClass) {
            outputFileHandlerClass = DefaultOutputFileHandler.class;
        }

        try {
            return outputFileHandlerClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DocGeneratorException(e);
        }
    }

    private static class OutputFileHandlerFactoryInstance {

        public static final OutputFileHandlerFactory INSTANCE = new OutputFileHandlerFactory();

    }
}
