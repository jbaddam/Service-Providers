package com.dmv.publicrecords.dao.vehicleinfo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.model.Address;
import com.dmv.publicrecords.model.Vehicle;

public class VehicleDAO {

	@Autowired
	SessionFactory mySessionFactory;

	public List<Vehicle> getAllVehicles(Address address) {
		if (address != null) {
			Session session = mySessionFactory.openSession();
			SQLQuery sQuery = session.createSQLQuery("select a_id from dmv.vehicle_address where (line1 = '"
					+ address.getAddressLine1() + "' && line2='" + address.getAddressLine2() + "' && city='"
					+ address.getCity() + "' && state='" + address.getState() + "' && zip='" + address.getZip() + "')");

			List<Integer> addrIdList = sQuery.list();
			int addrId = addrIdList.get(0);
			if (addrId != 0) {
				Criteria criteria = session.createCriteria(Vehicle.class, "vehicle");
				criteria.createAlias("vehicle.vechicleAddress", "vAddr");
				criteria.add(Restrictions.eq("vAddr.addressId", Integer.toString(addrId)));
				return criteria.list();
			} else
				return null;
		} else
			return null;
	}
}
