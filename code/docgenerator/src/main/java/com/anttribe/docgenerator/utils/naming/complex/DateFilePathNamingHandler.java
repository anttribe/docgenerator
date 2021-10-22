package com.anttribe.docgenerator.utils.naming.complex;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.anttribe.docgenerator.utils.naming.NamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/22 0022
 */
public class DateFilePathNamingHandler extends FilePathNamingHandler {

    /**
     * 默认时间格式化字符串
     */
    private static final String DEFAULT_FORMAT_PATTERN = "yyyyMMdd";

    protected String formatPattern;

    public DateFilePathNamingHandler(NamingHandler innerNamingHandler) {
        this(innerNamingHandler, DEFAULT_FORMAT_PATTERN);
    }

    public DateFilePathNamingHandler(NamingHandler innerNamingHandler, String formatPattern) {
        super(innerNamingHandler);
        this.formatPattern = formatPattern;
    }

    @Override
    protected String fileDirNaming() {
        if (StringUtils.isEmpty(formatPattern)) {
            formatPattern = DEFAULT_FORMAT_PATTERN;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);

        return dateFormat.format(new Date());
    }

}
