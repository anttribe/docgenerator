package com.anttribe.docgenerator;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.engine.TemplateEngine;
import com.anttribe.docgenerator.engine.TemplateEngineException;
import com.anttribe.docgenerator.engine.TemplateEngineFactory;
import com.anttribe.docgenerator.exception.DocGeneratorException;
import com.anttribe.docgenerator.in.DataModel;
import com.anttribe.docgenerator.out.Output;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Slf4j
public class DocGenerator {

    private Configuration configuration;

    public DocGenerator(Configuration configuration) {
        if (null == configuration) {
            log.warn("not setting configuration, may use the default");
            configuration = Configuration.DEFAULT_CONFIGURATION;
        }
        this.configuration = configuration;
    }

    /**
     * 根据DataModel数据生成文档
     *
     * @param dataModel 模型数据
     * @return Output输出
     */
    public Output generate(DataModel dataModel) {
        if (null == dataModel) {
            log.warn("dataModel is null, use the empty model");
            dataModel = DataModel.EMPTY;
        }

        TemplateEngine templateEngine = TemplateEngineFactory.me().getTemplateEngine(this.configuration);
        if (null == templateEngine) {
            log.error("can not get TemplateEngine with template configuration: {}",
                this.configuration.getTemplateConfig());
            throw new DocGeneratorException("can not get TemplateEngine with template configuration");
        }

        try {
            return templateEngine.process(dataModel);
        }
        catch (TemplateEngineException e) {
            throw new DocGeneratorException(e);
        }
    }

}