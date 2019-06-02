package com.gochanghai.springboot.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.gochanghai.springboot.enums.StatusEnum;
import com.gochanghai.springboot.enums.UserTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户实体类
 * @author gochanghai
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
    /**
     * 用户主键ID
     */
    private Long id;

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
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户信息ID
     */
    private Long companyId;

    /**
     * 用户类别（融资人、工程公司、资金方、平台）
     */
    private UserTypeEnum userType;

    /**
     * 用户状态
     */
    private StatusEnum status;


    /**
     * 是否逻辑删除（1：删除；0：正常（默认））
     */
    @TableLogic
    private Integer isDel;

    /**
     * 指定主键
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
