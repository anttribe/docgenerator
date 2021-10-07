package com.anttribe.docgenerator.utils.naming;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class TimeMillisNamingHandler implements NamingHandler {

    @Override
    public String naming() {
        return "" + System.currentTimeMillis();
    }

}
