package com.anttribe.docgenerator;

import org.junit.Test;

import com.anttribe.docgenerator.config.Configuration;
import com.anttribe.docgenerator.config.Copyright;
import com.anttribe.docgenerator.config.OutputConfiguration;
import com.anttribe.docgenerator.config.TemplateConfiguration;
import com.anttribe.docgenerator.in.DataModel;
import com.anttribe.docgenerator.out.FileType;
import com.anttribe.docgenerator.out.Output;
import com.anttribe.docgenerator.utils.naming.DatetimeNamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/7 0007
 */
public class DocGeneratorTest {

    @Test
    public void testGenerate() {
        String templateFilepath = "/Testing/docgenerator/templates/freemarker/documentation_txt.ftl";
        Configuration configuration = Configuration.builder().copyright(Copyright.builder().build())
            .templateConfig(TemplateConfiguration.builder().templateFile(templateFilepath).build())
            .outputConfig(OutputConfiguration.builder().outputDirectory("/Testing/docgenerator/outputs")
                .outputFileType(FileType.WORD).namingHandler(new DatetimeNamingHandler()).build())
            .build();
        System.out.println(configuration);

        DocGenerator generator = new DocGenerator(configuration);
        DataModel dataModel = new DataModel();
        dataModel.addObject("version", "1.0");
        Output output = generator.generate(dataModel);
        System.out.println(output);
    }

}
