package com.chpok.logiwebboardboot.mapper;

import com.chpok.logiwebboardboot.entity.OrderDto;
import com.chpok.logiwebboardboot.model.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<OrderDto, OrderEntity> {
    @Override
    public OrderEntity mapEnityToDto(OrderDto entity) {
        final OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId(entity.getId());
        orderEntity.setIsCompleted(entity.getIsCompleted());
        orderEntity.setCreationDate(entity.getCreationDate().toString());

        if (entity.getStartDate() != null) {
            orderEntity.setStartDate(entity.getStartDate().toString());
        } else {
            orderEntity.setStartDate("-");
        }

        if (entity.getEndDate() != null) {
            orderEntity.setEndDate(entity.getEndDate().toString());
        } else {
            orderEntity.setEndDate("-");
        }

        return orderEntity;
    }

    @Override
    public OrderDto mapDtoToEntity(OrderEntity dto) {
        return null;
    }
}
