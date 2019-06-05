package com.gochanghai.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gochanghai.springboot.entity.Department;
import com.gochanghai.springboot.vo.DeptTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {


    List<DeptTreeVo> selectTree(@Param("id") Long id);

    List<DeptTreeVo> selectByParentId(@Param("id") Long id);
}
