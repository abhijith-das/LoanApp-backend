package com.loan.service;

import java.util.List;

import com.loan.common.APIResponse;
import com.loan.model.Customer;
import com.loan.model.Officer;

public interface IOfficerService {
	public Officer addOfficer(Officer officer);
	
	public Officer updateOfficer(Officer officer);

	public List<Officer> displayAll();
	
	public Officer displayOfficer(int id);

	public void deleteOfficer(int id);
}
