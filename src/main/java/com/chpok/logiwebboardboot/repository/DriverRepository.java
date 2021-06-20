package com.chpok.logiwebboardboot.repository;

import com.chpok.logiwebboardboot.model.DriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, Long> {
    List<DriverEntity> findByCurrentOrderIdEquals(String currentOrderIdEquals);
    List<DriverEntity> findByCurrentOrderIdNot(String currentOrderIdNot);
}
