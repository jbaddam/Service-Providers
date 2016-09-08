package com.dmv.publicrecords.dao.driverinfo;

import javax.persistence.Persistence;

import com.dmv.publicrecords.model.Driver;

public class DriverDAO {

	public Driver getDriversInfo(String licenseNumber) {
		return (Driver) Persistence.createEntityManagerFactory("ServiceProvider").createEntityManager().find(Driver.class,licenseNumber);
	}
}
