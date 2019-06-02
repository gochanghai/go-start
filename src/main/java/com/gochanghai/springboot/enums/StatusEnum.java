package com.gochanghai.springboot.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  StatusEnum implements IEnum<Integer> {
    value0(0,"未激活"),
    value1(1,"已激活"),
    value2(3,"正常"),
    value3(3,"禁用");

    private Integer value;
    private String desc;

    StatusEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @JsonValue
    public String getDesc(){
        return this.desc;
    }
}
