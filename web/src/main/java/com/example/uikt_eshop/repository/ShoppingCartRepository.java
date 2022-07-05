package com.example.uikt_eshop.repository;

import com.example.uikt_eshop.models.ShoppingCart;
import com.example.uikt_eshop.models.enums.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    Optional<ShoppingCart> findByStatus(ShoppingCartStatus status);
}
