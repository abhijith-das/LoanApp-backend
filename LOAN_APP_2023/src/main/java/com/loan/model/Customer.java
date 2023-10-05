package com.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "customername", nullable = false, length = 60)
	private String customerName;
	
	@Column(name = "customerphno", nullable = false, length = 60)
	private String customerPhNo;
	
	@Column(name = "customerssn")
	private Integer customerSSN;
	
	private boolean isActive=true;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhNo() {
		return customerPhNo;
	}

	public void setCustomerPhNo(String customerPhNo) {
		this.customerPhNo = customerPhNo;
	}

	public Integer getCustomerSSN() {
		return customerSSN;
	}

	public void setCustomerSSN(Integer customerSSN) {
		this.customerSSN = customerSSN;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhNo="
				+ customerPhNo + ", customerSSN=" + customerSSN + ", isActive=" + isActive + "]";
	}
	
	
}
