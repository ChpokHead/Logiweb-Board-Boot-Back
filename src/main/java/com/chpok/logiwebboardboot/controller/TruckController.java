package com.chpok.logiwebboardboot.controller;

import com.chpok.logiwebboardboot.model.TruckEntity;
import com.chpok.logiwebboardboot.repository.TruckRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TruckController {
    private static final String NULL_ORDER_ID = "-";
    private final TruckRepository truckRepository;

    public TruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @GetMapping("/trucks")
    public List<TruckEntity> getTrucks(@RequestParam(name = "busy", required = false) Boolean isBusy,
                                       @RequestParam(name = "status", required = false) String status) {
        if (isBusy != null) {
            if (isBusy) {
                return truckRepository.findByCurrentOrderIdNot(NULL_ORDER_ID);
            } else {
                return truckRepository.findByCurrentOrderIdEquals(NULL_ORDER_ID);
            }
        }

        if (status != null) {
            if (status.equals("ok")) {
                return truckRepository.findByStatusEquals(0);
            } else if (status.equals("broken")) {
                return truckRepository.findByStatusEquals(1);
            }
        }

        return (List<TruckEntity>) truckRepository.findAll();
    }

}
