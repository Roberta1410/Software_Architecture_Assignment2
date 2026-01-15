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
        // TODO: Check inventory here, e.g., query DB or service
        log.info("Checking inventory for order {}", order.getId());

        // Assume inventory is okay for now
        order.setStatus("INVENTORY_CHECKED");

        // Pass to the next handler in the chain
        if (nextHandler != null) {
            nextHandler.validate(order);
        }
    }
}
