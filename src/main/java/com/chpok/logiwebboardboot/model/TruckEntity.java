package com.chpok.logiwebboardboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class TruckEntity {
    @Id
    private Long id;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "drivers_shift")
    private Short driversShift;

    @Column(name = "capacity")
    private Short capacity;

    @Column(name = "status")
    private Integer status;

    @Column(name = "location")
    private String location;

    @Column(name = "current_order_id")
    private String currentOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Short getDriversShift() {
        return driversShift;
    }

    public void setDriversShift(Short driversShift) {
        this.driversShift = driversShift;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(String currentOrderId) {
        this.currentOrderId = currentOrderId;
    }

}
