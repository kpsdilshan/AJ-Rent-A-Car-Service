package com.rentcarsplatform.profileservice.serviceImpl;

import com.rentcarsplatform.profileservice.model.Customer;
import com.rentcarsplatform.profileservice.repository.CustomerRepository;
import com.rentcarsplatform.profileservice.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        return  customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) throws ClassNotFoundException {

      Optional<Customer> customer = customerRepository.findById(id);

      if(customer==null) throw new ClassNotFoundException();
      return customer.get();
    }
}
