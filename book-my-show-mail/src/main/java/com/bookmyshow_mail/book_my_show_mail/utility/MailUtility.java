package com.bookmyshow_mail.book_my_show_mail.utility;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context
import javax.naming.Context;

@Service
public class MailUtility
{
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    TemplateEngine templateEngine;
    public void sendMail(String subjectLine,String mailType,String toEmail)throws Exception
    {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        Context context=new Context();
        mimeMessageHelper.setSubject(subjectLine);
        mimeMessageHelper.setTo(toEmail);
        TemplateEngine templateEngine=new TemplateEngine();
       String htmlEmail=templateEngine.process("user-registration-mail",context);
       mimeMessageHelper.setText(htmlEmail,true);
       javaMailSender.send(mimeMessage);


    }

    public void sendUserRegistrationMail(String toEmail,String ownerName,String address,String subjectLine )
    {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        Context context=new Context();
        mimeMessageHelper.setSubject(subjectLine);
        mimeMessageHelper.setTo(toEmail);
        TemplateEngine templateEngine=new TemplateEngine();
        String htmlEmail=templateEngine.process("user-registration-mail",context);
        mimeMessageHelper.setText(htmlEmail,true);
        javaMailSender.send(mimeMessage);

    }


    public void sendHallRegistrationMail(String toEmail,String ownerName,int seats,String location,String subjectLine )
    {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        Context context=new Context();
        context.setVariable("ownerName",ownerName)
        context.setVariable("hallSeats",seats)
        context.setVariable("threaterLocation",location)

        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subjectLine);

        TemplateEngine templateEngine=new TemplateEngine();
        String htmlEmail=templateEngine.process("hall-registration-mail",context);

        javaMailSender.send(mimeMessage);

    }

}
