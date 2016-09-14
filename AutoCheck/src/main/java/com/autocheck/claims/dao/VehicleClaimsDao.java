package com.autocheck.claims.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.autocheck.claims.model.VehicleClaimsInfo;

public class VehicleClaimsDao {

	private static final Logger logger = LoggerFactory.getLogger(VehicleClaimsDao.class);

	@SuppressWarnings("unchecked")
	// method to get vehicle claims history
	public List<VehicleClaimsInfo> getVehicleClaimHistory(String vin) {
		// TODO Auto-generated method stub

		// Persistence class method to create Entity Manager Factory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ServiceProvider");

		// Query to get List of vehicele claims
		List<VehicleClaimsInfo> claimhistory = emfactory.createEntityManager()
				.createQuery("Select e from VehicleClaimsInfo e where e.vin='" + vin + "'").getResultList();

		if (claimhistory.isEmpty()) {

			System.out.println("Vehicle indentification Number is not available");

			return null;
		}

		else {
			return claimhistory;
		}

	}

}
