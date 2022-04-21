package com.bootcamp.bank.customers.service;

import com.bootcamp.bank.customers.database.model.Customer;
import reactor.core.publisher.Mono;


public interface OperationService {

    Mono<Customer> findCustomerById(String id);
    Mono<Customer> findCustomerByDocNumber(String docNumber);
    Mono<Customer> saveCustomer(Customer customer);
    Mono<Customer> updateCustomer(Customer customer);
    Mono<Void> deleteCustomer(String docNumber);
}
