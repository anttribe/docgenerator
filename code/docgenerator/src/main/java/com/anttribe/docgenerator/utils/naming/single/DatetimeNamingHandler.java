package com.anttribe.docgenerator.utils.naming.single;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.anttribe.docgenerator.utils.naming.NamingHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class DatetimeNamingHandler implements NamingHandler {

    /**
     * 默认时间格式化字符串
     */
    protected static final String DEFAULT_FORMAT_PATTERN = "yyyyMMddHHmmssSSS";

    protected String formatPattern;

    public DatetimeNamingHandler() {
        this(DEFAULT_FORMAT_PATTERN);
    }

    public DatetimeNamingHandler(String formatPattern) {
        this.formatPattern = formatPattern;
    }

    @Override
    public String naming() {
        if (StringUtils.isEmpty(formatPattern)) {
            formatPattern = DEFAULT_FORMAT_PATTERN;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);

        return dateFormat.format(new Date());
    }

    public String getFormatPattern() {
        return formatPattern;
    }

    public void setFormatPattern(String formatPattern) {
        this.formatPattern = formatPattern;
    }

}