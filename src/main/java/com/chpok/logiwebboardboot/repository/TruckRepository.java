package com.chpok.logiwebboardboot.repository;

import com.chpok.logiwebboardboot.model.TruckEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends CrudRepository<TruckEntity, Long> {
    List<TruckEntity> findByCurrentOrderIdEquals(String currentOrderIdEquals);
    List<TruckEntity> findByCurrentOrderIdNot(String currentOrderIdNot);
    List<TruckEntity> findByStatusEquals(Integer statusEquals);
}
