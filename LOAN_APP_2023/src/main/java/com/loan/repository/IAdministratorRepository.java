package com.loan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Bank;

@Repository
public interface IAdministratorRepository extends CrudRepository<Bank, Integer>{

	@Modifying
	@Query("UPDATE com.loan.model.Bank SET is_active = 0 where account_number = ?1")
	public void deleteCustomer(int id);
	
	@Modifying
	@Query("UPDATE com.loan.model.Bank SET phone_no = ?1, email = ?2 where account_number = ?3")
	public void updateCustomer(long no,String mail,int acNo);
}
