package com.amrit.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender() {

        JavaMailSenderImpl jm = new JavaMailSenderImpl();

        jm.setHost(env.getProperty("spring.mail.host"));
        jm.setPort(env.getProperty("spring.mail.port", Integer.class));
        jm.setUsername(env.getProperty("spring.mail.username"));
        jm.setPassword(env.getProperty("spring.mail.password"));
        jm.setJavaMailProperties(props());
        return jm;
    }

    public Properties props() {
        Properties props = new Properties();
        // TLS -Transport Layer Security
        /*
        This can be moved to application.properties as -
        mail.smtp.starttls.enable=true
         */
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "true");
        return props;
    }
}
