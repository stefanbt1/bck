package com.example.uikt_eshop.web;

import com.example.uikt_eshop.models.dto.MonitorDto;
import com.example.uikt_eshop.models.dto.MouseDto;
import com.example.uikt_eshop.models.products.Monitor;
import com.example.uikt_eshop.models.products.Mouse;
import com.example.uikt_eshop.service.MouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mice")
public class MouseController {
    private final MouseService mouseService;

    public MouseController(MouseService mouseService) {
        this.mouseService = mouseService;
    }

    @GetMapping
    public List<Mouse> getMouses(){
        return mouseService.getMouses();
    }

    @GetMapping("/{id}")
    public Mouse getMouseById(@PathVariable Long id){
        return mouseService.getMouseById(id);
    }

    @PostMapping(value="/addMice")
    ResponseEntity<Mouse> createMouse(@RequestBody MouseDto mouseDto) {
        return this.mouseService.createMouse(mouseDto)
                .map(monitor -> ResponseEntity.ok().body(monitor))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public void deleteMouse(@PathVariable Long id){
        mouseService.deleteMouse(id);
    }
}
