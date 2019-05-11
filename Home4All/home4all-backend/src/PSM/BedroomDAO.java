/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: afonscosta(Universidade do Minho)
 * License Type: Academic
 */
package PSM;

import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class BedroomDAO {
	public static Bedroom loadBedroomByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom getBedroomByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getBedroomByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom getBedroomByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getBedroomByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Bedroom) session.load(PSM.Bedroom.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom getBedroomByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Bedroom) session.get(PSM.Bedroom.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Bedroom) session.load(PSM.Bedroom.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom getBedroomByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Bedroom) session.get(PSM.Bedroom.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBedroom(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryBedroom(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBedroom(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryBedroom(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom[] listBedroomByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listBedroomByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom[] listBedroomByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listBedroomByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBedroom(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Bedroom as Bedroom");
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
	
	public static List queryBedroom(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Bedroom as Bedroom");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Bedroom", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom[] listBedroomByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBedroom(session, condition, orderBy);
			return (Bedroom[]) list.toArray(new Bedroom[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom[] listBedroomByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBedroom(session, condition, orderBy, lockMode);
			return (Bedroom[]) list.toArray(new Bedroom[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Bedroom[] bedrooms = listBedroomByQuery(session, condition, orderBy);
		if (bedrooms != null && bedrooms.length > 0)
			return bedrooms[0];
		else
			return null;
	}
	
	public static Bedroom loadBedroomByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Bedroom[] bedrooms = listBedroomByQuery(session, condition, orderBy, lockMode);
		if (bedrooms != null && bedrooms.length > 0)
			return bedrooms[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBedroomByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateBedroomByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBedroomByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateBedroomByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBedroomByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Bedroom as Bedroom");
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
	
	public static java.util.Iterator iterateBedroomByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Bedroom as Bedroom");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Bedroom", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom createBedroom() {
		return new PSM.Bedroom();
	}
	
	public static boolean save(PSM.Bedroom bedroom) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().saveObject(bedroom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(PSM.Bedroom bedroom) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().deleteObject(bedroom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(PSM.Bedroom bedroom) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().refresh(bedroom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(PSM.Bedroom bedroom) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().evict(bedroom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Bedroom loadBedroomByCriteria(BedroomCriteria bedroomCriteria) {
		Bedroom[] bedrooms = listBedroomByCriteria(bedroomCriteria);
		if(bedrooms == null || bedrooms.length == 0) {
			return null;
		}
		return bedrooms[0];
	}
	
	public static Bedroom[] listBedroomByCriteria(BedroomCriteria bedroomCriteria) {
		return bedroomCriteria.listBedroom();
	}
}
