package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;

@Slf4j
public class InventoryCheckHandler extends OrderValidationHandler {

    public InventoryCheckHandler(OrderValidationHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void validate(Order order) {
        log.info("Checking inventory for order {}", order.getId());

        order.setStatus("INVENTORY_CHECKED");

        if (nextHandler != null) {
            nextHandler.validate(order);
        }
    }
}
