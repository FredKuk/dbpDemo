package com.dbp.demo01.service.impl_jaden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbp.demo01.model.Customer;
import com.dbp.demo01.repository.CustomerRepository;
import com.dbp.demo01.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String id){
        return customerRepository.findById(id);
    }

    @Override
    public Boolean create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public Boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public Boolean delete(String id){
        return customerRepository.delete(id);
    }
}
