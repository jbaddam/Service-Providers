package com.creditbureau.creditscore.service;

import javax.jws.WebService;

import com.creditbureau.creditscore.dao.CreditScoreDAO;

/**
 * This class is an implementation class, It implements the CreditScoreService
 * interface In this class, We can get the creditScore by SSN from the DAO Layer
 * 
 * @author Jude Mariarajan
 *
 */
@WebService(endpointInterface = "com.creditbureau.creditscore.service.CreditScoreService", serviceName = "CreditScoreService")
public class CreditScoreServiceImpl implements CreditScoreService {

	public int getCreditScoreBySSN(String ssn) {

		if (ssn != null)
			return new CreditScoreDAO().getCreditScore(ssn);
		else{
			System.out.println("Invalid SSN. Please try with valid SSN");
			return 0;
		}
			
	}

}
