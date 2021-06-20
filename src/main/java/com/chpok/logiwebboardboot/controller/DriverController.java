package com.chpok.logiwebboardboot.controller;

import com.chpok.logiwebboardboot.model.DriverEntity;
import com.chpok.logiwebboardboot.repository.DriverRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/drivers")
    public List<DriverEntity> getDrivers() {
        return (List<DriverEntity>) driverRepository.findAll();
    }

    @GetMapping("/driversNotBusy")
    public List<DriverEntity> getNotBusyDrivers() {
        return driverRepository.findByCurrentOrderIdEquals("-");
    }

    @GetMapping("/driversBusy")
    public List<DriverEntity> getBusyDrivers() {
        return driverRepository.findByCurrentOrderIdNot("-");
    }
}
