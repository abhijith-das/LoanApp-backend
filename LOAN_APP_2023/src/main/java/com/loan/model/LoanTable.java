package com.loan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tblloan")
public class LoanTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Integer loanId;
	
	private Integer customerid;
	@ManyToOne
	@JoinColumn(name="customerid",insertable =false, updatable = false)
	private Customer customer;
	
	private Integer officerid;
	@ManyToOne
	@JoinColumn(name="officerid",insertable =false, updatable = false)
	private Officer officer;
	
	@Column(name = "loanstatus", nullable = false, length = 60)
	private String loanStatus;
	
	@Column(name = "loancategory", nullable = false, length = 60)
	private String loanCategory;
	
	@Column(name = "dateofRequest")
	private LocalDate dateOfRequest;
	
	@Column(name = "bgverification", nullable = false, length = 60)
	private String bgVerification;
	
	@Column(name = "loanamt", nullable = false, length = 60)
	private String loanAmt;
	
	private boolean isActive=true;

	@Override
	public String toString() {
		return "LoanTable [loanId=" + loanId + ", customerid=" + customerid + ", customer=" + customer + ", officerid="
				+ officerid + ", officer=" + officer + ", loanStatus=" + loanStatus + ", loanCategory=" + loanCategory
				+ ", dateOfRequest=" + dateOfRequest + ", bgVerification=" + bgVerification + ", loanAmt=" + loanAmt
				+ ", isActive=" + isActive + "]";
	}

	public LoanTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getOfficerid() {
		return officerid;
	}

	public void setOfficerid(Integer officerid) {
		this.officerid = officerid;
	}

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getLoanCategory() {
		return loanCategory;
	}

	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}

	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public String getBgVerification() {
		return bgVerification;
	}

	public void setBgVerification(String bgVerification) {
		this.bgVerification = bgVerification;
	}

	public String getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(String loanAmt) {
		this.loanAmt = loanAmt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
	
	
	
	
	
	
}
