package com.discover.ccservices.verifycard.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.discover.ccservices.verifycard.model.CreditCard;

/**
 * @author Lohith Thota 
 * This class provides methods like processPayment that creates
 * the connection to Database and retrieves the data through the HQL query
 */
public class DiscoverCreditCardDAO {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * This method creates a session, executes the query, returns a boolean response 
	 * which indicates whether the transaction has been processed or not.
	 */
	@SuppressWarnings("unchecked")
	public boolean processPayment(CreditCard creditCardFromCustomer, double quoteAmount) {

		Session session = sessionFactory.openSession();

		/*
		 * The query takes in credit card details, billing address to verify the card.
		 * If the is card is a valid one, then the available balance in the card is returned.
		 */
		SQLQuery query = session.createSQLQuery("select balance from credit_card "
				+ "join billing_address on billing_address.ba_id=credit_card.ba_id " + "where credit_card ='"
				+ creditCardFromCustomer.getCreditCard() + "'" + " and name_on_card ='"
				+ creditCardFromCustomer.getNameOnCard() + "'" + " and cvv = '" + creditCardFromCustomer.getCvv() + "'"
				+ "and line1 = '" + creditCardFromCustomer.getBillingAddress().getLine1() + "'" + " and line2 = '"
				+ creditCardFromCustomer.getBillingAddress().getLine2() + "'" + "and city = '"
				+ creditCardFromCustomer.getBillingAddress().getCity() + "'" + " and state = '"
				+ creditCardFromCustomer.getBillingAddress().getState() + "'" + " and zip = '"
				+ creditCardFromCustomer.getBillingAddress().getZip() + "'");

		List<Integer> list = query.list();
		
		/*
		 * Checking if any data has been retrieved at all
		 */
		if (list.isEmpty()) {
			//System.out.println("Matching Records Not available for this Credit Card");
			return false;
		}

		else {

			/*
			 * If enough balance is present, true is sent back. Otherwise false is sent back.
			 */
			int creditCardBalance = (int) list.get(0);

			if (creditCardBalance >= quoteAmount)
				return true;

			else
				return false;

		}

	}

}
