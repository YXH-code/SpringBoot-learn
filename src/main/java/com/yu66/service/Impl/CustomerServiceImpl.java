package com.yu66.service.Impl;

import com.yu66.dao.CustomerDao;
import com.yu66.entity.Customer;
import com.yu66.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户登录的service层
 * @author: 俞先浩
 * @create: 2021-02-23 14:30
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean isExist(String username) {
        Customer customer = getByName(username);
        return null!=customer;
    }

    @Override
    public Customer getByName(String username) {
        return customerDao.findByUsername(username);
    }

    @Override
    public Customer get(String username, String password){
        return customerDao.getByUsernameAndPassword(username, password);
    }

    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }
}
