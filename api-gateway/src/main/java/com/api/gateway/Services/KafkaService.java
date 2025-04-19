package com.api.gateway.Services;

import com.api.gateway.DTOs.ProductRequest;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
@Slf4j
public class KafkaService {


    public void sendProducts(ProductRequest productRequest){

        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "${kafka.bootstrap.servers}");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Serializer<Object>.class);

        try(Producer<String, ProductRequest> producer = new KafkaProducer<>(properties)){
            producer.send(new ProducerRecord<>( "${kafka.topic}", productRequest), (metadata, exception)->{
                if(exception != null){
                    log.info("Product Record failed to send : {}", productRequest);
                } else {
                    log.info("Product record sent at offset : {} and topic {} :", metadata.offset(), metadata.topic());
                }
            });
        }
    }
}
