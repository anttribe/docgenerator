package com.anttribe.docgenerator.samples.resume.model;

import java.util.List;

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
public class Resume {

    /**
     * 个人信息
     */
    private PersonalInfo personalInfo;

    /**
     * 自我描述
     */
    private String selfDescription;

    /**
     * 工作经历
     */
    private List<WorkExperience> workExperiences;

    /**
     * 项目经历
     */
    private List<ProjectExperience> projectExperiences;

    /**
     * 教育经历
     */
    private List<EducationExperience> educationExperiences;

}
