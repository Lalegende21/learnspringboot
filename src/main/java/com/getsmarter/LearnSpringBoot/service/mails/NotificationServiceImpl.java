package com.getsmarter.LearnSpringBoot.service.mails;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private EmailService emailServiceImpl;

    public NotificationServiceImpl(EmailService emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }

    public void sendReceived(String userEmail) {
        String text = "Bonjour les geeks !";
        String subject = "Salutations à tous les informaticiens du monde.";

        emailServiceImpl.sendEmail(userEmail, text, subject);
    }
}
