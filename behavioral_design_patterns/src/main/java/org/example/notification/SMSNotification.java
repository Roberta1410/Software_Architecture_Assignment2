package org.example.notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SMSNotification implements Observer {

    private final String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        log.info("Sending SMS to {}: {}", phoneNumber, message);

    }
}
