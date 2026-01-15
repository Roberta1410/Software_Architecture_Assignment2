package org.example.command;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.example.handler.OrderValidationHandler;
import org.example.payment.PaymentStrategy;
import org.example.repository.OrderRepository;

@Slf4j
public class PlaceOrderCommand implements OrderCommand {

    private final Order order;
    private final OrderValidationHandler validationChain;
    private final PaymentStrategy paymentStrategy;
    private final OrderRepository orderRepository;

    public PlaceOrderCommand(Order order,
                             OrderValidationHandler validationChain,
                             PaymentStrategy paymentStrategy,
                             OrderRepository orderRepository) {
        this.order = order;
        this.validationChain = validationChain;
        this.paymentStrategy = paymentStrategy;
        this.orderRepository = orderRepository;
    }

    @Override
    public void execute() {
        log.info("Starting order placement for order {}", order.getId());

        // Step 1: Validate order through the chain
        if (validationChain != null) {
            validationChain.validate(order);
        }

        // Step 2: Process payment
        if (paymentStrategy != null) {
            paymentStrategy.pay(order.getTotalAmount());
            order.setStatus("PAID");
        }

        // Step 3: Persist the order
        if (orderRepository != null) {
            orderRepository.save(order);
        }

        log.info("Order placed successfully: {}", order.getId());
    }
}
