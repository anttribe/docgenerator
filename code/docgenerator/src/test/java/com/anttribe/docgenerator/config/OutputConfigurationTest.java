package com.anttribe.docgenerator.config;

import org.junit.Test;

import com.anttribe.docgenerator.utils.naming.single.DesignatedNamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class OutputConfigurationTest {

    @Test
    public void testOutputConfiguration() {
        OutputConfiguration outputConfiguration = OutputConfiguration.builder().build();
        System.out.println(outputConfiguration);
    }

    @Test
    public void testDesignatedNamingHandler() {
        String name = "指定文件名";
        OutputConfiguration outputConfiguration =
            OutputConfiguration.builder().namingHandler(new DesignatedNamingHandler(name)).build();
        System.out.println(outputConfiguration);
    }

}
