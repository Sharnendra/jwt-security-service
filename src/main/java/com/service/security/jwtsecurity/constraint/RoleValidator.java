package com.service.security.jwtsecurity.constraint;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class RoleValidator implements ConstraintValidator<Roles, HttpServletRequest>{

	List<String> valuex;
	
	@Override
    public void initialize(Roles roles) {
		valuex=Arrays.asList(roles.value());
    }
	@Override
	public boolean isValid(HttpServletRequest httpServletRequest, ConstraintValidatorContext arg1) {
    	
		return false;
	}
	

}
