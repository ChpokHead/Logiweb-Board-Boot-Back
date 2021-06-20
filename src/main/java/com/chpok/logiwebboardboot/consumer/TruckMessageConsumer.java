package com.chpok.logiwebboardboot.consumer;

import com.chpok.logiwebboardboot.entity.TruckDto;
import com.chpok.logiwebboardboot.mapper.Mapper;
import com.chpok.logiwebboardboot.mapper.TruckMapper;
import com.chpok.logiwebboardboot.model.TruckEntity;
import com.chpok.logiwebboardboot.model.kafka.LogiwebMessage;
import com.chpok.logiwebboardboot.repository.TruckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TruckMessageConsumer implements MessageConsumer{
    private static final Logger LOGGER = LoggerFactory.getLogger(TruckMessageConsumer.class);
    private static final String GET_TRUCK_URL = "http://localhost:8080/employeeTruck/trucks/%d";

    private final TruckRepository truckRepository;
    private final Mapper<TruckDto, TruckEntity> entityMapper;
    private final RestTemplate restTemplate;

    public TruckMessageConsumer(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
        this.entityMapper = new TruckMapper();
        this.restTemplate = new RestTemplate();
    }

    @Override
    @KafkaListener(topics = "logiweb-truck", groupId = "demoGroup")
    public void onMessage(LogiwebMessage message){
        LOGGER.info("New message: {} with id {}", message.getEntityEventMessage(), message.getEntityId());

        switch (message.getEntityEventMessage()) {
            case "truck updated":
                onUpdated(message.getEntityId());
                break;
            case "truck deleted":
                onDeleted(message.getEntityId());
                break;
            case "truck saved":
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
        final TruckDto truckDto = restTemplate.getForObject(String.format(GET_TRUCK_URL, entityId), TruckDto.class);

        if (truckDto != null) {
            truckRepository.save(entityMapper.mapEnityToDto(truckDto));
        }
    }

    @Override
    public void onDeleted(Long entityId) {
        truckRepository.deleteById(entityId);
    }
}
