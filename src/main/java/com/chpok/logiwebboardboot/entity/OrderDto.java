package com.chpok.logiwebboardboot.entity;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {
    private Long id;
    private Boolean isCompleted;
    private TruckDto currentTruckDto;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<DriverDto> driverEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public TruckDto getCurrentTruck() {
        return currentTruckDto;
    }

    public void setCurrentTruck(TruckDto currentTruckDto) {
        this.currentTruckDto = currentTruckDto;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
