package com.creditbureau.creditscore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.creditbureau.creditscore.model.CreditScore;

/**
 * In this class, we will get the creditScore from the database by SSN
 * @author Jude Mariarajan
 *
 */
public class CreditScoreDAO {

	public int getCreditScore(String ssn) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CreditScoreService");

		EntityManager entitymanager = emfactory.createEntityManager();

		CreditScore creditScore = entitymanager.find(CreditScore.class, ssn);

		return creditScore.getCreditScore();

	}
	
/*	public int getMultipleCreditScore(String ssn){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CreditScoreService");

		EntityManager entitymanager = emfactory.createEntityManager();

		CreditScore creditScore = null;
		
		CharSequence cs = ":";
		
		boolean result = ssn.contains(cs);
		
		int score = 0;
		
		if(result == true){
			
			String [] value = ssn.split(":");
			
	//		for(int i = 0; i < value.length ;i++){
			
			for(String str: value){
				
				creditScore = entitymanager.find(CreditScore.class, str);
			
				score = creditScore.getCreditScore() + score;		

			}		
			
		} else {
			
			creditScore = entitymanager.find(CreditScore.class, ssn);
			
			score =  creditScore.getCreditScore();
		}
		
		return score;
		
	}
	
	public static void main(String[] args) {
		
		int score = new CreditScoreDAO().getMultipleCreditScore("123456789:456789123:789123456");
		
		System.out.println(score);
	}
*/
}
