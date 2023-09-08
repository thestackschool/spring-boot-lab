package com.amrit.app.controller;

import com.amrit.app.dto.EmailResponse;
import com.amrit.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<EmailResponse> sendEmail(
            @RequestParam("to") String to,
            @RequestParam("cc") String[] cc,
            @RequestParam("bcc") String[] bcc,
            @RequestParam("subject") String subject,
            @RequestParam("text") String text,
            @RequestParam("files") Resource[] files

    ){
        EmailResponse emailResponse = emailService.sendEmail(
                to,
                cc,
                bcc,
                subject,
                text,
                files
        );
        return new ResponseEntity<>(emailResponse, HttpStatus.OK);
    }
}
