package org.example.notification;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NotificationService {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
        log.info("Observer added: {}", observer.getClass().getSimpleName());
    }

    public void notifyObservers(String message) {
        log.info("Notifying observers: {}", message);
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
