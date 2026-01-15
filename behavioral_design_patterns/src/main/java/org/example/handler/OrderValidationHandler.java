package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;

@Slf4j
public abstract class OrderValidationHandler {
    protected OrderValidationHandler next;

    public OrderValidationHandler() {
    }

    public OrderValidationHandler(OrderValidationHandler next) {
        this.next = next;
    }

    public void setNext(OrderValidationHandler next) {
        this.next = next;
    }

    public void validate(Order order) {
        // Default behavior: just pass to the next handler
        if (next != null) {
            next.validate(order);
        } else {
            log.info("Order {} validation chain completed.", order.getId());
        }
    }
}
