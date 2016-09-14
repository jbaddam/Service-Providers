package com.bofa.ccservices.verifycard.webservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bofa.ccservices.verifycard.dao.BofACreditCardDAO;
import com.bofa.ccservices.verifycard.model.CreditCard;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Lohith Thota
 *	This class passes the data to the DAO layer.
 */

public class BofaCCWebService {
	
	@Autowired
	BofACreditCardDAO creditCardDao;
	
	
	/**
	 * This method receives the data from the 
	 * controller layer to DAO layer through the service layer
	 * @param creditCardFromCustomer
	 * @return cdb
	 */
	public boolean verifyCreditCardDetails(String creditCardFromCustomer){
		
		ObjectMapper mapper = new ObjectMapper();
		CreditCard card=null;
		try {
			card = mapper.readValue(creditCardFromCustomer, CreditCard.class);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		boolean verificationResult = creditCardDao.verifyCreditCardDetails(card);
		return verificationResult;
	}

}
