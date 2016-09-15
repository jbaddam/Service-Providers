package com.discover.ccservices.verifycard.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lohith Thota 
 * This is an entity class which provides setters and
 * getters for the credit card details
 */
@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@Column(name = "credit_card")
	private int creditCard;

	@Column(name = "name_on_card")
	private String nameOnCard;

	@Column(name = "exp_date")
	private Date expirationDate;
	
	@Column(name = "cvv")
	private int cvv;
	
	@Column(name = "balance")
	private int balance;

	@OneToOne
	@JoinColumn(name = "ba_id")
	private BillingAddress billingAddress;

	@Override
	public String toString() {
		return "CreditCard [nameOnCard=" + nameOnCard + ", creditCard=" + creditCard + ", expirationDate="
				+ expirationDate + ", cvv=" + cvv + ", billingAddress=" + billingAddress + "]";
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
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
