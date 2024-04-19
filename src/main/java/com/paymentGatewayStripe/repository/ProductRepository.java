package com.paymentGatewayStripe.repository;

import com.paymentGatewayStripe.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

//SubscriptionPlanRepository