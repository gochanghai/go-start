package com.gochanghai.springboot.dto;

import com.gochanghai.springboot.enums.StatusEnum;
import com.gochanghai.springboot.enums.UserTypeEnum;
import lombok.Data;

@Data
public class UserDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String headimgurl;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 用户类别（融资人、工程公司、资金方、平台）
     */
    private UserTypeEnum userType;

    /**
     * 用户状态
     */
    private StatusEnum status;
}
