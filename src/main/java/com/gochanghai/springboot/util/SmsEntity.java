package com.gochanghai.springboot.util;

import lombok.Data;

import java.util.Map;

@Data
public class SmsEntity {

    /**
     * 业务渠道：如电商，领筑工程等，电商：SLZMT, 工程管理：SLZPM, 基础平台：SLZYC
     */
    private String bizChannel;

    /**
     * SMS短信类型：注册，找回密码，通知等：
     * DESC: 注册：S100   找回密码：S101    激活：S102  更改账号：S103
     */
    private String smsType;

    /**
     * 接收短信的手机号码
     */
    private String recieveMobile;

    /**
     * 短信模版中需要的参数
     */
    private Map<String, String> params;
}
