package com.gochanghai.springboot.controller;

import com.gochanghai.springboot.dto.BaseIdDTO;
import com.gochanghai.springboot.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return user.insert();
    }

    @PostMapping("/del")
    public boolean del(@RequestBody BaseIdDTO dto){
        User user = new User();
        return user.deleteById(dto.getId());
    }

    @PostMapping("/all")
    public List<User> findListAll(){
        User user = new User();
        return user.selectAll();
    }

}
