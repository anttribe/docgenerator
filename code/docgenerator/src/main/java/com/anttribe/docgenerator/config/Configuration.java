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
     * 版本信息
     */
    @Builder.Default
    private Copyright copyright = Copyright.builder().build();

    /**
     * 模板配置
     */
    private TemplateConfiguration templateConfig;

    /**
     * 输出配置
     */
    @Builder.Default
    private OutputConfiguration outputConfig = OutputConfiguration.builder().build();

}
