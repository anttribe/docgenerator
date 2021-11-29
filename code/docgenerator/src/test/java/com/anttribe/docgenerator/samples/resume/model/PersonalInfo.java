package com.anttribe.docgenerator.samples.resume.model;

import com.anttribe.docgenerator.samples.resume.model.type.Gender;
import com.anttribe.docgenerator.samples.resume.model.type.JobStatus;

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
public class PersonalInfo {

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avator;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 当前所在公司名
     */
    private String companyName;

    /**
     * 职位
     */
    private String jobTitle;

    /**
     * 工作年限
     */
    private Integer workExperience;

    /**
     * 求职状态
     */
    private JobStatus jobStatus;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

}
