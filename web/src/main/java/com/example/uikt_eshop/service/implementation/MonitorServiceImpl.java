package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.dto.MonitorDto;
import com.example.uikt_eshop.models.dto.ProductDto;
import com.example.uikt_eshop.models.exceptions.EntityNotFoundException;
import com.example.uikt_eshop.models.products.Monitor;
import com.example.uikt_eshop.repository.CategoryRepository;
import com.example.uikt_eshop.repository.MonitorRepository;
import com.example.uikt_eshop.service.IProductService;
import com.example.uikt_eshop.service.MonitorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorServiceImpl implements MonitorService {

    private final MonitorRepository monitorRepository;
    private final CategoryRepository categoryRepository;
    private final IProductService productService;

    public MonitorServiceImpl(MonitorRepository monitorRepository, CategoryRepository categoryRepository, IProductService productService) {
        this.monitorRepository = monitorRepository;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @Override
    public List<Monitor> getMonitors() {
        return monitorRepository.findAll();
    }

    @Override
    public Monitor getMonitorById(Long id) {
        return monitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Monitor not found"));
    }

    @Override
    public Optional<Monitor> createMonitor(MonitorDto monitorDto) {
        this.monitorRepository.deleteByName(monitorDto.getName());

        Category category = this.categoryRepository.findById(monitorDto.getCategory())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        Monitor monitor = new Monitor(monitorDto.getName(),
                monitorDto.getPrice(), category,
                monitorDto.getBackLightType(),
                monitorDto.getResolution(),monitorDto.getPowerInKw(), monitorDto.getColor());

        this.monitorRepository.save(monitor);

        return Optional.of(monitor);

    }

    @Override
    public Monitor updateMonitor(Long id, Monitor monitor) {
        Monitor existingMonitor = getMonitorById(id);
        BeanUtils.copyProperties(existingMonitor, monitor);
        return monitorRepository.save(existingMonitor);
    }

    @Override
    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }
}
