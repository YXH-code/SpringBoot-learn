package com.yu66.service;

import com.yu66.entity.Customer;

public interface CustomerService {
    public boolean isExist(String username);
    public Customer getByName(String username);
    public Customer get(String username, String password);
    public void add(Customer customer);
}
