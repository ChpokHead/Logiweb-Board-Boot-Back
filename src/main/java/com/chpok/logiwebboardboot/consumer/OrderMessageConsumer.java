package com.chpok.logiwebboardboot.consumer;

import com.chpok.logiwebboardboot.entity.OrderDto;
import com.chpok.logiwebboardboot.mapper.Mapper;
import com.chpok.logiwebboardboot.mapper.OrderMapper;
import com.chpok.logiwebboardboot.model.OrderEntity;
import com.chpok.logiwebboardboot.model.kafka.LogiwebMessage;
import com.chpok.logiwebboardboot.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderMessageConsumer implements MessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMessageConsumer.class);
    private static final String GET_ORDER_URL = "http://localhost:8080/employeeOrder/orders/%d";

    private final OrderRepository orderRepository;
    private final Mapper<OrderDto, OrderEntity> entityMapper;
    private final RestTemplate restTemplate;

    public OrderMessageConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.entityMapper = new OrderMapper();
        this.restTemplate = new RestTemplate();
    }

    @Override
    @KafkaListener(topics = "logiweb-order", groupId = "demoGroup")
    public void onMessage(LogiwebMessage message) {
        LOGGER.info("New message: {} with id {}", message.getEntityEventMessage(), message.getEntityId());

        switch (message.getEntityEventMessage()) {
            case "orderUpdated":
                onUpdated(message.getEntityId());
                break;
            case "orderDeleted":
                onDeleted(message.getEntityId());
                break;
            case "orderSaved":
                onSaved(message.getEntityId());
                break;
            default:
                break;
        }
    }

    @Override
    public void onUpdated(Long entityId) {
        onSaved(entityId);
    }

    @Override
    public void onSaved(Long entityId) {
        final OrderDto orderDto = restTemplate.getForObject(String.format(GET_ORDER_URL, entityId), OrderDto.class);

        if (orderDto != null) {
            orderRepository.save(entityMapper.mapEnityToDto(orderDto));
        }
    }

    @Override
    public void onDeleted(Long entityId) {
        orderRepository.deleteById(entityId);
    }

}
