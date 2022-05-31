package com.espada.KafkaCustomer.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espada.KafkaCustomer.entity.Customer;
import com.espada.KafkaCustomer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }


}
