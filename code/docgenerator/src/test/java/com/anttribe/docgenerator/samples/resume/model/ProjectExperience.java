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
public class ProjectExperience {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目时间（起）
     */
    private String projectStartDate;

    /**
     * 项目时间(止)
     */
    private String projectEndDate;

    /**
     * 项目描述
     */
    private String projectDescription;

    /**
     * 职责
     */
    private String duty;

    /**
     * 业绩
     */
    private String performance;

}
