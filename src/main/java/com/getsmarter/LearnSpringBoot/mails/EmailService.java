package com.getsmarter.LearnSpringBoot.mails;

public interface EmailService {

    public void sendEmail(String to, String subject, String from);
}
