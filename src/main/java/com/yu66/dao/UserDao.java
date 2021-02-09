package com.yu66.dao;

import com.yu66.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends JpaRepository<User, Integer> {
}