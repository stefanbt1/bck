package com.example.uikt_eshop.service;

import com.example.uikt_eshop.models.dto.MonitorDto;
import com.example.uikt_eshop.models.products.Monitor;

import java.util.List;
import java.util.Optional;

public interface MonitorService {

    List<Monitor> getMonitors();

    Monitor getMonitorById(Long id);

    Optional<Monitor> createMonitor(MonitorDto monitor);

    Monitor updateMonitor(Long id, Monitor monitor);

    void deleteMonitor(Long id);
}
