package com.gochanghai.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gochanghai.springboot.dto.UserDTO;
import com.gochanghai.springboot.entity.User;
import com.gochanghai.springboot.vo.UserVo;

public interface UserService {

    Page<UserVo> findAll(Page<UserVo> page);

    boolean add(UserDTO dto);

    User findByUsername(String userName);
}
