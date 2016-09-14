package com.discover.ccservices.verifycard.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discover.ccservices.verifycard.webservice.DiscoverCCWebService;



/**
 * Servlet implementation class CitiBankRegistration
 */
@RestController
@RequestMapping("creditcard")
public class CreditCardController {
	
	 @Autowired
	 DiscoverCCWebService ccServices;
	 
	 boolean result;

	/* Accept credit card info in the form of a JSON string and give the response in boolean format. */
	@RequestMapping(value = "/verify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public boolean verifyCreditCardDetails(@RequestBody String cerditCardfromUser) {
		
		try {
			result = ccServices.verifyCreditCardDetails(cerditCardfromUser);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
	
	
	/*
	 * private static final long serialVersionUID = 1L; String reference;
	 * 
	 *//**
		 * @see HttpServlet#doGet(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * CreditCard creditCardUserInput = new CreditCard(); BillingAddress
	 * billingAddressUserInput = new BillingAddress();
	 * 
	 * 
	 * we are getting parameters from HttpServletRequest and we are setting them
	 * to the Customer class object c using setters
	 * 
	 * creditCardUserInput.setCreditCard(request.getParameter("txtCardNumber"));
	 * creditCardUserInput.setNameOnCard(request.getParameter("txtNameOnCard"));
	 * creditCardUserInput.setCvv(request.getParameter("txtcvv"));
	 * creditCardUserInput.setExpirationDate(request.getParameter("expdate"));
	 * 
	 * billingAddressUserInput.setLine1(request.getParameter("txtline1"));
	 * billingAddressUserInput.setLine2(request.getParameter("txtline2"));
	 * billingAddressUserInput.setCity(request.getParameter("txtcity"));
	 * billingAddressUserInput.setState(request.getParameter("txtstate"));
	 * billingAddressUserInput.setZip(request.getParameter("txtzip"));
	 * 
	 * creditCardUserInput.setBillingAddress(billingAddressUserInput);
	 * 
	 * System.out.println(creditCardUserInput.toString());
	 * System.out.println(billingAddressUserInput.toString());
	 * 
	 * 
	 * Assigning the return value from getInfo method of
	 * ActivationProcessCitibank class
	 * 
	 * boolean responseFromDatabase =
	 * BofaCCWebService.verifyCreditCardDetails(creditCardUserInput);
	 * 
	 * PrintWriter out = response.getWriter();
	 * 
	 * 
	 * These statements print the response from the DAO layer
	 * 
	 * try {
	 * 
	 * if (responseFromDatabase == true) {
	 * 
	 * out.println("Transaction Processed..!!");
	 * 
	 * } else {
	 * 
	 * out.println("Wrong details entered..!! Transaction can't be processed");
	 * } } catch (Exception NullPointerException) {
	 * System.out.println("Card Activation Unsuccessful");
	 * 
	 * }
	 * 
	 * }
	 * 
	 *//**
		 * @see HttpServlet#doPost(HttpServletRequest request,
		 *      HttpServletResponse response)
		 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException {
		 * 
		 * doGet(request, response); c.setCreditCard(getServletInfo()); }
		 */

}
