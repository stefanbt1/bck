package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.dto.KeyboardDto;
import com.example.uikt_eshop.models.exceptions.EntityNotFoundException;
import com.example.uikt_eshop.models.products.Keyboard;
import com.example.uikt_eshop.models.products.Laptop;
import com.example.uikt_eshop.repository.CategoryRepository;
import com.example.uikt_eshop.repository.KeyboardRepository;
import com.example.uikt_eshop.service.KeyboardService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KeyboardServiceImpl implements KeyboardService {

    private final KeyboardRepository keyboardRepository;
    private final CategoryRepository categoryRepository;

    public KeyboardServiceImpl(KeyboardRepository keyboardRepository, CategoryRepository categoryRepository) {
        this.keyboardRepository = keyboardRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Keyboard> getKeyboards() {
        return keyboardRepository.findAll();
    }

    @Override
    public Keyboard getKeyboardById(Long id) {
        return keyboardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Keyboard not found"));
    }

    @Transactional
    @Override
    public Optional<Keyboard> createKeyboard(KeyboardDto keyboardDto) {
        this.keyboardRepository.deleteByName(keyboardDto.getName());

        Category category = this.categoryRepository.findById(keyboardDto.getCategory())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        Keyboard keyboard = new Keyboard(keyboardDto.getName(),
                keyboardDto.getPrice(),
                category, keyboardDto.getSpillResistant(),
                keyboardDto.getIsGaming(), keyboardDto.getCableLengthInCm(),
                keyboardDto.getNumberOfKeys());

        this.keyboardRepository.save(keyboard);

        return Optional.of(keyboard);
    }

    @Override
    public void updateKeyboard(Long id, Double  price) {
        Keyboard existingKeyboard = getKeyboardById(id);
        existingKeyboard.setPrice(price);
        keyboardRepository.save(existingKeyboard);
    }

    @Override
    public void deleteKeyboard(Long id) {
        keyboardRepository.deleteById(id);
    }
}
