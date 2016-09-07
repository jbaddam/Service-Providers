package com.dmv.publicrecords.controller.vehicleinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.publicrecords.model.Vehicle;
import com.dmv.publicrecords.service.vehicleinfo.VehicleInfoService;

@RestController
public class VehicleController {
	@Autowired
	VehicleInfoService vehicleSrv;

	@RequestMapping(value = "/getallvehicles/{address}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Vehicle> getAllVehicles(@PathVariable String address) {

		return vehicleSrv.getAllVehicles(address);
	}

}
