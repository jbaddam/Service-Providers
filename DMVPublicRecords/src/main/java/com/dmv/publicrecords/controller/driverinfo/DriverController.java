package com.dmv.publicrecords.controller.driverinfo;

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

import com.dmv.publicrecords.model.Driver;
import com.dmv.publicrecords.service.driverinfo.DriversInfoService;

/**
 * @author Jagan Reddy
 * This class has Functionality to get the Driver history 
 * based on the given license numbers
 */
@RestController
public class DriverController {

	@Autowired
	DriversInfoService driverSrv;

	/**
	 * @param licenseNumbers
	 * @return
	 * This method accepts String of license number as input
	 * and returns the List of history of drivers 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/getdriverhistory")
	public ResponseEntity<List<Driver>> getDriverInfo(@RequestBody String licenseNumbers) {
		
			return new ResponseEntity<List<Driver>>(driverSrv.getDriversInfo(licenseNumbers), HttpStatus.OK);
	}

}
