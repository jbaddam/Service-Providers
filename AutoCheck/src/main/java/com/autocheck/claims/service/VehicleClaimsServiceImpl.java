package com.autocheck.claims.service;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;
import com.autocheck.claims.dao.VehicleClaimsDao;
import com.autocheck.claims.model.VehicleClaimsInfo;

//Webservice annotation for declaring end point interface.
@WebService(endpointInterface = "com.autocheck.claims.service.VehicleClaimsService", serviceName = "ServiceProvider")
public class VehicleClaimsServiceImpl implements VehicleClaimsService {

	
	
	//@WebMethod
	public List<VehicleClaimsInfo> getVehicleClaimHistory(String vin) {
		// TODO Auto-generated method stub
		
		VehicleClaimsDao vehicleclaimsdao = new VehicleClaimsDao();
		@SuppressWarnings("unchecked")
		
		List<VehicleClaimsInfo> claimdetails=  (List<VehicleClaimsInfo>) vehicleclaimsdao.getVehicleClaimHistory(vin);
		
		
		
		return claimdetails;
	}
	
	
}
