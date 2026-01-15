package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.example.command.PlaceOrderCommand;
import org.example.handler.InventoryCheckHandler;
import org.example.handler.OrderValidationHandler;
import org.example.handler.PaymentValidationHandler;
import org.example.notification.NotificationService;
import org.example.payment.PaymentStrategy;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public void placeOrder(Order order, PaymentStrategy paymentStrategy) {
        log.info("Starting order process for customer: {}", order.getCustomerName());

        order.setNotificationService(notificationService);

        OrderValidationHandler inventoryHandler = new InventoryCheckHandler();
        OrderValidationHandler paymentHandler = new PaymentValidationHandler();
        inventoryHandler.setNext(paymentHandler); // inventory -> payment

        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand(
                order,
                inventoryHandler,
                paymentStrategy,
                orderRepository
        );

        placeOrderCommand.execute();

        log.info("Order process completed for order {}", order.getId());
    }
}
