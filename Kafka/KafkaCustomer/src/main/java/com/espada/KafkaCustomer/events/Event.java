package com.espada.KafkaCustomer.events;

import lombok.Data;

import java.util.Date;

//Clase para definir datos del mensaje
@Data
public abstract class Event <T> {
    private String id;
    private Date date;
    private EventType type;
    private T data;
}
