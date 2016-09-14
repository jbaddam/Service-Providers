package com.dmv.publicrecords.service.driverinfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.dao.driverinfo.DriverDAO;
import com.dmv.publicrecords.model.Driver;

/**
 * @author Jagan Reddy
 * This class has Functionality to get the Driver history 
 * based on the given license numbers
 */
public class DriversInfoService {
	
	@Autowired
	DriverDAO driverDao;

	/**
	 * @param licenseNumbers
	 * @return
	 * This method accepts String of license number as input
	 * and returns the List of history of drivers
	 */
	 public List<Driver> getDriversInfo(String licenseNumbers) {

		if (licenseNumbers != null) {
			
			//splitting the license numbers using delimiter :
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
