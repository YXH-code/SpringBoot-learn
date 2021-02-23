package com.yu66.dao;

import com.yu66.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
    Customer getByUsernameAndPassword(String username,String password);
}
