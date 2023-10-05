package com.loan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loan.common.APIResponse;
import com.loan.common.CustTypeValidation;
import com.loan.common.NameValidation;
import com.loan.common.PhNoValidation;
import com.loan.model.Bank;
import com.loan.repository.IAdministratorRepository;

@Service
public class AdministratorServiceImple implements IAdministratorService {

	
	@Autowired
	private IAdministratorRepository bankRepo;
	
	@Autowired
	private NameValidation nameValid;
	
	@Autowired
	private CustTypeValidation typeValid;
	
	@Autowired
	private PhNoValidation phNoValid;
	
	@Autowired
	private APIResponse apiResponse;

	
	@Override
	public Bank addCustomer(Bank bank) {
		// TODO Auto-generated method stub
		if(nameValid.isNameValid(bank.getCustomerName()))
			return bankRepo.save(bank);
		//checking if acc type is savings or current
		else if(typeValid.isTypeValid(bank.getCustomerType()))
			return bankRepo.save(bank);
		return null;
	}

	@Override
	public Bank updateCustomer(Bank obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bank> displayAll() {
		// TODO Auto-generated method stub
		return (List<Bank>) bankRepo.findAll();
	}

	@Transactional
	@Override
	public APIResponse deleteCustomer(int id) {
		// TODO Auto-generated method stub
		bankRepo.deleteCustomer(id);
		apiResponse.setData("Deletion successful!");
		apiResponse.setStatus(200);
		//apiResponse.setError("deleted");
		return apiResponse;
	}

	@Override
	public Bank displayAccount(int id) {
		// TODO Auto-generated method stub
		return bankRepo.findById(id).orElseThrow(()->new RuntimeException("Account not found for id "+id));

	}
	
	@Transactional
	@Override
	public APIResponse updateCustomer(long no, String mail, int acNo) {
		// TODO Auto-generated method stub
		bankRepo.updateCustomer(no, mail, acNo);
		apiResponse.setData("Updation successful!");
		apiResponse.setStatus(200);
		//apiResponse.setError("Invalid number");
		return apiResponse;
		
	}
	
	

}
