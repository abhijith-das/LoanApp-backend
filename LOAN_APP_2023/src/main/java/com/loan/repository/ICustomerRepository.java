package com.loan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer>{

	@Modifying
	@Query("UPDATE com.loan.model.Customer SET is_active = 0 where customerid = ?1")
	public void deleteCustomer(int id);
}
