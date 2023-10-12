package com.getsmarter.LearnSpringBoot.mails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private NotificationService notificationService;

    public EmailController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/geeks")
    public void sendEmail() {
        notificationService.sendReceived("tenedelfred19@gmail.com");
    }
}
