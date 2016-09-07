package com.dmv.publicrecords.controller.driverinfo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.publicrecords.model.Driver;
import com.dmv.publicrecords.service.driverinfo.DriversInfoService;

@RestController
public class DriverController {

	@Autowired
	DriversInfoService driverSrv;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/getdriver/{license_numbers}")
	public List<Driver> getDriverInfo(@PathVariable String license_numbers) {

		return driverSrv.getDriversInfo(license_numbers);
	}

}
