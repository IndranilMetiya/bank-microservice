package com.example.customerService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "bankId")
	    private Long bankId; // Bank ID to validate with Bank Service

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getBankId() {
			return bankId;
		}

		public void setBankId(Long bankId) {
			this.bankId = bankId;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", bankId=" + bankId + "]";
		}
	    
	    
	    
	    
	    
	}


