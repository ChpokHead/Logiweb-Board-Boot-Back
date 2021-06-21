package com.chpok.logiwebboardboot.consumer;

import com.chpok.logiwebboardboot.entity.DriverDto;
import com.chpok.logiwebboardboot.mapper.DriverMapper;
import com.chpok.logiwebboardboot.mapper.Mapper;
import com.chpok.logiwebboardboot.model.DriverEntity;
import com.chpok.logiwebboardboot.model.kafka.LogiwebMessage;
import com.chpok.logiwebboardboot.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DriverMessageConsumer implements MessageConsumer{
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverMessageConsumer.class);
    private static final String GET_DRIVER_URL = "http://localhost:8080/employeeDriver/drivers/%d";

    private final DriverRepository driverRepository;
    private final Mapper<DriverDto, DriverEntity> entityMapper;
    private final RestTemplate restTemplate;

    public DriverMessageConsumer(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
        this.entityMapper = new DriverMapper();
        this.restTemplate = new RestTemplate();
    }

    @Override
    @KafkaListener(topics = "logiweb-driver", groupId = "demoGroup")
    public void onMessage(LogiwebMessage message){
        LOGGER.info("New message: {} with id {}", message.getEntityEventMessage(), message.getEntityId());

        switch (message.getEntityEventMessage()) {
            case "driver updated":
                onUpdated(message.getEntityId());
                break;
            case "driver deleted":
                onDeleted(message.getEntityId());
                break;
            case "driver saved":
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
        final DriverDto driverDto = restTemplate.getForObject(String.format(GET_DRIVER_URL, entityId), DriverDto.class);

        if (driverDto != null) {
            driverRepository.save(entityMapper.mapEnityToDto(driverDto));
        }
    }

    @Override
    public void onDeleted(Long entityId) {
        driverRepository.deleteById(entityId);
    }

}
