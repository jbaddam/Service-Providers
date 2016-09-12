package com.dmv.publicrecords.service.vehicleinfo;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.dao.vehicleinfo.VehicleDAO;
import com.dmv.publicrecords.model.Address;
import com.dmv.publicrecords.model.Vehicle;

public class VehicleInfoService {

	@Autowired
	VehicleDAO vehicleDao;


	public List<Vehicle> getVehiclesList(String address) {

		ObjectMapper mapper = new ObjectMapper();
		Address vehiclAddress=null;
		try {
			vehiclAddress = mapper.readValue(address, Address.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return vehicleDao.getAllVehicles(vehiclAddress);
	}
	
	
}
