package com.gochanghai.springboot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gochanghai.springboot.entity.Department;
import com.gochanghai.springboot.mapper.DepartmentMapper;
import com.gochanghai.springboot.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
