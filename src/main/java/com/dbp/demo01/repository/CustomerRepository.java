package com.dbp.demo01.repository;

import java.util.List;

import com.dbp.demo01.model.Customer;


public interface CustomerRepository {
    public List<Customer> findAll();
}
