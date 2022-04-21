package com.bootcamp.bank.customers.database.repository;

import com.bootcamp.bank.customers.database.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {

    Mono<Customer> findBydocNumber(String docNumber);
    Mono<Void> deleteBydocNumber(String docNumber);
}
