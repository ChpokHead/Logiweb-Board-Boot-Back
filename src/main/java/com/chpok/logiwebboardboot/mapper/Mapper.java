package com.chpok.logiwebboardboot.mapper;

public interface Mapper <E, D>{
    D mapEnityToDto(E entity);
    E mapDtoToEntity(D dto);
}
