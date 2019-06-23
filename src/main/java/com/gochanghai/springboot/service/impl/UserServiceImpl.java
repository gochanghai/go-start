package com.gochanghai.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gochanghai.springboot.dto.UserDTO;
import com.gochanghai.springboot.entity.User;
import com.gochanghai.springboot.mapper.UserMapper;
import com.gochanghai.springboot.service.UserService;
import com.gochanghai.springboot.transfer.UserTransfer;
import com.gochanghai.springboot.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserTransfer userTransfer;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<UserVo> findAll(Page<UserVo> page) {
        return (Page<UserVo>) page.setRecords(userMapper.findAll(page));
    }

    @Override
    public boolean add(UserDTO dto) {
        User user = userTransfer.userDto2Po(dto);
        return user.insert();
    }

    @Override
    public User findByUsername(String userName) {
        User user = new User();
        user.setUsername(userName);
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        lambda.eq(User::getUsername,userName);
        return user.selectOne(lambda);
    }
}
