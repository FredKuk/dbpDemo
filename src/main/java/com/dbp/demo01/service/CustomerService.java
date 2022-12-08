package com.dbp.demo01.service;

import java.util.List;

import com.dbp.demo01.model.Customer;

public interface CustomerService {
    public List<Customer> findAll();
    public Customer findById(String id);
    public Boolean create(Customer customer);
    public Boolean update(Customer customer);
    public Boolean delete(String id);
}
