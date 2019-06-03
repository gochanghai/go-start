package com.gochanghai.springboot.transfer;

import com.gochanghai.springboot.dto.UserDTO;
import com.gochanghai.springboot.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserTransfer {

//    List<UserVo> po2UserVo(List<User> list);

    User userDto2Po(UserDTO dto);
}
