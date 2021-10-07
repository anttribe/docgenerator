package com.anttribe.docgenerator.config;

import org.junit.Test;

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

}
