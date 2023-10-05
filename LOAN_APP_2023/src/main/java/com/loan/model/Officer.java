package com.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "officerdetails")
public class Officer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "officerid")
	private Integer officerId;
	
	@Column(name = "officername", nullable = false, length = 60)
	private String officerName;
	
	@Column(name = "officerphno", nullable = false, length = 60)
	private Integer officerPhNo;
	
	
	private boolean isActive=true;


	public Integer getOfficerId() {
		return officerId;
	}


	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}


	public String getOfficerName() {
		return officerName;
	}


	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}


	public Integer getOfficerPhNo() {
		return officerPhNo;
	}


	public void setOfficerPhNo(Integer officerPhNo) {
		this.officerPhNo = officerPhNo;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Officer() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Officer [officerId=" + officerId + ", officerName=" + officerName + ", officerPhNo="
				+ officerPhNo + ", isActive=" + isActive + "]";
	}
	
	
	
	
}
