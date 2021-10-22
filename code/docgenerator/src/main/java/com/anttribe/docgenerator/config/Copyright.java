package com.anttribe.docgenerator.config;

import org.apache.commons.lang3.SystemUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 版本信息: Copyright © [时间] by [author/owner].All Rights Reserved.
 *
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
@Builder
@Getter
@ToString
public class Copyright {

    /**
     * 作者
     */
    @Builder.Default
    private String author = SystemUtils.USER_NAME;

}
