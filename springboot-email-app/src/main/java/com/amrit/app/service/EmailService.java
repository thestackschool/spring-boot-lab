package com.amrit.app.service;


import com.amrit.app.dto.EmailResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    public EmailResponse sendEmail(
            String to,
            String[] cc,
            String[] bcc,
            String subject,
            String text,
            Resource[] files
    );
}
