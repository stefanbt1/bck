package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.dto.LaptopDto;
import com.example.uikt_eshop.models.exceptions.EntityNotFoundException;
import com.example.uikt_eshop.models.products.Laptop;
import com.example.uikt_eshop.models.products.Mouse;
import com.example.uikt_eshop.repository.CategoryRepository;
import com.example.uikt_eshop.repository.LaptopRepository;
import com.example.uikt_eshop.service.LaptopService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;
    private final CategoryRepository categoryRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository, CategoryRepository categoryRepository) {
        this.laptopRepository = laptopRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Laptop> getLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Laptop not found"));
    }

    @Transactional
    @Override
    public Optional<Laptop> createLaptop(LaptopDto laptopDto) {
        this.laptopRepository.deleteByName(laptopDto.getName());

        Category category = this.categoryRepository.findById(laptopDto.getCategory())
                .orElseThrow(() -> new com.example.uikt_eshop.models.exceptions.EntityNotFoundException("Category not found"));

        Laptop laptop = new Laptop(laptopDto.getName(),
                laptopDto.getPrice(),
                category, laptopDto.getCPU(), laptopDto.getRAM(),
                laptopDto.getStorage(), laptopDto.getGPU(),
                laptopDto.getWeightInKg(), laptopDto.getOperatingSystem(),
                laptopDto.getDimensions());

        this.laptopRepository.save(laptop);

        return Optional.of(laptop);
    }

    @Override
    public void updateLaptop(Long id, Double price) {
        Laptop existingLaptop = getLaptopById(id);
        existingLaptop.setPrice(price);
        laptopRepository.save(existingLaptop);
    }

    @Override
    public void deleteLaptop(Long id) {
        laptopRepository.deleteById(id);
    }
}
