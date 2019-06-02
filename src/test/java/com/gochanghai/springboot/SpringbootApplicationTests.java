package com.gochanghai.springboot;

import com.gochanghai.springboot.util.EmailTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String senderMailAddress;

    @Autowired
    private EmailTool emailTool;

    @Test
    public void contextLoads() {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("to", new String[]{"942059473@qq.com",});
        valueMap.put("title", "【领筑金融云】");
        valueMap.put("company", "领筑数字(深圳)有限公司");
        valueMap.put("name", "领筑");
        valueMap.put("email", "942059473@qq.com");
        valueMap.put("id","100000");
        emailTool.sendMailTemplate(valueMap);
    }

    public void sendHtmlMail(String to, String subject, String content){
        //创建message
        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //发件人
//        helper.setFrom(senderMailAddress);
        //收件人
//        helper.setTo("942059473@qq.com");
        //邮件标题
//        helper.setSubject(subject);
        //true指的是html邮件
//        helper.setText(content, true);
        //发送邮件
        mailSender.send(message);
    }


    public void sendSimpleMail(Map<String, Object> valueMap){
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            // 设置发件人邮箱
            helper.setFrom(senderMailAddress);
            // 设置收件人邮箱
            helper.setTo((String[])valueMap.get("to"));
            // 设置邮件标题
            helper.setSubject(valueMap.get("title").toString());

            // 添加正文（使用thymeleaf模板）
            Context context = new Context();
            context.setVariables(valueMap);
            String content = this.templateEngine.process("emailTemplate.html", context);
            helper.setText(content, true);

            // 添加附件
            if (valueMap.get("filePathList") != null) {
                String[] filePathList = (String[]) valueMap.get("filePathList");
                for(String filePath: filePathList) {
                    FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                    helper.addAttachment(fileName, fileSystemResource);
                }
            }

            // 发送邮件
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
