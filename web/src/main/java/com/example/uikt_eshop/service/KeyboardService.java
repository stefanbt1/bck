package com.example.uikt_eshop.service;

import com.example.uikt_eshop.models.dto.KeyboardDto;
import com.example.uikt_eshop.models.dto.ProductDto;
import com.example.uikt_eshop.models.products.Keyboard;

import java.util.List;
import java.util.Optional;

public interface KeyboardService {

    List<Keyboard> getKeyboards();

    Keyboard getKeyboardById(Long id);

    Optional<Keyboard> createKeyboard(KeyboardDto keyboardDto);

    void updateKeyboard(Long id,Double price);

    void deleteKeyboard(Long id);
}
