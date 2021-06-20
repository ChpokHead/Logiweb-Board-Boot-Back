package com.chpok.logiwebboardboot.repository;

import com.chpok.logiwebboardboot.model.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    List<OrderEntity> findTop10ByOrderByIdDesc();
}
