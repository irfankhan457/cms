package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositoryDAO extends CrudRepository<Customer, Integer> {

    @Override
    public List<Customer> findAll();
}
