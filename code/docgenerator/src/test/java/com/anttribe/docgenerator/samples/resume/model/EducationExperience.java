package com.anttribe.docgenerator.samples.resume.model;

import java.util.Date;

import com.anttribe.docgenerator.samples.resume.model.type.Degree;

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
public class EducationExperience {

    /**
     * 学校
     */
    private String school;

    /**
     * 专业
     */
    private String major;

    /**
     * 学历
     */
    private Degree degree;

    /**
     * 时间（起）
     */
    private String startDate;

    /**
     * 时间(止)
     */
    private String endDate;

    /**
     * 经历
     */
    private String experience;

}
