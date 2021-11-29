package com.anttribe.docgenerator.samples.resume.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhaoyong
 * @date 2021/11/25 0025
 */
@Getter
@Setter
@ToString
public class WorkExperience {

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 在职时间（起）
     */
    private String onJobStartDate;

    /**
     * 在职时间(止)
     */
    private String obJobEndDate;

    /**
     * 职位
     */
    private String jobTitle;

    /**
     * 工作内容
     */
    private String workContent;

}
