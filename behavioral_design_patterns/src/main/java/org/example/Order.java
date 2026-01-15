package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notification.NotificationService;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String status;

    private double totalAmount;

    @Transient
    private transient NotificationService notificationService;

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        log.info("Order {} status updated to: {}", id, newStatus);
        if (notificationService != null) {
            notificationService.notifyObservers("Order " + id + " status changed to: " + newStatus);
        }
    }
}
