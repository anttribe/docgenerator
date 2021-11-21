package com.anttribe.docgenerator.engine;

import java.io.File;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.OutputConfiguration;
import com.anttribe.docgenerator.in.DataModel;
import com.anttribe.docgenerator.out.FileType;
import com.anttribe.docgenerator.out.Output;
import com.anttribe.docgenerator.out.handler.OutputFileHandler;
import com.anttribe.docgenerator.out.handler.OutputFileHandlerFactory;
import com.anttribe.docgenerator.utils.naming.NamingHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyong
 * @date 2021/10/7 0007
 */
@Slf4j
public abstract class AbstractTemplateEngine implements TemplateEngine {

    protected Configuration configuration;

    public AbstractTemplateEngine(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Output process(DataModel dataModel) {
        // 校验模板文件
        validateTemplateFile(this.configuration.getTemplateConfig().getTemplateFile());

        // 创建输出
        Output output = this.createOutput();
        FileType outputFileType = configuration.getOutputConfig().getOutputFileType();
        OutputFileHandler outputFileHandler = OutputFileHandlerFactory.me().getOutputFileHandler(outputFileType);
        if (null != outputFileHandler) {
            // 输出预处理
            outputFileHandler.preHandle(output);
        }

        processInternal(dataModel, output);

        if (null != outputFileHandler) {
            // 输出后处理
            outputFileHandler.postHandle(output);
        }
        return output;
    }

    /**
     * 内部处理机制
     *
     * @param dataModel
     *            数据模型
     * @param output
     *            输出
     */
    protected abstract void processInternal(DataModel dataModel, Output output);

    /**
     * 校验模板文件
     *
     * @param templateFile
     * @return boolean
     */
    private boolean validateTemplateFile(File templateFile) {
        if (null == templateFile) {
            log.error("template file must not be null");
            throw new TemplateEngineException("template file must not be null");
        }
        if (!templateFile.exists()) {
            log.error("template file does not exist");
            throw new TemplateEngineException("template file does not exist");
        }
        if (!templateFile.isFile()) {
            log.error("template file parameter is invalid");
            throw new TemplateEngineException("template file parameter invalid");
        }
        return Boolean.TRUE;
    }

    /**
     * 创建输出
     *
     * @return
     */
    protected Output createOutput() {
        return new OutputCreator(this.configuration.getOutputConfig()).create();
    }

    /**
     * 输出生成
     *
     * @author zhaoyong
     * @date 2021年4月14日
     */
    class OutputCreator {

        private OutputConfiguration outputConfiguration;

        public OutputCreator(OutputConfiguration outputConfiguration) {
            this.outputConfiguration = outputConfiguration;
        }

        /**
         * 创建输出
         *
         * @return
         */
        public Output create() {
            String outputDirectory = outputConfiguration.getOutputDirectory();
            // 获取输出文件
            String outputFilePath = getOutputFilepath(new File(outputDirectory));
            File outputFile = new File(outputFilePath);
            mkdirOutputDirectory(outputFile.getParentFile());

            // 输出文件
            Output output = new Output();
            output.setOutputFile(new File(outputFilePath));
            return output;
        }

        /**
         * 创建输出目录
         *
         * @param outputDirectoryFile
         *            输出目录文件
         */
        private void mkdirOutputDirectory(File outputDirectoryFile) {
            boolean mkdirs = Boolean.TRUE;
            if (!outputDirectoryFile.exists()) {
                // 自动创建文件输出目录
                mkdirs = outputDirectoryFile.mkdirs();
            }
            if (!mkdirs) {
                log.error("can not mkdir outputDirectory");
                throw new TemplateEngineException("can not mkdir outputDirectory");
            }
        }

        /**
         * 获取输出文件路径
         *
         * @param outputDirectoryFile
         * @return outputFilepath
         */
        private String getOutputFilepath(File outputDirectoryFile) {
            // 输出文件命名
            NamingHandler namingHandler = outputConfiguration.getNamingHandler();
            String outputFilename = namingHandler.naming() + (null != outputConfiguration.getOutputFileType()
                ? outputConfiguration.getOutputFileType().getFileSuffix() : "");
            return outputDirectoryFile.getPath() + File.separator + outputFilename;
        }

    }

}
