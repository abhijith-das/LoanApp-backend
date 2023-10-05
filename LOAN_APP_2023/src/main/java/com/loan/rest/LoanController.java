package com.loan.rest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.common.APIResponse;
import com.loan.model.LoanTable;
import com.loan.service.ILoanService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoanController {
	
	@Autowired
	private ILoanService loanService;

	@Autowired
	private APIResponse apiResponse;
	
	
	// show details of a single loan
		@GetMapping("/loan/{id}")
		public LoanTable getLoan(@PathVariable int id){
			//jwtUtil.verify(auth);
			return loanService.displayLoan(id);
		}

		// view all loans
		@GetMapping("/loan")
		public List<LoanTable> getLoan(){
			//jwtUtil.verify(auth);
			return loanService.displayAll();
		}
		
		//add new loan
		@PostMapping("/loan")
		public ResponseEntity<APIResponse> addLoan(@RequestBody LoanTable loan){
			if(loanService.addLoan(loan)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("Invalid Name");
				return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
			}
			apiResponse.setData("loan added successfully");
			apiResponse.setStatus(200);
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

		}
		
		//update loan
		@PutMapping("/loan")
		public void updateLoan(@RequestBody LoanTable loan) {
			loanService.addLoan(loan);
		}
		
		
		//delete a loan -- set is_active false
		@DeleteMapping("/loan/{id}")
		public void deleteLoan(@PathVariable int id) {
			
			loanService.deleteLoan(id);
		}

}
