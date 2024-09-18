package com.sunbase.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.hibernate.query.Page;

import com.sunbase.model.Customer;

public interface CustomerService {
	public void deleteCustomer(Long id);
	 public Optional<Customer> getCustomerById(Long id);

	 public Customer createCustomer(Customer customer);
	 public Page getAllCustomers(Pageable pageable);

	 public Customer updateCustomer(Long id, Customer customerDetails);

}
