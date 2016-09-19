package com.discover.ccservices.verifycard.webservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.discover.ccservices.verifycard.dao.DiscoverCreditCardDAO;
import com.discover.ccservices.verifycard.model.CreditCard;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Lohith Thota 
 * This class passes the data to the DAO layer.
 */

public class DiscoverCCWebService {

	@Autowired
	DiscoverCreditCardDAO creditCardDao;

	/**
	 * This method receives the data from the controller layer to DAO layer
	 * through the service layer
	 * 
	 * @param creditCardFromCustomer, quoteAmount
	 * @return boolean response
	 */
	public boolean processPayment(String creditCardFromCustomer, double quoteAmount) {

		ObjectMapper mapper = new ObjectMapper();
		CreditCard card = null;
		
		try {
			
			card = mapper.readValue(creditCardFromCustomer, CreditCard.class);
		
		} catch (Exception e) {
			
			e.printStackTrace();
			//System.out.println("invalid Creditcard Details");
			return false;

		}

		return creditCardDao.processPayment(card, quoteAmount);
	}

}
