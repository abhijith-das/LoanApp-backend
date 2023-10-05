package com.loan.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.loan.common.APIResponse;
import com.loan.model.Bank;

public interface IAdministratorService {

	public Bank addCustomer(Bank bank);

	public Bank updateCustomer(Bank obj);

	public List<Bank> displayAll();
	
	public APIResponse deleteCustomer(int id);
	
	public Bank displayAccount(int id);
	
	public APIResponse updateCustomer(long no,String mail,int acNo);
}
