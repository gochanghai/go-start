package com.gochanghai.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gochanghai.springboot.dto.BaseIdDTO;
import com.gochanghai.springboot.dto.UserDTO;
import com.gochanghai.springboot.entity.User;
import com.gochanghai.springboot.service.UserService;
import com.gochanghai.springboot.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("检查部门名称是否存在")
    @PostMapping("/add")
    public boolean add(@RequestBody UserDTO dto){
        return userService.add(dto);
    }

    @ApiOperation("检查部门名称是否存在")
    @PostMapping("/del")
    public boolean del(@RequestBody BaseIdDTO dto){
        User user = new User();
        return user.deleteById(dto.getId());
    }

    @ApiOperation("检查部门名称是否存在")
    @PostMapping("/all")
    public Page<UserVo> findListAll(){
        Page<UserVo> page = new Page<>(1,20);
        return userService.findAll(page);
    }

}
