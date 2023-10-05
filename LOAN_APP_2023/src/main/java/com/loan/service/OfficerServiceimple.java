package com.loan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.common.APIResponse;
import com.loan.model.Officer;
import com.loan.repository.ICustomerRepository;
import com.loan.repository.IOfficerRepository;


@Transactional
@Service
public class OfficerServiceimple implements IOfficerService {

	
	@Autowired
	private IOfficerRepository officerRepo;
	
	@Override
	public Officer addOfficer(Officer officer) {
		// TODO Auto-generated method stub
		return officerRepo.save(officer);
	}

	@Override
	public Officer updateOfficer(Officer officer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Officer> displayAll() {
		// TODO Auto-generated method stub
		return (List<Officer>) officerRepo.findAll();
	}

	@Override
	public void deleteOfficer(int id) {
		// TODO Auto-generated method stub
		officerRepo.deleteOfficer(id);
	}

	@Override
	public Officer displayOfficer(int id) {
		// TODO Auto-generated method stub
		return officerRepo.findById(id).orElseThrow(()->new RuntimeException("Officer not found for id "+id));
	}

}
