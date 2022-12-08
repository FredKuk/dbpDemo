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

    // @Autowired
    // public CustomerControllerImpl(CustomerService customerService){
    //     this.customerService=customerService;
    // }

    @Override
    @GetMapping("")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Customer findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @Override
    @PostMapping(value = "", produces = "application/json")
    public Boolean create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @Override
    @PutMapping(value = "", produces = "application/json")
    public Boolean update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @Override
    @PatchMapping("/{id}")
    public Boolean delete(@PathVariable String id) {
        return customerService.delete(id);
    }    
}
