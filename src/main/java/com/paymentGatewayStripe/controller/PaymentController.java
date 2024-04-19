package com.paymentGatewayStripe.controller;

import com.paymentGatewayStripe.repository.ProductRepository;
import com.paymentGatewayStripe.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.paymentGatewayStripe.entities.Product;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Value("${stripe.secretKey}")
    private String stripeApiKey;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentService paymentService;

    //  http://localhost:8080/payments/initiate?productId=2
    @PostMapping("/initiate")
    public ResponseEntity<String> initiatePayment(@RequestParam Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new EntityNotFoundException("Product not found"));

        String paymentIntentId = paymentService.createPaymentIntent(product.getAmount());
        return ResponseEntity.ok(paymentIntentId);
    }
}
