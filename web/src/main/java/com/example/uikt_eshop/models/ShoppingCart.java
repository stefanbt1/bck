package com.example.uikt_eshop.models;


import com.example.uikt_eshop.models.enums.ShoppingCartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    private int id = 1;

    private LocalDateTime dateCreated;

//    TODO: to be added in a future iteration.
//    @ManyToOne
//    private User user;

    @OneToMany
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

}