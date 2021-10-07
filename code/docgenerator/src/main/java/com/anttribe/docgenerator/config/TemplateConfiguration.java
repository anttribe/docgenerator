package com.anttribe.docgenerator.config;

import com.anttribe.docgenerator.engine.TemplateEngineType;
import com.anttribe.docgenerator.exception.DocGeneratorException;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Getter
@ToString
public class TemplateConfiguration {

    /**
     * 模板文件
     */
    private File templateFile;

    /**
     * 模板引擎类型
     */
    private TemplateEngineType templateEngineType;

    private TemplateConfiguration(File templateFile, TemplateEngineType templateEngineType) {
        this.templateFile = templateFile;
        this.templateEngineType = templateEngineType;
    }

    public static TemplateConfigurationBuilder builder() {
        return new TemplateConfigurationBuilder();
    }

    public static class TemplateConfigurationBuilder {

        /**
         * 模板文件(优先级高)
         */
        private File templateFile;

        /**
         * 模板文件路径
         */
        private String templateFilepath;

        public TemplateConfigurationBuilder templateFile(String templateFilepath) {
            this.templateFilepath = templateFilepath;
            return this;
        }

        public TemplateConfigurationBuilder templateFile(File templateFile) {
            this.templateFile = templateFile;
            return this;
        }

        /**
         * 构造TemplateConfiguration
         *
         * @return
         */
        public TemplateConfiguration build() {
            processTemplateFile();
            TemplateEngineType templateEngineType = processTemplateEngineType();

            TemplateConfiguration templateConfiguration = new TemplateConfiguration(templateFile, templateEngineType);
            return templateConfiguration;
        }

        /**
         * 处理模板文件
         */
        private void processTemplateFile() {
            if (null == templateFile && StringUtils.isEmpty(templateFilepath)) {
                throw new DocGeneratorException("must set the template file");
            }

            if (null == templateFile && !StringUtils.isEmpty(templateFilepath)) {
                // 对文件路径进行处理
                templateFilepath = templateFilepath.replace("\\", "/").replace("../", "").replace("./", "");
                if (StringUtils.isEmpty(templateFilepath)) {
                    throw new DocGeneratorException("invalid template file");
                }
                templateFile = new File(templateFilepath);
            }

            if (null == templateFile) {
                throw new DocGeneratorException("must set the template file");
            }

            // 文件是否存在
            if (!templateFile.exists()) {
                throw new DocGeneratorException("template file not exists");
            }
            if (!templateFile.isFile()) {
                throw new DocGeneratorException("invalid template file, must not be directory");
            }
        }

        /**
         * 处理模版引擎类型
         *
         * @return TemplateEngineType
         */
        private TemplateEngineType processTemplateEngineType() {
            String templateFileName = templateFile.getName();
            // 文件格式校验
            int index = templateFileName.lastIndexOf('.');
            if (index <= 0 || index > templateFileName.length() - 1) {
                throw new DocGeneratorException("unsupported this template file type");
            }

            String templateFileSuffix = templateFileName.substring(index, templateFileName.length());
            TemplateEngineType templateEngineType = TemplateEngineType.valueOfTemplateFileSuffix(templateFileSuffix);
            if (null == templateEngineType) {
                throw new DocGeneratorException("unsupported this template file type");
            }
            return templateEngineType;
        }

    }

}
