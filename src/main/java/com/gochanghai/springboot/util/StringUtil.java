package com.gochanghai.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.util.regex.Pattern;

public class StringUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);




    /**
     * 正则表达式校验
     * @param val
     * @param regex
     * @return
     */
    public static boolean regexValid(String val, String regex){
        if(val == null || isEmpty(regex)) return false;

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(val).matches();
    }

    /**
     * 描述：是否是邮箱.
     *
     * @param str 指定的字符串
     * @return 是否是邮箱:是为true，否则false
     */
    public static Boolean isEmail(String str) {
        if(StringUtils.isEmpty(str)) return false;

        Boolean isEmail = false;
        String expr = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

        if (str.matches(expr)) {
            isEmail = true;
        }
        return isEmail;
    }

    public static boolean isPhone(String str) {
        if(StringUtils.isEmpty(str)) return false;

        Pattern pattern = Pattern.compile("^[\\d]{11}$");
        return pattern.matcher(str).matches();
    }

    /**
     * 个人用户密码规则（必须包含大写字母、小写字母、数字、符号中至少3种）
     * @param password
     * @return
     */
    public static boolean matchPwdReg(String password) {
        if(StringUtils.isEmpty(password)) return false;
        int kindCount = 0;//类型数量
        //有大写字母
        if (password.matches(".*[A-Z]+.*"))
            kindCount++;
        //有小写字母
        if (password.matches(".*[a-z]+.*"))
            kindCount++;
        //有数字
        if (password.matches(".*[0-9]+.*"))
            kindCount++;
        //有特殊符号
        if (password.matches(".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*"))
            kindCount++;
        //类型不小于3时符合要求
        if (kindCount >= 2)
            return true;
        return false;
    }

    public static boolean isEmpty(Object o){
        return o == null || "".equals(o.toString());
    }

    /**
     * 转驼峰式命名
     * @param name
     * @return
     */
    public static String toCamelName(String name){
        if(isEmpty(name)) return null;

        if(!name.contains("_")) return name;

        StringBuffer sb = new StringBuffer();
        String[] camels = name.split("_");
        for(String camel:camels){
            if(camel.isEmpty()) continue;
            if(sb.length() == 0){
                sb.append(camel.toLowerCase());
            }else{
                sb.append(camel.substring(0,1).toUpperCase());
                sb.append(camel.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 转成下划线格式命名
     * @param name
     * @return
     */
    public static String toUnderlineName(String name){
        if(isEmpty(name)) return null;

        StringBuffer sb = new StringBuffer();
        String s = null;
        for(int i = 0;i<name.length();i++){

            s = name.substring(i,i+1);
            if(s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))){
                sb.append("_");
            }
            sb.append(s.toLowerCase());
        }
        return sb.toString();
    }
}
