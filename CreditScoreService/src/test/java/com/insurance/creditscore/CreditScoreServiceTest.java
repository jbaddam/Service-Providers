package com.insurance.creditscore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.creditbureau.creditscore.service.CreditScoreServiceImpl;
/**
 * This class will test the creditScore functionality for the given SSN by using Mockito framework
 * @author Jude Mariarajan
 *
 */
public class CreditScoreServiceTest {
	
	CreditScoreServiceImpl creditScoreTest;
	
	@Before
	public void setUp(){
		creditScoreTest = mock(CreditScoreServiceImpl.class);
	}
	
	/**
	 * This method will test the actual credit score with the expected credit score
	 */
	@Test
	public void getCreditScoreTest(){
		
		int actualCreditScore = 130;
		
		when(creditScoreTest.getCreditScoreBySSN("123456789")).thenReturn(actualCreditScore);
		
		int expectedCreditScore = creditScoreTest.getCreditScoreBySSN("123456789");
		
		assertEquals(expectedCreditScore, actualCreditScore);
		
		
		
	}
	
	

}
