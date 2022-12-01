package com.dbp.demo01.service.impl_jaden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbp.demo01.model.Customer;
import com.dbp.demo01.repository.CustomerRepository;
import com.dbp.demo01.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
}
