package com.chpok.logiwebboardboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "location")
public class LocationEntity {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public LocationEntity() {

    }

    public LocationEntity(String name) {
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
        LocationEntity locationEntity = (LocationEntity) o;
        return Objects.equals(name, locationEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
