package com.example.mobilecustomer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    //Fetching all customers by id
    public List<Customer> getCustomers(){ return customerRepository.findAll();}


//    //Fetching all customers with specific service_types
//    public Optional <Customer> getCustomers(ServiceType serviceType){return customerRepository.findByServiceType(serviceType);}

    //Fetching specific customers by id
    public Optional<Customer> getCustomer(Integer id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer;
        }
        else throw new IllegalStateException("Customer with ID: " + id + " does not exist");
    }

    //Adding a new customer
    public void addCustomer(Customer customer){
        Optional <Customer> optionalCustomer = customerRepository.findByMsisdn(customer.getMsisdn());
        if(optionalCustomer.isPresent()){
            throw new IllegalStateException("Customer exists");
        }

        customerRepository.save(customer);
    }


    //Delete User
    public  void deleteCustomer(Integer id){
        boolean exists = customerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("User does not exists");
        }

        customerRepository.deleteById(id);
    }


    //Updating `msisdn` and `service_type`

    @Transactional
    public void updateCustomer(Integer id, String msisdn, ServiceType serviceType){
        //Fetching the user with the specified id
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                    "Customer with ID: " + id + " not found"
        ));


        //Updating MSISDN using parameters
        if (msisdn != null &&
                msisdn.length() > 0 &&
                !Objects.equals(customer.getMsisdn(), msisdn)) {
            Optional<Customer> customerOptional = customerRepository.findByMsisdn(msisdn);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("Number taken");

            }
            customer.setMsisdn(msisdn);
        }


        //UPDATING SERVICE TYPE
        if (serviceType != null && !Objects.equals(customer.getService_type(), serviceType)) {
            if(serviceType==ServiceType.MOBILE_POSTPAID || serviceType==ServiceType.MOBILE_PREPAID)
                customer.setService_type(serviceType);
            else
                throw new IllegalStateException("Chose either MOBILE_POSTPAID/MOBILE_PREPAID");
        }
    }
}
