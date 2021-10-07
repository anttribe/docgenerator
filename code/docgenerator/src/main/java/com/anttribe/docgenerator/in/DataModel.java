package com.anttribe.docgenerator.in;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class DataModel {

    public static final DataModel EMPTY = new DataModel();

    /**
     * 模型数据
     */
    private Map<String, Object> modelMap;

    public DataModel() {
        modelMap = new HashMap<String, Object>();
    }

    /**
     * @param key
     * @param value
     */
    public void addObject(String key, Object value) {
        getModelMap().put(key, value);
    }

    /**
     * @param modelMap
     */
    public void addAllObjects(Map<String, ?> modelMap) {
        getModelMap().putAll(modelMap);
    }

    public Map<String, Object> getModelMap() {
        return modelMap;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
