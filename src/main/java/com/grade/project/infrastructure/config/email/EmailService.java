package com.grade.project.infrastructure.config.email;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
