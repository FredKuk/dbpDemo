package com.dbp.demo01.repository;

import java.util.List;

import com.dbp.demo01.model.Customer;


public interface CustomerRepository {
    public List<Customer> findAll();
    public Customer findById(String id);
    public Boolean create(Customer customer);
    public Boolean update(Customer customer);
    public Boolean delete(String id);
}
