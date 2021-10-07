package com.anttribe.docgenerator.engine;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.TemplateConfiguration;

/**
 * @author zhaoyong
 * @date 2021/10/7 0007
 */
public class TemplateEngineFactory {

    private TemplateEngineFactory() {
    }

    /**
     * 静态单例实现
     *
     * @return
     */
    public static TemplateEngineFactory me() {
        return TemplateEngineFactoryInstance.INSTANCE;
    }

    /**
     * 获取模板引擎
     *
     * @param configuration Configuration
     * @return TemplateEngine
     */
    public TemplateEngine getTemplateEngine(Configuration configuration) {
        // 从配置中获取到模板配置
        TemplateConfiguration templateConfiguration = configuration.getTemplateConfig();
        TemplateEngineType templateEngineType = templateConfiguration.getTemplateEngineType();
        if (null == templateEngineType) {
            throw new TemplateEngineException("unsupported Template Type");
        }
        return this.getTemplateEngine(templateEngineType, configuration);
    }

    /**
     * 获取模板引擎
     *
     * @param templateEngineType TemplateEngineType
     * @param configuration Configuration
     * @return TemplateEngine
     */
    private TemplateEngine getTemplateEngine(TemplateEngineType templateEngineType, Configuration configuration) {
        Class<? extends TemplateEngine> engineClass = templateEngineType.getEngineClass();
        try {
            // 构造带Configuration参数的TemplateEngine
            Constructor<? extends TemplateEngine> costructor = engineClass.getConstructor(Configuration.class);
            return costructor.newInstance(configuration);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new TemplateEngineException(e);
        }
    }

    private static class TemplateEngineFactoryInstance {

        public static final TemplateEngineFactory INSTANCE = new TemplateEngineFactory();

    }
}
