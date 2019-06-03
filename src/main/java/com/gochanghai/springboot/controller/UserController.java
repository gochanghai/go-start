package com.gochanghai.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gochanghai.springboot.dto.BaseIdDTO;
import com.gochanghai.springboot.dto.UserDTO;
import com.gochanghai.springboot.entity.User;
import com.gochanghai.springboot.service.UserService;
import com.gochanghai.springboot.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public boolean add(@RequestBody UserDTO dto){
        return userService.add(dto);
    }

    @PostMapping("/del")
    public boolean del(@RequestBody BaseIdDTO dto){
        User user = new User();
        return user.deleteById(dto.getId());
    }

    @PostMapping("/all")
    public Page<UserVo> findListAll(){
        Page<UserVo> page = new Page<>(1,20);
        return userService.findAll(page);
    }

}
