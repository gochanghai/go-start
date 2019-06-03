package com.gochanghai.springboot.vo;

import com.gochanghai.springboot.enums.StatusEnum;
import com.gochanghai.springboot.enums.UserTypeEnum;
import lombok.Data;

@Data
public class UserVo {

    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String headimgurl;

    /**
     * 年龄
     */
    private Integer userAge;

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
