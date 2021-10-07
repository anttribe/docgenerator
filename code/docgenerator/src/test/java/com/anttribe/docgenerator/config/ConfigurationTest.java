package com.anttribe.docgenerator.config;

import org.junit.Test;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class ConfigurationTest {

    @Test
    public void testConfiguration() {
        String templateFilepath = "/Testing/docgenerator/templates/freemarker/documentation_txt.ftl";
        Configuration configuration = Configuration.builder()
            .copyright(Copyright.builder().build())
            .templateConfig(TemplateConfiguration.builder().templateFile(templateFilepath).build())
            .outputConfig(OutputConfiguration.builder().build())
            .build();
        System.out.println(configuration);
    }

}
