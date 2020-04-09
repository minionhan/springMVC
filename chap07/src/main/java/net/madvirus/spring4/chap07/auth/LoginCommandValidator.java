package net.madvirus.spring4.chap07.auth;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz){
		return LoginCommand.class.isAssignableFrom(clazz);
	}
						//@Valid
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "email", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		
	}

}
