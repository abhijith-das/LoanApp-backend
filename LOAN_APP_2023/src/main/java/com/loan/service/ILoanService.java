package com.loan.service;

import java.util.List;

import com.loan.common.APIResponse;
import com.loan.model.LoanTable;

public interface ILoanService {
	
	public LoanTable addLoan(LoanTable loan);
	
	public LoanTable updateLoan(LoanTable loan);

	public List<LoanTable> displayAll();

	public void deleteLoan(int id);
	
	public LoanTable displayLoan(int id);


}
