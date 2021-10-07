package com.anttribe.docgenerator.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Builder
@Getter
@ToString
public class Configuration {

    /**
     * 默认配置
     */
    public static final Configuration DEFAULT_CONFIGURATION = Configuration.builder().build();

    /**
     * 版本信息
     */
    private Copyright copyright;

    /**
     * 模板配置
     */
    private TemplateConfiguration templateConfig;

    /**
     * 输出配置
     */
    private OutputConfiguration outputConfig;

}
