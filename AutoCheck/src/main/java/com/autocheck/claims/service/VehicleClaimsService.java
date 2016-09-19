package com.autocheck.claims.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.autocheck.claims.model.VehicleClaimsInfo;


//Webservice
@WebService
public interface VehicleClaimsService {

	
	//Web Method
	@WebMethod
	public List<VehicleClaimsInfo> getVehicleClaimHistory(String vin);
}
