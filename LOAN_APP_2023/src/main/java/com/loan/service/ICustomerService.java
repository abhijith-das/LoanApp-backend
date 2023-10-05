package com.loan.service;

import java.util.List;

import com.loan.common.APIResponse;
import com.loan.model.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer cust);
	
	public Customer updateCustomer(Customer cust);

	public List<Customer> displayAll();
	
	public Customer displayCustomer(int id);

	public void deleteCustomer(int id);
	
}
