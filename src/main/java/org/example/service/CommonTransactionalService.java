package org.example.service;

import org.example.dao.CustomerRepository;
import org.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommonTransactionalService {

    @Autowired
    CustomerRepository customerRepository;


    //@Transactional(propagation = Propagation.SUPPORTS)
    //@Transactional(propagation = Propagation.MANDATORY)
    //@Transactional(propagation = Propagation.REQUIRED)
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    //@Transactional(propagation = Propagation.NEVER)
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional(propagation = Propagation.NESTED)
    public void updateB() {
        try {
            Optional<Customer> customerOpt = customerRepository.findById(2);
            if (!customerOpt.isPresent()) return;
            Customer customer = customerOpt.get();
            customer.setRemark("update B");
            customerRepository.save(customer);
            //int a = 1 / 0;
        } catch (Exception e) {
        }
    }

    //@Transactional(propagation = Propagation.SUPPORTS)
    @Transactional(propagation = Propagation.NESTED)
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    //@Transactional(propagation = Propagation.NEVER)
    //@Transactional(propagation = Propagation.NESTED)
    //@Transactional(propagation = Propagation.REQUIRED)
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateC() {
        //try {
        Optional<Customer> customerOpt = customerRepository.findById(3);
        if (!customerOpt.isPresent()) return;
        Customer customer = customerOpt.get();
        customer.setRemark("update C");
        customerRepository.save(customer);
        //int a = 1 / 0;
        //} catch (Exception e) {
        //}
    }

}
