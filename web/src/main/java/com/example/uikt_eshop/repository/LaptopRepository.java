package com.example.uikt_eshop.repository;

import com.example.uikt_eshop.models.products.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    void deleteByName(String name);
}
