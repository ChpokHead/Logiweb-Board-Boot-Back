package com.chpok.logiwebboardboot.mapper;

import com.chpok.logiwebboardboot.entity.DriverDto;
import com.chpok.logiwebboardboot.model.DriverEntity;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper implements Mapper<DriverDto, DriverEntity> {
    @Override
    public DriverEntity mapEnityToDto(DriverDto entity) {
        final DriverEntity driverEntity = new DriverEntity();

        driverEntity.setPersonalNumber(entity.getPersonalNumber());
        driverEntity.setFirstName(entity.getFirstName());
        driverEntity.setLastName(entity.getLastName());
        driverEntity.setStatus(entity.getStatus());
        driverEntity.setLocation(entity.getLocation().getName());
        driverEntity.setMonthWorkedHours(entity.getMonthWorkedHours());

        if (entity.getCurrentOrder() != null) {
            driverEntity.setCurrentOrderId(entity.getCurrentOrder().getId().toString());
        } else {
            driverEntity.setCurrentOrderId("-");
        }

        if (entity.getCurrentTruck() != null) {
            driverEntity.setCurrentTruckRegNumber(entity.getCurrentTruck().getRegNumber());
        } else {
            driverEntity.setCurrentTruckRegNumber("-");
        }

        return driverEntity;
    }

    @Override
    public DriverDto mapDtoToEntity(DriverEntity dto) {
        return null;
    }

}
