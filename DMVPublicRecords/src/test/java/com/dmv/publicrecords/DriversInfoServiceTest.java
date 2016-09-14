package com.dmv.publicrecords;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.dmv.publicrecords.model.Driver;
import com.dmv.publicrecords.service.driverinfo.DriversInfoService;


public class DriversInfoServiceTest {

	private  DriversInfoService driverSrv = Mockito.mock(DriversInfoService.class);
	
	@Test
	public void testgetDriversInfo(){
		
		List<Driver> driverList = new ArrayList<Driver>();
		Driver driver = new Driver();
		driver.setName("jagan reddy");
		driver.setLicenceNumber("1234");
		driver.setDob(new Date(2016,9,9));		
		driver.setExpiryDate(new Date(2016,9,9));
		driver.setIssuingState("CA");
		driver.setPoints(1);
		driver.setTickets(1);		
		driverList.add(driver);		
		
		
		when(driverSrv.getDriversInfo("1234")).thenReturn(driverList);
		
		List<Driver> mockDriverList  = driverSrv.getDriversInfo("1234");
		for(Driver driverEntity : mockDriverList){
			assertEquals(driverEntity.getLicenceNumber(), driver.getLicenceNumber());
			assertEquals(driverEntity.getName(), driver.getName());
			assertEquals(driverEntity.getDob(), driver.getDob());
			assertEquals(driverEntity.getIssuingState(), driver.getIssuingState());
			assertEquals(driverEntity.getExpiryDate(), driver.getExpiryDate());
			assertEquals(driverEntity.getTickets(), driver.getTickets());
			assertEquals(driverEntity.getPoints(), driver.getPoints());			
		}
	
	}
	
	
}

