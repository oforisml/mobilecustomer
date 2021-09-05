package com.example.mobilecustomer.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
           Customer cust1 = new Customer(
                    "0205230833",
                    3,
                    3,
                    ServiceType.valueOf("MOBILE_PREPAID")
            );
            Customer cust2 = new Customer(
                            "9547013414",
                            2,
                            6,
                            ServiceType.valueOf("MOBILE_PREPAID"));


            customerRepository.saveAll(
                    List.of(cust1, cust2)
            );
        };


    }


}
