package com.anttribe.docgenerator.engine;

import com.anttribe.docgenerator.in.DataModel;
import com.anttribe.docgenerator.out.Output;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public interface TemplateEngine {

    /**
     * 生成文档处理方法
     *
     * @param dataModel
     */
    Output process(DataModel dataModel);

}
