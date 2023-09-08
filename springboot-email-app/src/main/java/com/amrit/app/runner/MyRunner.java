//package com.amrit.app.runner;
//
//import com.amrit.app.util.MailUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Component;
//
//
//import java.net.MalformedURLException;
//
//@Component
//@Slf4j
//public class MyRunner implements CommandLineRunner {
//
//    @Autowired
//    private MailUtil mailUtil;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Resource file1 = new UrlResource("https://freeforms.com/wp-content/uploads/2021/01/Eviction-Notice-Notice-to-Quit.pdf");
//        Resource file2 = null;
//        Resource file3 = null;
//
//        try {
//            file2 = new UrlResource("https://upload.wikimedia.org/wikipedia/commons/1/13/Flag_Of_Nepal.jpg");
//          // can provide Amazon S3 image/file link
//           file3 = new UrlResource("https://upload.wikimedia.org/wikipedia/commons/4/4a/Peak_of_Mount_Machhapuchhre_of_Nepal.jpg");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        boolean isSent = mailUtil.send(
//                "thestackschool@gmail.com",
//                new String[]{
//                        "thestackschool@gmail.com",
//                        "amritadhikari404@gmail.com",
//                        "abhishek0adhikari@gmail.com"
//                }, new String[]{
//                        "amritadhikari404@gmail.com",
//                        "amrit.adhikari321@gmail.com"
//                },
//                "Hello There! How is it going???",
//                "<!doctype html>\n" +
//                        "<html>\n" +
//                        "  <head>\n" +
//                        "    <title>This is a simple email test!</title>\n" +
//                        "  </head>\n" +
//                        "  <body>\n" +
//                        "    <p>This is an example paragraph. Anything in the <strong>body</strong> tag will appear on the page, just like this <strong>p</strong> tag and its contents.</p>\n" +
//                        "  </body>\n" +
//                        "</html>",
//                new Resource[]{
//                        file1, file2, file3
//                }
//        );
//        if (isSent) {
//            log.info("<-- Email sent out successfully--> ");
//        } else {
//            log.error("<-- email not sent --> ");
//        }
//    }
//}
