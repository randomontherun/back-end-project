package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Customer customer1 = new Customer("Jane", "Doe", "111 Blank Street", "11111", "1234567890");
        customer1.setDivision(divisionRepository.getReferenceById(35L));
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jim", "Doe", "111 Blank Street", "11111", "1234567890");
        customer2.setDivision(divisionRepository.getReferenceById(35L));
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Joe", "Doe", "111 Blank Street", "11111", "1234567890");
        customer3.setDivision(divisionRepository.getReferenceById(35L));
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Jess", "Doe", "111 Blank Street", "11111", "1234567890");
        customer4.setDivision(divisionRepository.getReferenceById(35L));
        customerRepository.save(customer4);

        Customer customer5 = new Customer("Jorge", "Doe", "111 Blank Street", "11111", "1234567890");
        customer5.setDivision(divisionRepository.getReferenceById(35L));
        customerRepository.save(customer5);



    }
}
