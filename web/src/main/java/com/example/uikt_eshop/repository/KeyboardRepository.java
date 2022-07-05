package com.example.uikt_eshop.repository;

import com.example.uikt_eshop.models.products.Keyboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {
    void deleteByName(String name);
}
