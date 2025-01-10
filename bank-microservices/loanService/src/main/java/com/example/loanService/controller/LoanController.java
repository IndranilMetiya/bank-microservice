package com.example.loanService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.loanService.entity.Loan;
import com.example.loanService.repository.LoanRepository;

@RestController
@RequestMapping("/loans")
public class LoanController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoanRepository loanRepository;

	@PostMapping
	public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
		// Validate Customer
		String customerUrl = "http://CUSTOMERSERVICE/customers/" + loan.getCustomerId();
		ResponseEntity<String> customerResponse = restTemplate.getForEntity(customerUrl, String.class);

		if (customerResponse.getStatusCode().is2xxSuccessful()) {
			return ResponseEntity.ok(loanRepository.save(loan));
		} else {
			return ResponseEntity.badRequest().body(null);
		}

	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
	        return loanRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
}
