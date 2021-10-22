package com.anttribe.docgenerator.utils.naming.complex;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.anttribe.docgenerator.utils.naming.NamingHandler;

/**
 * @author zhaoyong
 * @date 2021/10/22 0022
 */
public abstract class FilePathNamingHandler extends ComplexNamingHandler {

    public FilePathNamingHandler(NamingHandler innerNamingHandler) {
        super(innerNamingHandler);
    }

    @Override
    public String naming() {
        String filename = super.naming();

        String fileDir = this.fileDirNaming();
        if (!StringUtils.isEmpty(fileDir)) {
            filename = fileDir + File.separator + filename;
        }
        return filename;
    }

    protected abstract String fileDirNaming();
}
