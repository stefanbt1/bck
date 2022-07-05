package com.example.uikt_eshop.models.products;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mouse extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cableLength;

    private String cableType;

    private String DPIResolution;

    private Boolean isGaming;

    public Mouse(String name, Double price, Category category, String cableLength, String cableType, String DPIResolution, Boolean isGaming){
        super(name, price, category);
        this.cableLength=cableLength;
        this.cableType=cableType;
        this.DPIResolution=DPIResolution;
        this.isGaming=isGaming;
    }

}
