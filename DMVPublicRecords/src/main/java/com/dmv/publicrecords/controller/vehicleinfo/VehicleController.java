package com.dmv.publicrecords.controller.vehicleinfo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.publicrecords.model.Vehicle;
import com.dmv.publicrecords.service.vehicleinfo.VehicleInfoService;

@RestController
public class VehicleController {
	@Autowired
	VehicleInfoService vehicleSrv;

	@RequestMapping(value = "/getvehicleslist/{address}")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> getVehiclesList(@PathVariable String address) {

		return vehicleSrv.getVehiclesList(address);
	}

}
