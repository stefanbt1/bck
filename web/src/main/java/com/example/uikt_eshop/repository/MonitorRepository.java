package com.example.uikt_eshop.repository;

import com.example.uikt_eshop.models.products.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {

    void deleteByName(String name);

}
