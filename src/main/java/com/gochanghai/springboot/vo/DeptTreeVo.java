package com.gochanghai.springboot.vo;

import lombok.Data;

import java.util.List;

@Data
public class DeptTreeVo {
    private Long id;
    private String deptName;
    private Long parentId;
    private Long companyId;
    private List<DeptTreeVo> child;
}
