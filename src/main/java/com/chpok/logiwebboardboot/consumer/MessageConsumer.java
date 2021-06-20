package com.chpok.logiwebboardboot.consumer;
import com.chpok.logiwebboardboot.model.kafka.LogiwebMessage;

public interface MessageConsumer {
    void onMessage(LogiwebMessage message);

    void onUpdated(Long entityId);

    void onSaved(Long entityId);

    void onDeleted(Long entityId);
}
