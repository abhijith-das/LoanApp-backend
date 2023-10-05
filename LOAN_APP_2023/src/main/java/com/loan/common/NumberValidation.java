package com.loan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class NumberValidation {
	
	//function to validate  number 
		public boolean isNumValid(String num) {
			boolean bool = false;
			try {
				Pattern namePattern = Pattern.compile("[^0-9]");
				Matcher nameMatcher = namePattern.matcher(num);
				if(nameMatcher.find()) {
					throw new InvalidNameException("Invalid number. Characters not allowed");
					
				}
				else
					bool =true;
			}catch(InvalidNameException e) {
				e.getMessage();
			}
			return bool;
		}

}
