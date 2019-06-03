package com.gochanghai.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gochanghai.springboot.entity.User;
import com.gochanghai.springboot.vo.UserVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT u.id, u.username name, u.phone, tu.user_age FROM `user` u " +
            "LEFT JOIN tbl_user tu ON tu.user_id = u.id")
    List<UserVo> findAll(Page<UserVo> page);
}
