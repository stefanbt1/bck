package com.example.uikt_eshop.web;

import com.example.uikt_eshop.models.dto.KeyboardDto;
import com.example.uikt_eshop.models.dto.MonitorDto;
import com.example.uikt_eshop.models.products.Keyboard;
import com.example.uikt_eshop.models.products.Monitor;
import com.example.uikt_eshop.service.KeyboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/keyboards")
public class KeyboardController {

    private final KeyboardService keyboardService;

    public KeyboardController(KeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @GetMapping
    List<Keyboard> getKeyboards() {
        return keyboardService.getKeyboards();
    }

    @GetMapping(value = "{id}")
    Keyboard getKeyboardById(@PathVariable Long id) {
        return keyboardService.getKeyboardById(id);
    }

    @PostMapping("/addKeyboard")
    ResponseEntity<Keyboard> createKeyboard(@RequestBody KeyboardDto keyboardDto) {
        return this.keyboardService.createKeyboard(keyboardDto)
                .map(monitor -> ResponseEntity.ok().body(monitor))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping(value = "{id}")
    void deleteKeyboard(@PathVariable Long id) {
        keyboardService.deleteKeyboard(id);
    }
}
