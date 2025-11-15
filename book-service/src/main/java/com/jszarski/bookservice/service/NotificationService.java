package com.jszarski.bookservice.service;

import com.jszarski.bookservice.model.entity.Book;
import com.jszarski.bookservice.model.entity.Subscription;
import com.jszarski.bookservice.repository.SubscriptionRepository;
import com.jszarski.common.model.dto.SubscriptionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService {

    private final SubscriptionRepository subscriptionRepository;
    private final NotificationEventBuilder notificationEventBuilder;
    private final NotificationEventProducer notificationEventProducer;

    @Async
    public void checkNew(Book book) {
        var subscriptionsToApply = subscriptionRepository.findAllByType(SubscriptionType.NEW.name())
                .stream()
                .filter(subscription -> matchesNewBook(book, subscription))
                .toList();
        subscriptionsToApply.stream()
                .map(subscription -> notificationEventBuilder.build(subscription.getEmail(), book))
                .forEach(notificationEventProducer::send);

    }

    private static boolean matchesNewBook(Book book, Subscription subscription) {
        return subscription.getAuthor() != null && subscription.getAuthor().equals(book.getAuthor())
                || subscription.getGenre() != null && subscription.getGenre().equals(book.getGenre());
    }
}
