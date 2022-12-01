package com.dbp.demo01.controller;
import java.util.List;

import com.dbp.demo01.model.Customer;

public interface CustomerController {
    public List<Customer> findAll();
    public Customer findById(int cusId);
    public Customer create(Customer customer);
    public Customer update(Customer customer);
    public Customer delete(int cusId);
}
