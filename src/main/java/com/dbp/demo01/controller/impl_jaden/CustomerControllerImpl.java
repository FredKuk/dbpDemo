package com.dbp.demo01.controller.impl_jaden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbp.demo01.controller.CustomerController;
import com.dbp.demo01.model.Customer;
import com.dbp.demo01.service.CustomerService;

@RestController
@RequestMapping("/jaden/customer")
public class CustomerControllerImpl implements CustomerController{

    @Autowired
    private CustomerService customerService;

    @Override
    @GetMapping("")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    @GetMapping("/{cusId}")
    public Customer findById(@PathVariable int cusId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PostMapping(value = "", produces = "application/json")
    public Customer create(@RequestBody Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PutMapping(value = "", produces = "application/json")
    public Customer update(@RequestBody Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PatchMapping("/{cusId}")
    public Customer delete(@PathVariable int cusId) {
        // TODO Auto-generated method stub
        return null;
    }    
}
