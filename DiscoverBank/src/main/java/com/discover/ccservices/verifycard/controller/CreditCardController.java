package com.discover.ccservices.verifycard.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discover.ccservices.verifycard.webservice.DiscoverCCWebService;

/**
 * Servlet implementation class CitiBankRegistration
 */
@RestController
public class CreditCardController {

	@Autowired
	DiscoverCCWebService ccServices;

	boolean result;

	/*
	 * Accept credit card info in the form of a JSON string and give the
	 * response in boolean format.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/verify/{quoteAmount}")
	public boolean verifyCreditCardDetails(@RequestBody String cerditCardfromUser, @PathVariable("quoteAmount") final double quoteAmount) {

		if (cerditCardfromUser != null) {

			return ccServices.verifyCreditCardDetails(cerditCardfromUser, quoteAmount);
		} else
			return false;

	}
}
