package com.jszarski.bookservice.service;


import com.jszarski.bookservice.model.dto.SubscriptionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Log4j2
public class SubscriptionService {

    public List<SubscriptionDTO> getSubscriptions(String email) {
        log.info("Getting subscriptions for email {}", email);
        // todo implement
        return emptyList();
    }

    public void subscribe(SubscriptionDTO subscriptionDTO) {
        log.info("Adding subscription for email {}", subscriptionDTO.getEmail());
       // todo implement
    }
}
