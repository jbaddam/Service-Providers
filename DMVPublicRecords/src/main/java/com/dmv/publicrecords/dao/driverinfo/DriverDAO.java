package com.dmv.publicrecords.dao.driverinfo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.model.Driver;

public class DriverDAO {

	@Autowired
	SessionFactory mySessionFactory;

	public Driver getDriverInfo(String licenseNumber) {
		return (Driver) mySessionFactory.openSession().get(Driver.class, licenseNumber);
	}
}
