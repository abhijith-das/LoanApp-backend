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
import com.loan.model.Officer;
import com.loan.service.IOfficerService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OfficerController {
	
	
	@Autowired
	private IOfficerService officerService;

	@Autowired
	private APIResponse apiResponse;
	
	
	// show details of a single officer
		@GetMapping("/officer/{id}")
		public Officer getOfficer(@PathVariable int id){
			//jwtUtil.verify(auth);
			return officerService.displayOfficer(id);
		}

		// view all officers
		@GetMapping("/officer")
		public List<Officer> getOfficer(){
			//jwtUtil.verify(auth);
			return officerService.displayAll();
		}
		
		//add new officer
		@PostMapping("/officer")
		public ResponseEntity<APIResponse> addOfficer(@RequestBody Officer officer){
			if(officerService.addOfficer(officer)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("Invalid Name");
				return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
			}
			apiResponse.setData("officer added successfully");
			apiResponse.setStatus(200);
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

		}
		
		//update officer
		@PutMapping("/officer")
		public void updateOfficer(@RequestBody Officer officer) {
			officerService.addOfficer(officer);
		}
		
		
		//delete a officer -- set is_active false
		@DeleteMapping("/officer/{id}")
		public void deleteOfficer(@PathVariable int id) {
			
			officerService.deleteOfficer(id);
		}
	
}
