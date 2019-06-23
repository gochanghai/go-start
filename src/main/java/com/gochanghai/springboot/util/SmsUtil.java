package com.gochanghai.springboot.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SmsUtil {

    @Value("${lzCloudSmsUrl}")
    private String smsUrl;

    /**
     * 发送短信验证码
     * @param phone
     * @param code
     * @return
     */
    public boolean sendSms(String phone, String code) throws IOException {

        /**
         * 请求地址
         */
//        String smsUrl = "http://192.168.1.252:7003/lz/sms/bsend";
        SmsEntity smsEntity = new SmsEntity();
        smsEntity.setBizChannel("SLZYC");
        smsEntity.setSmsType("S105");
        smsEntity.setRecieveMobile(phone);
        /**
         * 短信模版中需要的参数
         */
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        smsEntity.setParams(params);
        String send = sendPostDataByJson(smsUrl, JSON.toJSONString(smsEntity), "utf-8");
        Map sendResult = JSON.parseObject(send, HashMap.class);
        if(sendResult.get("msg").equals("ok") && sendResult.get("status").equals("200")){
            return true;
        }
        return false;
    }
    /**
     * post请求传输json数据
     * @param url 请求地址
     * @param json 发送的json数据
     * @param encoding 编码
     * @return 返回值
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String sendPostDataByJson(String url, String json, String encoding) throws ClientProtocolException, IOException {
        String result = "";
        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 设置参数到请求对象中
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), encoding);
        }
        // 释放链接
        response.close();
        return result;
    }
}
