package com.discover.ccservices.verifycard.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lohith Thota 
 * This is an entity class which provides setters and
 * getters for the credit card details
 */
@Entity
@Table
public class CreditCard {

	
	@Id
	private int creditCard;
	private String nameOnCard;
	private Date expirationDate;
	private int cvv;
	@OneToOne
	private BillingAddress billingAddress;

	@Override
	public String toString() {
		return "CreditCard [nameOnCard=" + nameOnCard + ", creditCard=" + creditCard + ", expirationDate="
				+ expirationDate + ", cvv=" + cvv + ", billingAddress=" + billingAddress + "]";
	}

	
	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

}
