package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;

@Slf4j
public class PaymentValidationHandler extends OrderValidationHandler {

    public PaymentValidationHandler() {
        super();
    }

    public PaymentValidationHandler(OrderValidationHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void validate(Order order) {
        // TODO: Implement actual payment validation logic
        log.info("Validating payment for order {}", order.getId());

        // For now, assume payment is valid
        order.setStatus("PAYMENT_VALIDATED");

        // Pass to the next handler in the chain
        if (next != null) {
            next.validate(order);
        } else {
            log.info("Order {} validation chain completed.", order.getId());
        }
    }
}
