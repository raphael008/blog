package com.github.raphael008.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.raphael008.serializer.BaseEnumSerializer;

@JsonSerialize(using = BaseEnumSerializer.class)
public enum Gender implements BaseEnum {
    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    SECRET(3, "保密");

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

    Gender(Integer index, String value) {
        this.index = index;
        this.value = value;
    }
}
