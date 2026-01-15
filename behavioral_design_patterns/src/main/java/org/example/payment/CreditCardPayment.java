package org.example.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        // TODO: Implement real credit card payment logic
        log.info("Paid ${} with Credit Card.", amount);
    }
}
