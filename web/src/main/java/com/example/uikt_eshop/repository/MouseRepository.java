package com.example.uikt_eshop.repository;

import com.example.uikt_eshop.models.products.Mouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseRepository extends JpaRepository<Mouse, Long> {
    void deleteByName(String name);

}
