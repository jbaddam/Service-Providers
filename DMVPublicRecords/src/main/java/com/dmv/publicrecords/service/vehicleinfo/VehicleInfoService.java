package com.dmv.publicrecords.service.vehicleinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.dao.vehicleinfo.VehicleDAO;
import com.dmv.publicrecords.model.Address;
import com.dmv.publicrecords.model.Vehicle;

public class VehicleInfoService {

	@Autowired
	VehicleDAO vehicleDao;

	public List<Vehicle> getAllVehicles(String address) {

		String[] addressArray = address.split(":");
		Address vehiclAddress = new Address();
		vehiclAddress.setAddressLine1(addressArray[0].trim());
		vehiclAddress.setAddressLine2(addressArray[1].trim());
		vehiclAddress.setCity(addressArray[2].trim());
		vehiclAddress.setState(addressArray[3].trim());
		vehiclAddress.setZip(addressArray[4].trim());

		return vehicleDao.getAllVehicles(vehiclAddress);
	}
}
