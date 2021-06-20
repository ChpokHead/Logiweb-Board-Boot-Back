package com.chpok.logiwebboardboot.entity;

import java.util.Objects;

public class DriverDto {
    private Long personalNumber;
    private String firstName;
    private String lastName;
    private Short monthWorkedHours;
    private Integer status;
    private LocationDto locationDto;
    private TruckDto currentTruckDto;
    private OrderDto currentOrderDto;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Short getMonthWorkedHours() {
        return monthWorkedHours;
    }

    public void setMonthWorkedHours(Short monthWorkedHours) {
        this.monthWorkedHours = monthWorkedHours;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocationDto getLocation() {
        return locationDto;
    }

    public void setLocation(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public TruckDto getCurrentTruck() {
        return currentTruckDto;
    }

    public void setCurrentTruck(TruckDto currentTruckDto) {
        this.currentTruckDto = currentTruckDto;
    }

    public OrderDto getCurrentOrder() {
        return currentOrderDto;
    }

    public void setCurrentOrder(OrderDto currentOrderDto) {
        this.currentOrderDto = currentOrderDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverDto driverDto = (DriverDto) o;
        return firstName.equals(driverDto.firstName) && lastName.equals(driverDto.lastName) && monthWorkedHours.equals(driverDto.monthWorkedHours) && status.equals(driverDto.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, monthWorkedHours, status, locationDto);
    }
}
