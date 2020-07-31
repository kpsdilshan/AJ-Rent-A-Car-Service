package com.rentcarsplatform.profileservice.service;

import com.rentcarsplatform.profileservice.model.Customer;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

}
