package com.creditbureau.creditscore.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * This is an interface with getCreditScore method
 * @author Jude Mariarajan
 *
 */
@WebService
public interface CreditScoreService {
	
	@WebMethod
	public int getCreditScoreBySSN(String ssn);

}
