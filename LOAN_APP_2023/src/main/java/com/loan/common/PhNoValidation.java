package com.loan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class PhNoValidation {
	
	//function to validate phone number 
		public boolean isPhNoValid(String phNo) {
			boolean bool = false;
			try {
				Pattern namePattern = Pattern.compile("[^0-9]");
				Matcher nameMatcher = namePattern.matcher(phNo);
				if(!nameMatcher.find()) {
					throw new InvalidNameException("Invalid phone number. Characters not allowed");
					
				}
				else if(phNo.length()!=10)
					throw new InvalidNameException("Check Phone number again...");
				else
					bool =true;
			}catch(InvalidNameException e) {
				e.getMessage();
			}
			return bool;
		}

}
