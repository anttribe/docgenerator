package com.anttribe.docgenerator.engine;

import java.io.File;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.OutputConfiguration;
import com.anttribe.docgenerator.out.Output;
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
            if (null == outputConfiguration) {
                return null;
            }

            String outputDirectory = outputConfiguration.getOutputDirectory();
            File outputDirectoryFile = new File(outputDirectory);
            mkdirOutputDirectory(outputDirectoryFile);

            // 获取输出文件
            String outputFilePath = getOutputFilepath(outputDirectoryFile);
            File outputFile = new File(outputFilePath);
            if (null != outputConfiguration.getOutputFileType().getFileTypeHandler()) {
                outputConfiguration.getOutputFileType().getFileTypeHandler().handle(outputFile);
            }

            // 输出文件
            Output output = new Output();
            output.setOutputFile(outputFile);
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
