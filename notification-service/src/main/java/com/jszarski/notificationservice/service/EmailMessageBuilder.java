package com.jszarski.notificationservice.service;

import com.jszarski.common.model.event.NotificationEvent;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageBuilder {

    private static final String NEW_MESSAGE = """
            Title: %s
            Author: %s
            Genre: %s
            """;
    private static final String POPULAR_MESSAGE = """
            Title: %s
            Author: %s
            Genre: %s
            Rating: %s
            """;


    public SimpleMailMessage newRecommendationMessage(NotificationEvent event) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(event.getEmail());
        mailMessage.setSubject("New book recommendation");
        mailMessage.setText(newRecommendationText(event));
        return mailMessage;
    }

    private String newRecommendationText(NotificationEvent event) {
        var recommendation = event.getRecommendation();
        return String.format(NEW_MESSAGE, recommendation.getName(), recommendation.getAuthor(), recommendation.getGenre());
    }

    public SimpleMailMessage popularRecommendationMessage(NotificationEvent event) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(event.getEmail());
        mailMessage.setSubject("Popular book recommendation");
        mailMessage.setText(popularRecommendationText(event));
        return mailMessage;
    }

    private String popularRecommendationText(NotificationEvent event) {
        var recommendation = event.getRecommendation();
        return String.format(POPULAR_MESSAGE, recommendation.getName(), recommendation.getAuthor(), recommendation.getGenre(), recommendation.getRatingAvg());
    }
}
