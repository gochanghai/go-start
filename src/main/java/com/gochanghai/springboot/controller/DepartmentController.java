package com.gochanghai.springboot.controller;

import com.gochanghai.springboot.dto.BaseIdDTO;
import com.gochanghai.springboot.entity.Department;
import com.gochanghai.springboot.entity.User;
import com.gochanghai.springboot.mapper.DepartmentMapper;
import com.gochanghai.springboot.vo.DeptTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @PostMapping("/add")
    public boolean add(@RequestBody Department dto){
        return dto.insert();
    }

    @PostMapping("/del")
    public boolean del(@RequestBody BaseIdDTO dto){
        User user = new User();
        return user.deleteById(dto.getId());
    }

    @PostMapping("/findTree")
    public List<DeptTreeVo> findTree(){
        return departmentMapper.selectTree(1L);
    }

}
