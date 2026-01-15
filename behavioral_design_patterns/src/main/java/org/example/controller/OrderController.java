package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.example.payment.CreditCardPayment;
import org.example.payment.PaymentStrategy;
import org.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * Place a new order.
     *
     * Example POST request body:
     * {
     *   "customerName": "John Doe",
     *   "totalAmount": 99.99
     * }
     */
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        log.info("Received request to place order for customer {}", order.getCustomerName());

        // For simplicity, using CreditCardPayment as the payment strategy
        PaymentStrategy paymentStrategy = new CreditCardPayment();

        // Call service layer t
