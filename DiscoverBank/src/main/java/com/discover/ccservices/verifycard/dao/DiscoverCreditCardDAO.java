package com.discover.ccservices.verifycard.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.discover.ccservices.verifycard.model.CreditCard;

/**
 * @author Lohith Thota This class provides methods like getInfo that creates
 *         the connection to Database and retrieves the data through the query
 *         written in prepared statement
 */
public class DiscoverCreditCardDAO {

	/**
	 * This method creates the connection to Database and retrieves the data
	 * through the query written in prepared statement
	 */

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public boolean verifyCreditCardDetails(CreditCard creditCardFromCustomer, double quoteAmount) {

		Session session = sessionFactory.openSession();

		// session.beginTransaction();

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
		
		if (list.isEmpty()) {
			System.out.println("Matching Records Not available for this Credit Card");
			return false;
		}

		else {

			int creditCardBalance = (int) list.get(0);

			if (creditCardBalance >= quoteAmount)
				return true;

			else
				return false;

		}

	}

}
