package com.example.uikt_eshop.service;

import com.example.uikt_eshop.models.dto.MonitorDto;
import com.example.uikt_eshop.models.dto.MouseDto;
import com.example.uikt_eshop.models.dto.ProductDto;
import com.example.uikt_eshop.models.products.Keyboard;
import com.example.uikt_eshop.models.products.Monitor;
import com.example.uikt_eshop.models.products.Mouse;

import java.util.List;
import java.util.Optional;

public interface MouseService {
    List<Mouse> getMouses();

    Mouse getMouseById(Long id);

    Optional<Mouse> createMouse(MouseDto mouseDto);

    void updateMouse(Long id,Double price);

    void deleteMouse(Long id);
}
