package com.tec;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void send(String fromEmail, String fromPassword, String toEmail, String subject, String content) {
        // 设置邮件服务器主机名和端口
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // 创建Session实例
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 设置发件人邮箱和密码
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });

        try {
            // 创建MimeMessage实例
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail)); // 设置发件人
            message.setRecipients(Message.RecipientType.TO, toEmail); // 设置收件人
            message.setSubject(subject); // 设置主题
            message.setContent(content, "text/html;charset=UTF-8"); // 设置邮件内容

            // 发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功！");
        } catch (Exception e) {
            System.out.println("邮件发送失败！");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fromEmail = "你的邮箱地址";
        String fromPassword = "邮箱密码";
        String toEmail = "接收邮件的邮箱地址";
        String subject = "邮件主题";
        String content = "<h1>邮件正文</h1><p>这是一封测试邮件，请勿回复。</p>";
        send(fromEmail, fromPassword, toEmail, subject, content);
    }
}
