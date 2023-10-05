package com.loan.service;

import java.util.HashMap;
//import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.common.APIResponse;
import com.loan.common.NameValidation;
import com.loan.model.User;
import com.loan.repository.IUserRepository;
import com.loan.util.JwtUtil;

@Service
public class UserServiceImple implements IUserService {
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Override
	public APIResponse findUserByNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		User user = userRepo.findUserByNameAndPassword(userName, password);
		if(user == null) {
			apiResponse.setData("Invalid credentials");
			return apiResponse;
		}
		//Object jwtUtil;
		String token = jwtUtil.generateJwt(user);
		
		Map <String, Object> data = new HashMap<String, Object> ();
		
		data.put("ACCESSTOKEN", token);
		data.put("role", user.getRoleId());
		data.put("UserName", user.getUserName());
		
		apiResponse.setStatus(200);
		apiResponse.setData(data);
		return apiResponse ;
	}
}
