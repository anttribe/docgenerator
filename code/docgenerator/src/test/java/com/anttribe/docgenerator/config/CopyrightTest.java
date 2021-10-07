package com.anttribe.docgenerator.config;

import org.junit.Test;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class CopyrightTest {

    @Test
    public void testCopyright() {
        Copyright copyright = Copyright.builder().author("anttribe").build();
        System.out.println(copyright);
    }

}
