package com.espada.KafkaNotifications.events;

import com.espada.KafkaNotifications.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<Customer> {

}
