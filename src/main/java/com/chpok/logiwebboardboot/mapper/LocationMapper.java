package com.chpok.logiwebboardboot.mapper;

import com.chpok.logiwebboardboot.entity.LocationDto;
import com.chpok.logiwebboardboot.model.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements Mapper<LocationDto, LocationEntity> {
    @Override
    public LocationEntity mapEnityToDto(LocationDto entity) {
        final LocationEntity locationEntity = new LocationEntity();

        locationEntity.setId(entity.getId());
        locationEntity.setName(entity.getName());

        return locationEntity;
    }

    @Override
    public LocationDto mapDtoToEntity(LocationEntity dto) {
        return null;
    }
}
