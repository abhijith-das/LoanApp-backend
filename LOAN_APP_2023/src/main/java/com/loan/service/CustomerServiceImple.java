package com.loan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.common.APIResponse;
import com.loan.common.NameValidation;
import com.loan.common.NumberValidation;
import com.loan.model.Bank;
import com.loan.model.Customer;
import com.loan.repository.IAdministratorRepository;
import com.loan.repository.ICustomerRepository;

@Transactional
@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository custRepo;

	@Autowired
	private NumberValidation numValid;

	@Autowired
	private APIResponse apiResponse;

	@Override
	public Customer addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return custRepo.save(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> displayAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) custRepo.findAll();
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		custRepo.deleteCustomer(id);
	}

	@Override
	public Customer displayCustomer(int id) {
		// TODO Auto-generated method stub
		return custRepo.findById(id).orElseThrow(()->new RuntimeException("Customer not found for id "+id));
	}

	
	

}
