package com.loan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Customer;
import com.loan.model.LoanTable;

@Repository
public interface ILoanRepository extends CrudRepository<LoanTable, Integer>{
	
	@Modifying
	@Query("UPDATE com.loan.model.LoanTable SET is_active = 0 where loan_id = ?1")
	public void deleteLoan(int id);
}
