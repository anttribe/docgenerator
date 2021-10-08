package com.anttribe.docgenerator.engine.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.TemplateConfiguration;
import com.anttribe.docgenerator.constants.Constants;
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
    protected void processInternal(DataModel dataModel, Output output) {
        // 加载模板
        Template template = new TemplateLoader(this.configuration.getTemplateConfig()).loadTemplate();
        if (null == template) {
            log.warn("unavailable template file");
            throw new TemplateEngineException("unavailable template file");
        }

        log.info("start generating document with dataModel[{}] and template[{}]", dataModel, template.getName());
        // 生成文档
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

    /**
     * 模板加载
     *
     * @author zhaoyong
     * @date 2021年2月17日
     */
    class TemplateLoader {

        private TemplateConfiguration templateConfiguration;

        public TemplateLoader(TemplateConfiguration templateConfiguration) {
            this.templateConfiguration = templateConfiguration;
        }

        /**
         * 加载模板
         *
         * @return Template
         */
        public Template loadTemplate() {
            File templateFile = templateConfiguration.getTemplateFile();
            // FreeMarker模板配置
            freemarker.template.Configuration freeMarkerConfiguration = new freemarker.template.Configuration(
                freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            freeMarkerConfiguration.setDefaultEncoding(Constants.DEFAULT_ENCODING);
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

    }

}
