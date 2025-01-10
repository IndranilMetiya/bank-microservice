package com.example.bankservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankservice.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
