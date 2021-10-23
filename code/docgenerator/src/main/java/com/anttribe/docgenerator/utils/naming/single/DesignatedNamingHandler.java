package com.anttribe.docgenerator.utils.naming.single;

import com.anttribe.docgenerator.utils.naming.NamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/23 0023
 */
public class DesignatedNamingHandler implements NamingHandler {

    private String name;

    public DesignatedNamingHandler(String name) {
        this.name = name;
    }

    @Override
    public String naming() {
        return this.name;
    }
}
