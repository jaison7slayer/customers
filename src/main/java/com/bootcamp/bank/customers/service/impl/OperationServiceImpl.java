package com.bootcamp.bank.customers.service.impl;

import com.bootcamp.bank.customers.database.model.Customer;
import com.bootcamp.bank.customers.database.repository.CustomerRepository;
import com.bootcamp.bank.customers.service.OperationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final @NonNull CustomerRepository customerRepository;

    @Override
    public Mono<Customer> findCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> findCustomerByDocNumber(String docNumber) {
        return customerRepository.findBydocNumber(docNumber);
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer) {
        return customerRepository.save(customer).doOnSuccess(subscriber -> log.info("Customer created"));
    }

    @Override
    public Mono<Customer> updateCustomer(Customer customer) {
        return customerRepository.findBydocNumber(customer.getDocNumber())
                .map(c -> {
                    customer.setId(c.getId());
                    customerRepository.save(customer).subscribe();
                    return customer;
                });
    }

    @Override
    public Mono<Void> deleteCustomer(String docNumber) {
        return customerRepository.deleteBydocNumber(docNumber);
    }
}
