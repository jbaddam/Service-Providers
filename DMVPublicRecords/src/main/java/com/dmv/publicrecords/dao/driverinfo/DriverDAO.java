package com.dmv.publicrecords.dao.driverinfo;

import javax.persistence.Persistence;

import com.dmv.publicrecords.model.Driver;

/**
 * @author Jagan Reddy
 * This Class has a functionality get the Driver information from Database
 */
public class DriverDAO {

	/**
	 * @param licenseNumber
	 * @return
	 * This method accepts String of license number as input
	 * fetches and returns the List of history of driver from database
	 */
	public Driver getDriversInfo(String licenseNumber) {
		return (Driver) Persistence.createEntityManagerFactory("ServiceProvider").createEntityManager().find(Driver.class,licenseNumber);
	}
}
