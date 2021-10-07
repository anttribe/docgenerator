package com.anttribe.docgenerator.config;

import org.junit.Test;

import java.io.File;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class TemplateConfigurationTest {

    @Test
    public void testTemplateConfiguration() {
        String templateFilepath = "/Testing/docgenerator/templates/freemarker/documentation_txt.ftl";
        File templateFile = new File("/Testing/docgenerator/templates/thymeleaf/documentation_html.html");
        TemplateConfiguration templateConfiguration = TemplateConfiguration.builder().templateFile(templateFile).templateFile(templateFilepath).build();
        System.out.println(templateConfiguration);
    }

}
