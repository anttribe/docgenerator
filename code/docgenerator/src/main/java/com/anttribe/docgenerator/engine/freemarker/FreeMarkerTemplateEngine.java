package com.anttribe.docgenerator.engine.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.TemplateConfiguration;
import com.anttribe.docgenerator.engine.AbstractTemplateEngine;
import com.anttribe.docgenerator.engine.TemplateEngineException;
import com.anttribe.docgenerator.in.DataModel;
import com.anttribe.docgenerator.out.Output;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Slf4j
public class FreeMarkerTemplateEngine extends AbstractTemplateEngine {

    public FreeMarkerTemplateEngine(Configuration configuration) {
        super(configuration);
    }

    @Override
    public Output process(DataModel dataModel) {
        // 加载模板
        Template template = new TemplateLoader(this.configuration.getTemplateConfig()).loadTemplate();
        if (null == template) {
            log.warn("unavailable template file");
            throw new TemplateEngineException("unavailable template file");
        }

        log.info("start generating document with dataModel[{}] and template[{}]", dataModel, template.getName());
        // 生成文档
        Output output = this.createOutput();
        if (null != output && null != output.getOutputFile()) {
            try (Writer out = new FileWriter(output.getOutputFile())) {
                // 模版 + 数据
                template.process(dataModel.getModelMap(), out);
                out.flush();

                log.info("end generating document with dataModel[{}] and template[{}]", dataModel, template.getName());
            } catch (IOException | TemplateException e) {
                log.error("process datamodel with template get error, cause: {}", e);
                throw new TemplateEngineException("process datamodel with template get error", e);
            }
        }
        return output;
    }

    /**
     * 模板加载
     *
     * @author zhaoyong
     * @date 2021年2月17日
     */
    class TemplateLoader {

        /**
         * 默认编码
         */
        private static final String DEFAULT_ENCODING = "UTF-8";

        private TemplateConfiguration templateConfiguration;

        public TemplateLoader(TemplateConfiguration templateConfiguration) {
            this.templateConfiguration = templateConfiguration;
        }

        /**
         * 加载模板
         *
         * @return
         */
        public Template loadTemplate() {
            File templateFile = null != templateConfiguration ? templateConfiguration.getTemplateFile() : null;
            if (!validateTemplateFile(templateFile)) {
                return null;
            }

            // FreeMarker模板配置
            freemarker.template.Configuration freeMarkerConfiguration = new freemarker.template.Configuration(
                freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            freeMarkerConfiguration.setDefaultEncoding(DEFAULT_ENCODING);
            freeMarkerConfiguration.setAutoFlush(Boolean.TRUE);
            try {
                // 加载模板目录
                freeMarkerConfiguration.setDirectoryForTemplateLoading(templateFile.getParentFile());
                return freeMarkerConfiguration.getTemplate(templateFile.getName());
            } catch (IOException e) {
                log.error("failed to load template file, cause: {}", e);
                throw new TemplateEngineException("failed to load template file", e);
            }
        }

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

    }

}
