package com.sunbase.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbase.model.Customer;
import com.sunbase.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
 @Autowired
 private CustomerService customerService;

 @PostMapping
 public Customer createCustomer(@RequestBody Customer customer) {
     return customerService.createCustomer(customer);
 }

 @PutMapping("/{id}")
 public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
     return customerService.updateCustomer(id, customerDetails);
 }

 @GetMapping
 public Page<Customer> getAllCustomers(Pageable pageable) {
     return customerService.getAllCustomers(pageable);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
     Optional<Customer> customer = customerService.getCustomerById(id);
     if (customer.isPresent()) {
         return ResponseEntity.ok(customer.get());
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
     customerService.deleteCustomer(id);
     return ResponseEntity.noContent().build();
 }
}

