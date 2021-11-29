package com.anttribe.docgenerator.samples.resume.config;

import com.anttribe.docgenerator.out.OutputFileType;
import com.anttribe.docgenerator.out.SupportedOutputFileType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhaoyong
 * @date 2021/11/26 0026
 */
@Getter
@AllArgsConstructor
public enum TemplateFileMapping {

    HTML("templates/freemarker/resume/documentation_resume_html.ftl", SupportedOutputFileType.HTML),
    PDF("templates/freemarker/resume/documentation_resume_pdf.ftl", SupportedOutputFileType.PDF);

    /**
     * 模板文件
     */
    private String templateFile;

    /**
     * 输出文件类型
     */
    private OutputFileType resumeOutType;

    public static TemplateFileMapping valueOfOutType(OutputFileType resumeOutType) {
        if (null == resumeOutType) {
            return null;
        }

        TemplateFileMapping[] mappings = TemplateFileMapping.values();
        for(TemplateFileMapping mapping: mappings){
            if(resumeOutType == mapping.getResumeOutType()){
                return mapping;
            }
        }
        return null;
    }
}
