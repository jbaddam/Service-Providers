package com.dmv.publicrecords.controller.vehicleinfo;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.publicrecords.model.Vehicle;
import com.dmv.publicrecords.service.vehicleinfo.VehicleInfoService;

/**
 * @author Jagan Reddy
 * This class has Functionality to get the List of Vehicles 
 * based on the given address
 */
@RestController
public class VehicleController {
	
	@Autowired
	VehicleInfoService vehicleSrv;
	
	/**
	 * @param address
	 * @return
	 * This method accepts JSON String of Address as input
	 * and returns the List of Vehicles register to that address 
	 */
	@RequestMapping(value = "/getvehicleslist")
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Vehicle>> getVehiclesList(@RequestBody String address) {

		return  new ResponseEntity<List<Vehicle>>(vehicleSrv.getVehiclesList(address), HttpStatus.OK);
	}
	
}
