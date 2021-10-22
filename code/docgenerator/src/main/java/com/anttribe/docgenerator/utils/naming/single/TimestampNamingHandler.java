package com.anttribe.docgenerator.utils.naming.single;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class TimestampNamingHandler extends DatetimeNamingHandler {

    /**
     * 默认时间格式化字符串
     */
    private static final String DEFAULT_TIMESTAMP_FORMAT_PATTERN = "yyyyMMddHHmmssSSS";

    public TimestampNamingHandler() {
        super(DEFAULT_TIMESTAMP_FORMAT_PATTERN);
    }

}
