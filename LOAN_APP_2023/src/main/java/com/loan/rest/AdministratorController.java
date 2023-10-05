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
import com.loan.model.Bank;
import com.loan.service.IAdministratorService;
import com.loan.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdministratorController {

	@Autowired
	private IAdministratorService adminService;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private JwtUtil jwtUtil;
	
//	//list all the customers
//	@GetMapping("/admin")
//	public List<Bank> getCustomer(@RequestHeader(value="authorization",defaultValue=" ")String auth) throws AccessDeniedException {
//		jwtUtil.verify(auth);
//		return adminService.displayAll();
//	}

//	//search for specific customer
//	@GetMapping("/admin/{id}")
//	public Bank getCustomer(@PathVariable int id, @RequestHeader(value="authorization",defaultValue=" ")String auth) throws AccessDeniedException{
//		jwtUtil.verify(auth);
//		return adminService.displayAccount(id);
//	}
//	
//	//add customer
//	@PostMapping("/admin")
//	public ResponseEntity<APIResponse> addCustomer(@RequestBody Bank bank,@RequestHeader(value="authorization",defaultValue=" ")String auth) throws AccessDeniedException {
//		jwtUtil.verify(auth);
//		if (adminService.addCustomer(bank) == null) {
//			apiResponse.setData("Check name again!");
//			apiResponse.setStatus(500);
//			apiResponse.setError("Invalid Name");
//			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//		}
//		apiResponse.setData("Customer added successfully");
//		apiResponse.setStatus(200);
//		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//
//	}
//	
//	
//	//delete customer. function sets is_active to false
//	@DeleteMapping("/admin/{id}")
//	public ResponseEntity<APIResponse> deleteCustomer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue=" ")String auth) throws AccessDeniedException{
//		jwtUtil.verify(auth);
//		APIResponse apiResponse = adminService.deleteCustomer(id);
//		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//
//	}
//	
//	//update customer
//	@PutMapping("/admin/update/{phNo}&{email}&{accNo}")
//	public ResponseEntity<APIResponse> updateCustomer
//	(@PathVariable long phNo, @PathVariable String email, @PathVariable int accNo,@RequestHeader(value="authorization",defaultValue=" ")String auth) throws AccessDeniedException{
//		jwtUtil.verify(auth);
//		APIResponse apiResponse = adminService.updateCustomer(phNo,email,accNo);
//		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//	}
//	
	//list all the customers
	@GetMapping("/admin")
	public List<Bank> getCustomer() throws AccessDeniedException {
		//jwtUtil.verify(auth);
		return adminService.displayAll();
	}

	//search for specific customer
	@GetMapping("/admin/{id}")
	public Bank getCustomer(@PathVariable int id) throws AccessDeniedException{
		//jwtUtil.verify(auth);
		return adminService.displayAccount(id);
	}
	
	//add customer
	@PostMapping("/admin")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Bank bank) throws AccessDeniedException {
		//jwtUtil.verify(auth);
		if (adminService.addCustomer(bank) == null) {
			apiResponse.setData("Check name again!");
			apiResponse.setStatus(500);
			apiResponse.setError("Invalid Name");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		apiResponse.setData("Customer added successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	
	
	//delete customer. function sets is_active to false
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<APIResponse> deleteCustomer(@PathVariable int id){
		//jwtUtil.verify(auth);
		APIResponse apiResponse = adminService.deleteCustomer(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	
	//update customer
	@PutMapping("/admin/update/{phNo}&{email}&{accNo}")
	public ResponseEntity<APIResponse> updateCustomer
	(@PathVariable long phNo, @PathVariable String email, @PathVariable int accNo){
		//jwtUtil.verify(auth);
		APIResponse apiResponse = adminService.updateCustomer(phNo,email,accNo);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	

}
