package org.example.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        log.info("Paid ${} with Credit Card.", amount);
    }
}
