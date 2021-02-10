package com.yu66.dao;

import com.yu66.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public List<User> findByName(String name);

    public List<User> findByNameAndPassword(String name,String password);

    public List<User> findByNameOrPassword(String name,String password);
}
