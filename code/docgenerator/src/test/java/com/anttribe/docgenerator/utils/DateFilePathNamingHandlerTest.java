package com.anttribe.docgenerator.utils;

import org.junit.Test;

import com.anttribe.docgenerator.utils.naming.complex.DateFilePathNamingHandler;
import com.anttribe.docgenerator.utils.naming.single.DatetimeNamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/22 0022
 */
public class DateFilePathNamingHandlerTest {

    @Test
    public void testNaming() {
        DateFilePathNamingHandler namingHandler = new DateFilePathNamingHandler(new DatetimeNamingHandler());
        String naming = namingHandler.naming();
        System.out.println(naming);
    }

}
