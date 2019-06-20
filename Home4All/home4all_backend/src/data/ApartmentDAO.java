/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Mafalda Nunes(Universidade do Minho)
 * License Type: Academic
 */
package data;

import business.entities.Apartment;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class ApartmentDAO {
	public static Apartment loadApartmentByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadApartmentByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment getApartmentByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return getApartmentByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment loadApartmentByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadApartmentByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment getApartmentByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return getApartmentByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment loadApartmentByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Apartment) session.load(Apartment.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment getApartmentByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Apartment) session.get(Apartment.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment loadApartmentByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Apartment) session.load(Apartment.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment getApartmentByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Apartment) session.get(Apartment.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApartment(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return queryApartment(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApartment(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return queryApartment(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment[] listApartmentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return listApartmentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment[] listApartmentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return listApartmentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApartment(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Apartment as Apartment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApartment(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Apartment as Apartment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Apartment", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment[] listApartmentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryApartment(session, condition, orderBy);
			return (Apartment[]) list.toArray(new Apartment[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment[] listApartmentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryApartment(session, condition, orderBy, lockMode);
			return (Apartment[]) list.toArray(new Apartment[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment loadApartmentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadApartmentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment loadApartmentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadApartmentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment loadApartmentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Apartment[] apartments = listApartmentByQuery(session, condition, orderBy);
		if (apartments != null && apartments.length > 0)
			return apartments[0];
		else
			return null;
	}
	
	public static Apartment loadApartmentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Apartment[] apartments = listApartmentByQuery(session, condition, orderBy, lockMode);
		if (apartments != null && apartments.length > 0)
			return apartments[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateApartmentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return iterateApartmentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApartmentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return iterateApartmentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApartmentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Apartment as Apartment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApartmentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Apartment as Apartment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Apartment", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Apartment createApartment() {
		return new Apartment();
	}
	
	public static boolean save(Apartment apartment) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().saveObject(apartment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Apartment apartment) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().deleteObject(apartment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Apartment apartment)throws PersistentException {
		try {
			if (apartment.getOwner() != null) {
				apartment.getOwner().properties.remove(apartment);
			}
			
			return delete(apartment);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Apartment apartment, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (apartment.getOwner() != null) {
				apartment.getOwner().properties.remove(apartment);
			}
			
			try {
				session.delete(apartment);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Apartment apartment) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().getSession().refresh(apartment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Apartment apartment) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().getSession().evict(apartment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
