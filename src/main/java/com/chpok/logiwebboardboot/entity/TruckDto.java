package com.chpok.logiwebboardboot.entity;


import java.util.List;

public class TruckDto {
    private Long id;
    private String regNumber;
    private Short driversShift;
    private Short capacity;
    private Integer status;
    private LocationDto locationDto;
    private List<DriverDto> currentDriverEntities;
    private OrderDto currentOrderDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public Short getDriversShift() {
        return driversShift;
    }

    public Short getCapacity() {
        return capacity;
    }

    public Integer getStatus() {
        return status;
    }

    public LocationDto getLocation() {
        return locationDto;
    }

    public List<DriverDto> getCurrentDrivers() {
        return currentDriverEntities;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setDriversShift(Short driversShift) {
        this.driversShift = driversShift;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setLocation(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public void setCurrentDrivers(List<DriverDto> currentDriverEntities) {
        this.currentDriverEntities = currentDriverEntities;
    }

    public OrderDto getCurrentOrder() {
        return currentOrderDto;
    }

    public void setCurrentOrder(OrderDto currentOrderDto) {
        this.currentOrderDto = currentOrderDto;
    }
}
