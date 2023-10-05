package com.loan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.model.LoanTable;
import com.loan.repository.ILoanRepository;

@Transactional
@Service
public class LoanServiceImple implements ILoanService{
	
	@Autowired
	private ILoanRepository loanRepo;
	
	@Override
	public LoanTable addLoan(LoanTable loan) {
		// TODO Auto-generated method stub
		return loanRepo.save(loan);
	}

	@Override
	public LoanTable updateLoan(LoanTable culoanst) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanTable> displayAll() {
		// TODO Auto-generated method stub
		System.out.println("-------------------"); 
		System.out.println("display all loans");
		return (List<LoanTable>) loanRepo.findAll();
	}

	@Override
	public void deleteLoan(int id) {
		// TODO Auto-generated method stub
		loanRepo.deleteLoan(id);
	}

	@Override
	public LoanTable displayLoan(int id) {
		// TODO Auto-generated method stub
		return loanRepo.findById(id).orElseThrow(()->new RuntimeException("LoanTable not found for id "+id));
	}

	
}
