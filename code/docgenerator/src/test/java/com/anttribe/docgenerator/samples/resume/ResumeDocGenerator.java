package com.anttribe.docgenerator.samples.resume;

import com.anttribe.docgenerator.DocGenerator;
import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.OutputConfiguration;
import com.anttribe.docgenerator.config.TemplateConfiguration;
import com.anttribe.docgenerator.in.DataModel;
import com.anttribe.docgenerator.out.Output;
import com.anttribe.docgenerator.out.OutputFileType;
import com.anttribe.docgenerator.samples.resume.config.TemplateFileMapping;
import com.anttribe.docgenerator.samples.resume.model.Resume;
import com.anttribe.docgenerator.utils.naming.NamingHandler;
import com.anttribe.docgenerator.utils.naming.complex.DateFilePathNamingHandler;
import com.anttribe.docgenerator.utils.naming.single.DesignatedNamingHandler;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyong
 * @date 2021/11/25 0025
 */
@Slf4j
@Setter
public class ResumeDocGenerator {

    private static final String DEFAULT_OUTPUT_FILEPATH = "/Testing/docgenerator/outputs";

    private static final String KEY_RESUME = "resume";

    private NamingHandler innerNamingHandler;

    public Output generateResumeDoc(Resume resume, OutputFileType resumeOutType) {
        if (null == resume || null == resume.getPersonalInfo()) {
            log.error("resume or personal must not be null");
            return null;
        }

        TemplateFileMapping templateFileMapping = getTemplateFileMapping(resumeOutType);
        Configuration configuration = Configuration.builder()
            .templateConfig(TemplateConfiguration.builder().templateFile(templateFileMapping.getTemplateFile()).build())
            .outputConfig(OutputConfiguration.builder().outputDirectory(DEFAULT_OUTPUT_FILEPATH)
                .outputFileType(templateFileMapping.getResumeOutType())
                .namingHandler(new DateFilePathNamingHandler(getInnerNamingHandler(resume))).build())
            .build();

        DocGenerator generator = new DocGenerator(configuration);
        DataModel dataModel = new DataModel();
        dataModel.addObject(KEY_RESUME, resume);
        Output output = generator.generate(dataModel);
        return output;
    }

    private TemplateFileMapping getTemplateFileMapping(OutputFileType resumeOutType) {
        TemplateFileMapping templateFileMapping = TemplateFileMapping.valueOfOutType(resumeOutType);
        if (null == templateFileMapping) {
            templateFileMapping = TemplateFileMapping.HTML;
        }
        return templateFileMapping;
    }

    private NamingHandler getInnerNamingHandler(Resume resume) {
        if (null == innerNamingHandler) {
            innerNamingHandler =
                new DesignatedNamingHandler(String.format("%s的简历", resume.getPersonalInfo().getName()));
        }

        return innerNamingHandler;
    }

}
