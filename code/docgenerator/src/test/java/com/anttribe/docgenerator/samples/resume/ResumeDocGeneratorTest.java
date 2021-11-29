package com.anttribe.docgenerator.samples.resume;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.anttribe.docgenerator.out.Output;
import com.anttribe.docgenerator.out.SupportedOutputFileType;
import com.anttribe.docgenerator.samples.resume.model.EducationExperience;
import com.anttribe.docgenerator.samples.resume.model.PersonalInfo;
import com.anttribe.docgenerator.samples.resume.model.ProjectExperience;
import com.anttribe.docgenerator.samples.resume.model.Resume;
import com.anttribe.docgenerator.samples.resume.model.WorkExperience;
import com.anttribe.docgenerator.samples.resume.model.type.Degree;
import com.anttribe.docgenerator.samples.resume.model.type.Gender;
import com.anttribe.docgenerator.samples.resume.model.type.JobStatus;

/**
 * @author zhaoyong
 * @date 2021/11/26 0026
 */
public class ResumeDocGeneratorTest {

    private Resume resume;

    @Before
    public void initResume() {
        resume = new Resume();
        // 个人信息
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName("张三");
        personalInfo.setAvator("https://www.lgstatic.com/images/myresume/default_headpic.png");
        personalInfo.setCompanyName("南京鱼刺软件科技有限公司");
        personalInfo.setGender(Gender.MALE);
        personalInfo.setJobStatus(JobStatus.BETWEENJOBS);
        personalInfo.setJobTitle("Java工程师");
        personalInfo.setWorkExperience(10);
        personalInfo.setTelephone("15951900001");
        personalInfo.setEmail("abc@163.com");
        resume.setPersonalInfo(personalInfo);

        // 自我评价
        resume.setSelfDescription("良好的自学能力，很快可以做到熟练使用，满足项目需求。熟悉软件开发流程，了解敏捷开发模型。性格稳重，做事负责");

        // 工作经历
        List<WorkExperience> workExperiences = new ArrayList<>();
        WorkExperience workExperience1 = new WorkExperience();
        workExperience1.setCompanyName("南京鱼刺软件科技有限公司");
        workExperience1.setJobTitle("java开发兼组长");
        workExperience1.setOnJobStartDate("2015.08");
        workExperience1.setObJobEndDate("2016.03");
        workExperience1.setWorkContent("负责智慧社区项目商城模块的设计和开发");
        workExperiences.add(workExperience1);

        WorkExperience workExperience2 = new WorkExperience();
        workExperience2.setCompanyName("江苏达科有限公司");
        workExperience2.setJobTitle("java开发兼组长");
        workExperience2.setOnJobStartDate("2014.04");
        workExperience2.setObJobEndDate("2015.07");
        workExperience2.setWorkContent("负责基础教育云平台备课子系统的设计和开发");
        workExperiences.add(workExperience2);
        resume.setWorkExperiences(workExperiences);

        // 项目经历
        List<ProjectExperience> projectExperiences = new ArrayList<>();
        ProjectExperience projectExperience = new ProjectExperience();
        projectExperience.setProjectName("“智慧社区”APP");
        projectExperience.setProjectStartDate("2015.11");
        projectExperience.setProjectEndDate("至今");
        projectExperience.setProjectDescription(
            "该项目主要以物业公司为主线，不同物业公司不同APP，分别分为物业端APP，业主端APP，商家端APP。业主用户注册并登录APP，可以实现在线缴费（物业费、停车费），在线商城（物业店铺）购物。未开放功能包括：业主自主开店等，即业主自己可能在商家端进行开店，并且可以实现在线买卖。<br />项目整体架构采用：spring, springmvc, dubbox, redis, mycat, mysql, fastdfs");
        projectExperience.setDuty("电商模块整体负责");
        projectExperience.setPerformance("");
        projectExperiences.add(projectExperience);

        ProjectExperience projectExperience2 = new ProjectExperience();
        projectExperience2.setProjectName("“好蓝”医疗APP");
        projectExperience2.setProjectStartDate("2015.11");
        projectExperience2.setProjectEndDate("至今");
        projectExperience2.setProjectDescription(
            "该项目是APP项目，主要分为用户中心、资讯、自诊、商城等模块。注册用户登录APP之后可以在自诊模块进行疾病的诊断，通过数据的分析，诊断最有可能的疾病以及医药信息；资讯模块提供健康相关的新闻等；登录用户在商城模块可以选择相应的商品进行购买，实现了一个最基本的网上商城功能。");
        projectExperience2.setDuty("完成整个订单模块的设计和开发工作，开发主要是提供APP后台接口");
        projectExperience2.setPerformance("");
        projectExperiences.add(projectExperience2);
        resume.setProjectExperiences(projectExperiences);

        // 教育经历
        List<EducationExperience> educationExperiences = new ArrayList<>();
        EducationExperience educationExperience = new EducationExperience();
        educationExperience.setSchool("常熟理工学院");
        educationExperience.setStartDate("2007.09");
        educationExperience.setEndDate("2011.06");
        educationExperience.setMajor("网络工程");
        educationExperience.setDegree(Degree.BACHELOR);
        educationExperience.setExperience("");
        educationExperiences.add(educationExperience);
        resume.setEducationExperiences(educationExperiences);

    }

    @Test
    public void testGenerateResumeHTMLDoc() {
        ResumeDocGenerator resumeDocGenerator = new ResumeDocGenerator();
        Output output = resumeDocGenerator.generateResumeDoc(resume, SupportedOutputFileType.HTML);
        System.out.println(output);
    }

    @Test
    public void testGenerateResumePDFDoc() {
        ResumeDocGenerator resumeDocGenerator = new ResumeDocGenerator();
        Output output = resumeDocGenerator.generateResumeDoc(resume, SupportedOutputFileType.PDF);
        System.out.println(output);
    }

}
