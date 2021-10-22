package com.anttribe.docgenerator.utils.naming.complex;

import com.anttribe.docgenerator.utils.naming.NamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/22 0022
 */
public abstract class ComplexNamingHandler implements NamingHandler {

    private NamingHandler innerNamingHandler;

    public ComplexNamingHandler(NamingHandler innerNamingHandler) {
        this.innerNamingHandler = innerNamingHandler;
    }

    @Override
    public String naming() {
        String naming = "";
        if (null != innerNamingHandler) {
            naming = innerNamingHandler.naming();
        }
        return naming;
    }

}
