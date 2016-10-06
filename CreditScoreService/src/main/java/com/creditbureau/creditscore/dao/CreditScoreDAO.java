package com.creditbureau.creditscore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * In this class, we will get the creditScore from the database by SSN
 * 
 * @author Jude Mariarajan
 *
 */
public class CreditScoreDAO {

	/**
	 * This method will check the available ssn and return the credtiScore from
	 * the table by using JPA
	 * 
	 * @param ssn
	 * @return creditScore
	 */
	public int getCreditScore(String ssn) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CreditScoreService");

		EntityManager entitymanager = emfactory.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Integer> creditScoreList = entitymanager.createNativeQuery("select creditScore from creditscore_info where ssn='" + ssn + "'").getResultList();

		if (creditScoreList.isEmpty()){
			System.out.println("Invalid SSN");
			return 0;
		}
			
		else
			return creditScoreList.get(0);

	}
}
