package com.espada.KafkaCustomer.events;

import com.espada.KafkaCustomer.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<Customer> {

}
