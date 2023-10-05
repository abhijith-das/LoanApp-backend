package com.loan.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_number")
	private Integer accountNumber;

	@Column(name = "customer_name", nullable = false, length = 60)
	private String customerName;

	@Column(name = "atm_pin")
	private Integer atmPin;
	
	@Column(name = "customer_type", nullable = false, length = 60)
	private String customerType;
	
	@Column(name = "email", nullable = false, length = 60)
	private String eMail;
	
	@Column(name = "phone_no", nullable = false, length = 60)
	private String phNo;
	
	@Column(name = "balance", nullable = false, length = 60)
	private double balance;
	
	private boolean isActive=true;

	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "min_balance", nullable = false, length = 60)
	private double minBalance;

	public Bank() {

		// TODO Auto-generated constructor stub
		
		super();
		Random random = new Random();
		
		this.accountNumber = 100000000 + random.nextInt(900000000);
		
		
		//Reserving 123456789 for login for admin. 
		//loop to prevent 123456789 from generating 
		
		while(this.accountNumber == 123456789)
			this.accountNumber = 100000000 + random.nextInt(900000000);
		
		
		this.atmPin = 1000 + random.nextInt(10000);
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public String getCustomerName() {
		
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(Integer atmPin) {
		this.atmPin = atmPin;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	
	
	

	

}
