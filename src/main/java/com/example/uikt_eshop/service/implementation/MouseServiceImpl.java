package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.dto.MouseDto;
import com.example.uikt_eshop.models.products.Monitor;
import com.example.uikt_eshop.models.products.Mouse;
import com.example.uikt_eshop.repository.CategoryRepository;
import com.example.uikt_eshop.repository.MouseRepository;
import com.example.uikt_eshop.service.MouseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MouseServiceImpl implements MouseService {

    private final MouseRepository mouseRepository;
    private final CategoryRepository categoryRepository;

    public MouseServiceImpl(MouseRepository mouseRepository, CategoryRepository categoryRepository) {
        this.mouseRepository = mouseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Mouse> getMouses() {
        return mouseRepository.findAll();
    }

    @Override
    public Mouse getMouseById(Long id) {
        return mouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mouse not found"));
    }

    @Transactional
    @Override
    public Optional<Mouse> createMouse(MouseDto mouseDto) {
        this.mouseRepository.deleteByName(mouseDto.getName());

        Category category = this.categoryRepository.findById(mouseDto.getCategory())
                .orElseThrow(() -> new com.example.uikt_eshop.models.exceptions.EntityNotFoundException("Category not found"));

        Mouse mouse = new Mouse(mouseDto.getName(),
                mouseDto.getPrice(),
                category,mouseDto.getCableLength(), mouseDto.getCableType(),
                mouseDto.getDPIResolution(), mouseDto.getIsGaming());

        this.mouseRepository.save(mouse);

        return Optional.of(mouse);
    }

    @Override
    public void updateMouse(Long id, Double price) {
        Mouse exitingMouse = getMouseById(id);
        exitingMouse.setPrice(price);
        mouseRepository.save(exitingMouse);
    }

    @Override
    public void deleteMouse(Long id) {
        mouseRepository.deleteById(id);
    }
}
