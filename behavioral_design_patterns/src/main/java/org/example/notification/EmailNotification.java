package org.example.notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotification implements Observer {

    private final String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        log.info("Sending EMAIL to {}: {}", email, message);

    }
}
