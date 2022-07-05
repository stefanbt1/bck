package com.example.uikt_eshop.web;

import com.example.uikt_eshop.models.dto.LaptopDto;
import com.example.uikt_eshop.models.dto.MonitorDto;
import com.example.uikt_eshop.models.products.Laptop;
import com.example.uikt_eshop.models.products.Monitor;
import com.example.uikt_eshop.service.LaptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    List<Laptop> getLaptops() {
        return laptopService.getLaptops();
    }

    @GetMapping(value = "{id}")
    Laptop getLaptopById(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

    @PostMapping("/addLaptop")
    ResponseEntity<Laptop> createLaptop(@RequestBody LaptopDto laptopDto) {
        return this.laptopService.createLaptop(laptopDto)
                .map(monitor -> ResponseEntity.ok().body(monitor))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @DeleteMapping(value = "{id}")
    void deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
    }
}
