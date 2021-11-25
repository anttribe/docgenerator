package com.anttribe.docgenerator.out.handler;

import com.anttribe.docgenerator.config.OutputConfiguration;
import com.anttribe.docgenerator.exception.DocGeneratorException;
import com.anttribe.docgenerator.out.OutputFileType;

/**
 * @author zhaoyong
 * @date 2021/11/21 0021
 */
public class OutputFileHandlerFactory {

    /**
     * 默认值
     */
    private static final Class<? extends OutputFileHandler> DEFAULT_OUTPUT_FILEHANDLER_CLASS =
        DefaultOutputFileHandler.class;

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
     * @param outputConfig
     *            OutputConfiguration
     * @param outputFileType
     *            OutputFileType
     * @return OutputFileHandler
     */
    public OutputFileHandler getOutputFileHandler(OutputConfiguration outputConfig, OutputFileType outputFileType) {
        Class<? extends OutputFileHandler> outputFileHandlerClass = outputConfig.getOutputFileHandlerClass();
        if (null == outputFileHandlerClass && null != outputFileType) {
            outputFileHandlerClass = outputFileType.getOutputFileHandlerClass();
        }

        if (null == outputFileHandlerClass) {
            outputFileHandlerClass = DEFAULT_OUTPUT_FILEHANDLER_CLASS;
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
