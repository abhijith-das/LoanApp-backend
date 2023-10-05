package com.loan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class NameValidation {
	
	//function to validate name
	public boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^A-Za-z]");
			Matcher nameMatcher = namePattern.matcher(name);
			//verify for alphabets only
			if(nameMatcher.find()) {
				throw new InvalidNameException("Hey! Invalid name");
				
			}
			//to check length of customer name
			else if(name.length()>30)
				throw new InvalidNameException("Hey! Name is too long");
			else
				bool =true;
		}catch(InvalidNameException e) {
			e.getMessage();
		}
		return bool;
	}

	

}
