package com.chpok.logiwebboardboot.entity;

import java.util.Objects;

public class LocationDto {
    private Long id;
    private String name;

    public LocationDto() {

    }

    public LocationDto(String name) {
        this.name = name;
    }

    public LocationDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDto locationDto = (LocationDto) o;
        return Objects.equals(name, locationDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
