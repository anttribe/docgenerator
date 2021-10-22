package com.anttribe.docgenerator.utils.naming.single;

import com.anttribe.docgenerator.utils.naming.NamingHandler;

import java.util.UUID;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class UuidNamingHandler implements NamingHandler {

    @Override
    public String naming() {
        String s = UUID.randomUUID().toString().toUpperCase();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

}
