package com.dmv.publicrecords.dao.vehicleinfo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dmv.publicrecords.model.Address;
import com.dmv.publicrecords.model.Vehicle;

/**
 * @author Jagan Reddy This class has Functionality to get the List of Vehicles
 *         based on the given address from Database
 */
public class VehicleDAO {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @param address
	 * @return This method accepts Address object as input fetches and returns
	 *         the List of Vehicles register to that address from database
	 */
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Vehicle> getAllVehicles(Address address) {

		SQLQuery query = null;
		int addrId = 0;

		if (address != null) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// if addressLine2 came as NULL
			if ("".equals(address.getAddressLine2())) {
				query = session.createSQLQuery("select a_id from dmv.vehicle_address where (line1 = '"
						+ address.getAddressLine1() + "' && line2 is null && city='" + address.getCity()
						+ "' && state='" + address.getState() + "' && zip='" + address.getZip() + "')");
			} else {
				query = session.createSQLQuery("select a_id from dmv.vehicle_address where (line1 = '"
						+ address.getAddressLine1().trim() + "' && line2='" + address.getAddressLine2().trim()
						+ "' && city='" + address.getCity().trim() + "' && state='" + address.getState().trim()
						+ "' && zip='" + address.getZip() + "')");
			}

			try {
				addrId = (int) query.list().get(0);
			} catch (java.lang.IndexOutOfBoundsException e) {
				System.out.println("Address Not Matched With Our Records");
				return null;
			} finally {
				if (addrId != 0) {
					Criteria criteria = session.createCriteria(Vehicle.class, "vehicle");
					criteria.createAlias("vehicle.vechicleAddress", "vAddr");
					criteria.add(Restrictions.eq("vAddr.addressId", addrId));
					List<Vehicle> vehicleList = criteria.list();
					session.getTransaction().commit();
					return vehicleList;
				} else
					return null;
			}

		} else
			return null;
	}

}
