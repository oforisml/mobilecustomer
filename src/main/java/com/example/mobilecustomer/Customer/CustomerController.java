package com.example.mobilecustomer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path="api/customers")
public class CustomerController {
    public final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {this.customerService = customerService;}

    @GetMapping
    public List<Customer>getCustomerNumber(){ return customerService.getCustomers(); }

    @GetMapping(path = "{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") Integer id){
        return customerService.getCustomer(id);
    }

//    @GetMapping(path = "{service_type}")
//    public void getCustomer(@PathVariable("service_type")
//                                          @RequestParam(required = true) ServiceType serviceType){
//        customerService.getCustomers(serviceType);
//    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){

    }


    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomer(@PathVariable("id") Integer id,
                               @RequestParam(required = false) String msisdn,
                               @RequestParam(required = false, name = "service_type") ServiceType serviceType){
        customerService.updateCustomer(id, msisdn, serviceType);
    }

}