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

		CreditScoreDAO dao = new CreditScoreDAO();
		int creditScore = 0;

		try {

			creditScore = dao.getCreditScore(ssn);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return creditScore;

	}

}
