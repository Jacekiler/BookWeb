package com.jszarski.notificationservice.service;


import com.jszarski.common.model.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailMessageBuilder messageBuilder;

    public void sendNewRecommendation(NotificationEvent event) {
        log.info("Sending recommendation to {}", event.getEmail());
        SimpleMailMessage mailMessage = messageBuilder.newRecommendationMessage(event);
        javaMailSender.send(mailMessage);
        log.info("New recommendation sent to {}", event.getEmail());
    }

    public void sendPopularRecommendation(NotificationEvent event) {
        log.info("Sending recommendation to {}", event.getEmail());
        SimpleMailMessage mailMessage = messageBuilder.popularRecommendationMessage(event);
        javaMailSender.send(mailMessage);
        log.info("Popular recommendation sent to {}", event.getEmail());
    }
}
