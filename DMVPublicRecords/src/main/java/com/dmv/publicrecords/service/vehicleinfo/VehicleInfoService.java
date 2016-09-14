package com.dmv.publicrecords.service.vehicleinfo;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.dao.vehicleinfo.VehicleDAO;
import com.dmv.publicrecords.model.Address;
import com.dmv.publicrecords.model.Vehicle;

/**
 * @author Jagan Reddy 
 * This class has Functionality to get the List of Vehicles
 * based on the given address
 */
public class VehicleInfoService {

	@Autowired
	VehicleDAO vehicleDao;

	/**
	 * @param address
	 * @return 
	 * This method accepts JSON String of Address as input map to the
	 * Java object and returns the List of Vehicles register to that address
	 */
	public List<Vehicle> getVehiclesList(String address) {

		ObjectMapper mapper = new ObjectMapper();
		Address vehiclAddress = null;

		try {
			vehiclAddress = mapper.readValue(address, Address.class);
		} catch (Exception e) {
			System.out.println("Address is not in Correct Format");
			return null;
		}

		return vehicleDao.getAllVehicles(vehiclAddress);
	}
}
