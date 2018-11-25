package com.github.raphael008.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.raphael008.serializer.BaseEnumSerializer;

@JsonSerialize(using = BaseEnumSerializer.class)
public enum BlockStatus implements BaseEnum {
    UNKNOWN(0, "未知"),
    YES(1, "封禁"),
    NO(2, "正常");

    private Integer index;
    private String value;

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public String getValue() {
        return value;
    }

    BlockStatus(Integer index, String value) {
        this.index = index;
        this.value = value;
    }
}
