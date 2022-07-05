package com.example.uikt_eshop.models.dto;

import lombok.Data;

@Data
public class KeyboardDto {

    private String name;

    private Double price;

    private Boolean spillResistant;

    private Boolean isGaming;

    private Long cableLengthInCm;

    private Integer numberOfKeys;

    private Long category;

    public KeyboardDto() {
    }

    public KeyboardDto(String name, Double price, Boolean spillResistant, Boolean isGaming, Long cableLengthInCm, Integer numberOfKeys, Long category) {
        this.name = name;
        this.price = price;
        this.spillResistant = spillResistant;
        this.isGaming = isGaming;
        this.cableLengthInCm = cableLengthInCm;
        this.numberOfKeys = numberOfKeys;
        this.category = category;
    }
}
