package com.chpok.logiwebboardboot.mapper;

import com.chpok.logiwebboardboot.entity.TruckDto;
import com.chpok.logiwebboardboot.model.TruckEntity;
import org.springframework.stereotype.Component;

@Component
public class TruckMapper implements Mapper<TruckDto, TruckEntity> {
    @Override
    public TruckEntity mapEnityToDto(TruckDto entity) {
        final TruckEntity truckEntity = new TruckEntity();

        truckEntity.setId(entity.getId());
        truckEntity.setCapacity(entity.getCapacity());
        truckEntity.setLocation(entity.getLocation().getName());
        truckEntity.setStatus(entity.getStatus());
        truckEntity.setDriversShift(entity.getDriversShift());
        truckEntity.setRegNumber(entity.getRegNumber());

        if (entity.getCurrentOrder() != null) {
            truckEntity.setCurrentOrderId(entity.getCurrentOrder().getId().toString());
        } else {
            truckEntity.setCurrentOrderId("-");
        }

        return truckEntity;
    }

    @Override
    public TruckDto mapDtoToEntity(TruckEntity dto) {
        return null;
    }
}
