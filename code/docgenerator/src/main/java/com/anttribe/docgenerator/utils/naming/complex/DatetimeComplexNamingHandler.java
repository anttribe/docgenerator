package com.anttribe.docgenerator.utils.naming.complex;

import com.anttribe.docgenerator.utils.naming.single.DatetimeNamingHandler;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaoyong
 * @date 2021/10/22 0022
 */
public class DatetimeComplexNamingHandler extends DatetimeNamingHandler {

    @Override
    public String naming() {
        if (StringUtils.isEmpty(formatPattern)) {
            formatPattern = DatetimeNamingHandler.DEFAULT_FORMAT_PATTERN;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);

        return dateFormat.format(new Date());
    }

}
