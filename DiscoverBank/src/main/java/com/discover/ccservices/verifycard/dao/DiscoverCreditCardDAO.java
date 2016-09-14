package com.discover.ccservices.verifycard.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.discover.ccservices.verifycard.model.CreditCard;




/**
 * @author Lohith Thota
 * This class provides methods like getInfo that creates the connection to Database
 * and retrieves the data through the query written in prepared statement
 */
public class DiscoverCreditCardDAO {

	
	/**
	 * This method creates the connection to Database
	 * and retrieves the data through the query written in prepared statement
	 */
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean verifyCreditCardDetails(CreditCard creditCardFromCustomer) {
		try {

			Session session = sessionFactory.openSession();
			
			//session.beginTransaction();
		    
			Query query=  session.createQuery("from credit_card "
					+ "join billing_address on billing_address.ba_id=credit_card.ba_id "
					+ "where credit_card = ? && name_on_card =? && cvv = ? "
					+ "&& line1 = ? && line2 = ? && city = ? && state = ? && zip = ?");

			query.setParameter(0,creditCardFromCustomer.getCreditCard());
			query.setParameter(1,creditCardFromCustomer.getNameOnCard());
			query.setParameter(2,creditCardFromCustomer.getCvv());
			query.setParameter(3,creditCardFromCustomer.getBillingAddress().getLine1());
			query.setParameter(4,creditCardFromCustomer.getBillingAddress().getLine2());
			query.setParameter(5,creditCardFromCustomer.getBillingAddress().getCity());
			query.setParameter(6,creditCardFromCustomer.getBillingAddress().getState());
			query.setParameter(7,creditCardFromCustomer.getBillingAddress().getZip());
			
			CreditCard creditCardFromDB = (CreditCard) query.uniqueResult();
			
		    session.getTransaction().commit();
		    session.close();
		    
		    if (creditCardFromDB.getCreditCard() != 0){
		    	return true;
		    }
		    
		    } catch (Exception ee) {
			System.out.println(ee);
		}
		
		return false;
		
	}
	
	
	/*public boolean processPayment(int quoteAmount) {
		try {

			Session session = HIbernateUtil.getSession();
			
			//session.beginTransaction();
		    
			Query query=  session.createQuery("from credit_card "
					+ "join billing_address on billing_address.ba_id=credit_card.ba_id "
					+ "where credit_card = ? && name_on_card =? && cvv = ? "
					+ "&& line1 = ? && line2 = ? && city = ? && state = ? && zip = ?");

			query.setParameter(0,quoteAmount.getCreditCard());
			query.setParameter(1,quoteAmount.getNameOnCard());
			query.setParameter(2,quoteAmount.getCvv());
			query.setParameter(3,quoteAmount.getBillingAddress().getLine1());
			query.setParameter(4,quoteAmount.getBillingAddress().getLine2());
			query.setParameter(5,quoteAmount.getBillingAddress().getCity());
			query.setParameter(6,quoteAmount.getBillingAddress().getState());
			query.setParameter(7,quoteAmount.getBillingAddress().getZip());
			
			CreditCard creditCardFromDB = (CreditCard) query.uniqueResult();
			
		    session.getTransaction().commit();
		    session.close();
		    
		    if (creditCardFromDB.getCreditCard() != null){
		    	return true;
		    }
		    
		    } catch (Exception ee) {
			System.out.println(ee);
		}
		
		return false;
		
	}*/
}
