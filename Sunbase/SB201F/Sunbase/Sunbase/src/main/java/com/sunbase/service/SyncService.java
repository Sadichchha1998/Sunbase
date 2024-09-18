package com.sunbase.service;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sunbase.model.Customer;
import com.sunbase.repository.CustomerRepository;

@Service
public class SyncService {
 @Autowired
 private CustomerRepository customerRepository;

 private final String AUTH_URL = "https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
 private final String SYNC_URL = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";
 private final String LOGIN_ID = "test@sunbasedata.com";
 private final String PASSWORD = "Test@123";

 public void syncCustomers() {
     RestTemplate restTemplate = new RestTemplate();

     // Authenticate and get the token
     String token = authenticate(restTemplate);

     // Fetch customer list
     List<Customer> customers = fetchCustomers(restTemplate, token);

     // Save or update customers in the database
     for (Customer customer : customers) {
         customerRepository.findById(customer.getId()).ifPresentOrElse(
                 existingCustomer -> {
                     existingCustomer.setFirstName(customer.getFirstName());
                     existingCustomer.setLastName(customer.getLastName());
                     existingCustomer.setStreet(customer.getStreet());
                     existingCustomer.setAddress(customer.getAddress());
                     existingCustomer.setCity(customer.getCity());
                     existingCustomer.setState(customer.getState());
                     existingCustomer.setEmail(customer.getEmail());
                     existingCustomer.setPhone(customer.getPhone());
                     customerRepository.save(existingCustomer);
                 },
                 () -> customerRepository.save(customer)
         );
     }
 }

 private String authenticate(RestTemplate restTemplate) {
     // Authentication logic here
     // Call AUTH_URL with LOGIN_ID and PASSWORD to get the token
     // Return the token
     return "token";
 }

 private List<Customer> fetchCustomers(RestTemplate restTemplate, String token) {
     // Fetch customer list logic here
     // Call SYNC_URL with token to get the list of customers
     // Return the list of customers
     return Arrays.asList(new Customer());
 }
}

