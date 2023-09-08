package com.amrit.app.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

    @Value("${spring.mail.username}")
    String from;

    @Autowired
    private JavaMailSender sender;


    public boolean send(
            String to,
            String[] cc,
            String[] bcc,
            String subject,
            String text,
            Resource[] files
    ) {
        boolean flag = false;

        try {
            // 1. Create one message
            MimeMessage message = sender.createMimeMessage();

            // 2. use Helper class and fill details
            MimeMessageHelper helper = new MimeMessageHelper(message, (files != null && files.length > 0));

            helper.setTo(to);

            if (cc != null && cc.length > 0) {
                helper.setCc(cc);
            }
            if (bcc != null && bcc.length > 0) {
                helper.setBcc(bcc);
            }
            helper.setSubject(subject);

            helper.setText(text, true); //send as HTML
            // helper.setText(text); // send as Plain Text

            if (files != null && files.length > 0) {
                //filename, file object
                for (Resource file : files) {
                    helper.addAttachment(file.getFilename(), file);
                }
            }
            // 3. send email
            System.out.println("About to send mail:");
            sender.send(message);
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }
}
