package com.rentcarsplatform.profileservice.controller;

import com.rentcarsplatform.profileservice.model.Customer;
import com.rentcarsplatform.profileservice.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/service")
@RestController
public class CustomerController {

    @Autowired
        CustomerServiceImpl customerService;


  @RequestMapping(value = "/profile", method = RequestMethod.POST)
  @PreAuthorize("hasAuthority('create_profile')")
  public ResponseEntity saveCustomer(@RequestBody Customer customer){
    Customer customer1=customerService.saveCustomer(customer);

    if (customer1!=null){
      return ResponseEntity.ok(customer);
    }else{
      return ResponseEntity.ok("Not Successful");
    }
  }

  @RequestMapping(value = "/profiles", method = RequestMethod.GET)
  @PreAuthorize("hasRole('ROLE_editor')")
  public ResponseEntity<?> getAllCustomers(){
    return ResponseEntity.ok(customerService.getAllCustomers());
  }

  @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
  @PreAuthorize("hasAnyRole('ROLE_admin','ROLE_operator')")
  public ResponseEntity<?> getCustomerById(@PathVariable int id) throws ClassNotFoundException {
    return ResponseEntity.ok(customerService.getCustomerById(id));
  }
}
