package com.sunbase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sunbase.model.Customer;
import com.sunbase.repository.CustomerRepository;

@Service
public class CustomerServiceImpl  implements CustomerService{
 @Autowired
 private CustomerRepository customerRepository;

 public Customer createCustomer(Customer customer) {
     return customerRepository.save(customer);
 }

 public Customer updateCustomer(Long id, Customer customerDetails) {
     Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
     customer.setFirstName(customerDetails.getFirstName());
     customer.setLastName(customerDetails.getLastName());
     customer.setStreet(customerDetails.getStreet());
     customer.setAddress(customerDetails.getAddress());
     customer.setCity(customerDetails.getCity());
     customer.setState(customerDetails.getState());
     customer.setEmail(customerDetails.getEmail());
     customer.setPhone(customerDetails.getPhone());
     return customerRepository.save(customer);
 }


 public Page<Customer> getAllCustomers(Pageable pageable) {
     return customerRepository.findAll(pageable);
 }

 public Optional<Customer> getCustomerById(Long id) {
	Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isEmpty()) {
			throw new CustomerException("This costomer is not present in database");
		}
		
		return customer.get();
 }

 public void deleteCustomer(Long id) {
     customerRepository.deleteById(id);
 }

@Override
public org.hibernate.query.Page getAllCustomers(java.awt.print.Pageable pageable) {
	// TODO Auto-generated method stub
	return null;
}


}

