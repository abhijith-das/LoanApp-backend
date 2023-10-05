package com.loan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.common.APIResponse;
import com.loan.model.Customer;
import com.loan.service.ICustomerService;
import com.loan.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService custService;

	@Autowired
	private APIResponse apiResponse;
	


	// show details of a single customer
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable int id){
		//jwtUtil.verify(auth);
		return custService.displayCustomer(id);
	}

	// view all customers
	@GetMapping("/customer")
	public List<Customer> getCustomer(){
		//jwtUtil.verify(auth);
		return custService.displayAll();
	}
	
	//add new customer
	@PostMapping("/customer")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer){
		if(custService.addCustomer(customer)==null) {
			apiResponse.setData("Name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("Invalid Name");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		apiResponse.setData("customer added successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	
	//update customer
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer customer) {
		custService.addCustomer(customer);
	}
	
	
	//delete a customer -- set is_active false
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		
		custService.deleteCustomer(id);
	}
	
	
}
