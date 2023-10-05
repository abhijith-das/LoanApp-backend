package com.loan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class CustTypeValidation {
	
	//function to validate name
	public boolean isTypeValid(String accType) {
		boolean bool = false;
		try {
			if (accType.equalsIgnoreCase("savings") || accType.equalsIgnoreCase("Current")) {

				bool = true;
			} else
				throw new Exception("Account can be only savings or current");
		} catch (Exception e) {
			e.getMessage();
		}
		return bool;
	}

	

}
