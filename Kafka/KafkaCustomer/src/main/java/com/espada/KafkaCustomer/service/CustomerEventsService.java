package com.espada.KafkaCustomer.service;

import com.espada.KafkaCustomer.events.CustomerCreatedEvent;
import com.espada.KafkaCustomer.events.Event;
import com.espada.KafkaCustomer.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.espada.KafkaCustomer.entity.Customer;

import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")
    private String topicCustomer;

    public void publish(Customer customer) {

        CustomerCreatedEvent created = new CustomerCreatedEvent();
        created.setData(customer);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);
    }



}
