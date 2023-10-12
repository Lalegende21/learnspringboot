package com.getsmarter.LearnSpringBoot.service.mails;

public interface EmailService {

    public void sendEmail(String to, String subject, String from);
}
