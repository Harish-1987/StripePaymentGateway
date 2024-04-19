package com.paymentGatewayStripe.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${stripe.secretKey}")
    private String stripeApiKey;

    public String createPaymentIntent(double amount){
        Stripe.apiKey = stripeApiKey;

        try {
            PaymentIntentCreateParams params = new  PaymentIntentCreateParams.Builder()
                    .setAmount((long) (amount * 100))  //Stripe requires amount in cents
                    .setCurrency("usd")
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return paymentIntent.getId();
        } catch (StripeException e) {
            throw new RuntimeException("Error creating payment intent", e);
        }
    }

}
