package com.chpok.logiwebboardboot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "driver")
public class DriverEntity {
    @Id
    @Column(name = "id")
    private Long personalNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "month_worked_hours")
    private Short monthWorkedHours;

    @Column(name = "status")
    private Integer status;

    @Column(name = "location")
    private String location;

    @Column(name = "current_truck_reg_number")
    private String currentTruckRegNumber;

    @Column(name = "current_order_id")
    private String currentOrderId;

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrentTruckRegNumber() {
        return currentTruckRegNumber;
    }

    public void setCurrentTruckRegNumber(String currentTruckRegNumber) {
        this.currentTruckRegNumber = currentTruckRegNumber;
    }

    public String getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(String currentOrderId) {
        this.currentOrderId = currentOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverEntity driverEntity = (DriverEntity) o;
        return firstName.equals(driverEntity.firstName) && lastName.equals(driverEntity.lastName) && monthWorkedHours.equals(driverEntity.monthWorkedHours) && status.equals(driverEntity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, monthWorkedHours, status, location, currentOrderId, currentTruckRegNumber);
    }
}
