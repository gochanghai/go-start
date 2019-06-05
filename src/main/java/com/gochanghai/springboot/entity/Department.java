package com.gochanghai.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("department")
@EqualsAndHashCode(callSuper = false)
public class Department extends Model<Department> {
    private Long id;
    private String deptName;
    private Long parentId;
    private Long companyId;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
