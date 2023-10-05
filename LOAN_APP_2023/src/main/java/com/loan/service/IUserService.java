package com.loan.service;

import com.loan.common.APIResponse;


public interface IUserService {
	
	public APIResponse findUserByNameAndPassword (String userName, String password);

}
