package com.dmv.publicrecords.service.driverinfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.dao.driverinfo.DriverDAO;
import com.dmv.publicrecords.model.Driver;

public class DriversInfoService {
	@Autowired
	DriverDAO driverDao;

	public List<Driver> getDriversInfo(String licenseNumbers) {

		if (licenseNumbers != null) {
			String[] licenseNumberArray = licenseNumbers.split(":");
			List<Driver> listOfDrivers = new ArrayList<Driver>();
			for (String licenceNumber : licenseNumberArray) {
				listOfDrivers.add(driverDao.getDriversInfo(licenceNumber.trim()));
			}
			return listOfDrivers;
		} else
			return null;
	}
}
