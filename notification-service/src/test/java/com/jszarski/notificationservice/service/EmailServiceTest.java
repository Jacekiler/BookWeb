package com.jszarski.notificationservice.service;

import com.jszarski.common.model.event.NotificationEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender sender;

    @Mock
    private EmailMessageBuilder messageBuilder;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void sendNew() {
        //given
        var event = new NotificationEvent();
        var mailMessage = new SimpleMailMessage();
        when(messageBuilder.newRecommendationMessage(event)).thenReturn(mailMessage);

        //when
        emailService.sendNewRecommendation(event);

        //then
        verify(sender, times(1)).send(mailMessage);
        verifyNoMoreInteractions(messageBuilder);
    }

    @Test
    public void sendPopular() {
        //given
        var event = new NotificationEvent();
        var mailMessage = new SimpleMailMessage();
        when(messageBuilder.popularRecommendationMessage(event)).thenReturn(mailMessage);

        //when
        emailService.sendPopularRecommendation(event);

        //then
        verify(sender, times(1)).send(mailMessage);
        verifyNoMoreInteractions(messageBuilder);
    }
}