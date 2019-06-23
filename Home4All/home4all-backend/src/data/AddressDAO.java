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

import business.entities.Address;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class AddressDAO {
	public static Address loadAddressByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadAddressByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address getAddressByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getAddressByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadAddressByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address getAddressByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getAddressByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Address) session.load(Address.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address getAddressByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Address) session.get(Address.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Address) session.load(Address.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address getAddressByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Address) session.get(Address.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAddress(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryAddress(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAddress(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryAddress(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address[] listAddressByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listAddressByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address[] listAddressByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listAddressByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAddress(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Address as Address");
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
	
	public static List queryAddress(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Address as Address");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Address", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address[] listAddressByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAddress(session, condition, orderBy);
			return (Address[]) list.toArray(new Address[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address[] listAddressByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAddress(session, condition, orderBy, lockMode);
			return (Address[]) list.toArray(new Address[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadAddressByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadAddressByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Address[] addresses = listAddressByQuery(session, condition, orderBy);
		if (addresses != null && addresses.length > 0)
			return addresses[0];
		else
			return null;
	}
	
	public static Address loadAddressByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Address[] addresses = listAddressByQuery(session, condition, orderBy, lockMode);
		if (addresses != null && addresses.length > 0)
			return addresses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAddressByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateAddressByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAddressByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateAddressByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAddressByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Address as Address");
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
	
	public static java.util.Iterator iterateAddressByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Address as Address");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Address", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address createAddress() {
		return new Address();
	}
	
	public static boolean save(Address address) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().saveObject(address);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Address address) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().deleteObject(address);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Address address) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().refresh(address);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Address address) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().evict(address);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Address loadAddressByCriteria(AddressCriteria addressCriteria) {
		Address[] addresses = listAddressByCriteria(addressCriteria);
		if(addresses == null || addresses.length == 0) {
			return null;
		}
		return addresses[0];
	}
	
	public static Address[] listAddressByCriteria(AddressCriteria addressCriteria) {
		return addressCriteria.listAddress();
	}
}
