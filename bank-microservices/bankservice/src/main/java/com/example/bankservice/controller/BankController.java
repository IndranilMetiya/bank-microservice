package com.example.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankservice.entity.Bank;
import com.example.bankservice.repo.BankRepository;

@RestController
@RequestMapping("/banks")
public class BankController {
	@Autowired
    private BankRepository bankRepository;
	
	 @PostMapping
	    public Bank addBank(@RequestBody Bank bank) {
	        return bankRepository.save(bank);
	    }
	 
	 @GetMapping("/{id}")
	    public Bank getBank(@PathVariable Long id) {
	        return bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank not found"));
	    }

}
