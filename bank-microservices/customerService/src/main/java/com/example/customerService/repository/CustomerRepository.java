package com.example.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customerService.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
