package com.loan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Customer;
import com.loan.model.Officer;

@Repository
public interface IOfficerRepository extends CrudRepository<Officer, Integer>{
	
	@Modifying
	@Query("UPDATE com.loan.model.Officer SET is_active = 0 where officerid = ?1")
	public void deleteOfficer(int id);

}
