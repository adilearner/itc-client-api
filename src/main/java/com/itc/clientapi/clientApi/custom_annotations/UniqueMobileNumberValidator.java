package com.itc.clientapi.clientApi.custom_annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itc.clientapi.clientApi.dao.ClientDaoService;

@Component
public class UniqueMobileNumberValidator implements ConstraintValidator<UniqueMobileNumber, String> {

    @Autowired
    ClientDaoService clientDaoService;

 
    public boolean isValid(String mobNo, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return !clientDaoService.existsByMobNo(mobNo);
	}
}
