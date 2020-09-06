package org.example.service;

import org.example.dao.CustomerRepository;
import org.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService {

    @Autowired
    CommonTransactionalService commonTransactionalService;

    @Autowired
    CustomerRepository customerRepository;

    //@Transactional(propagation = Propagation.SUPPORTS)
    @Transactional
    public void updateA() {
        commonTransactionalService.updateB();
        commonTransactionalService.updateC();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateD() {
        Customer customer = new Customer();
        customer.setName("D");
        //customerRepository.save(customer);

        try {
            commonTransactionalService.updateB();
            //commonTransactionalService.updateC();
        } catch (Exception e) {}

        //int a = 1/0;
    }

}
