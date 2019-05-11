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

public class BedroomTypeDAO {
	public static BedroomType loadBedroomTypeByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomTypeByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType getBedroomTypeByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getBedroomTypeByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomTypeByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType getBedroomTypeByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getBedroomTypeByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (BedroomType) session.load(PSM.BedroomType.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType getBedroomTypeByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (BedroomType) session.get(PSM.BedroomType.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (BedroomType) session.load(PSM.BedroomType.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType getBedroomTypeByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (BedroomType) session.get(PSM.BedroomType.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBedroomType(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryBedroomType(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBedroomType(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryBedroomType(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType[] listBedroomTypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listBedroomTypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType[] listBedroomTypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listBedroomTypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBedroomType(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.BedroomType as BedroomType");
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
	
	public static List queryBedroomType(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.BedroomType as BedroomType");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("BedroomType", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType[] listBedroomTypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBedroomType(session, condition, orderBy);
			return (BedroomType[]) list.toArray(new BedroomType[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType[] listBedroomTypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBedroomType(session, condition, orderBy, lockMode);
			return (BedroomType[]) list.toArray(new BedroomType[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomTypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadBedroomTypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		BedroomType[] bedroomTypes = listBedroomTypeByQuery(session, condition, orderBy);
		if (bedroomTypes != null && bedroomTypes.length > 0)
			return bedroomTypes[0];
		else
			return null;
	}
	
	public static BedroomType loadBedroomTypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		BedroomType[] bedroomTypes = listBedroomTypeByQuery(session, condition, orderBy, lockMode);
		if (bedroomTypes != null && bedroomTypes.length > 0)
			return bedroomTypes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBedroomTypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateBedroomTypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBedroomTypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateBedroomTypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBedroomTypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.BedroomType as BedroomType");
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
	
	public static java.util.Iterator iterateBedroomTypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.BedroomType as BedroomType");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("BedroomType", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType createBedroomType() {
		return new PSM.BedroomType();
	}
	
	public static boolean save(PSM.BedroomType bedroomType) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().saveObject(bedroomType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(PSM.BedroomType bedroomType) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().deleteObject(bedroomType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(PSM.BedroomType bedroomType) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().refresh(bedroomType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(PSM.BedroomType bedroomType) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().evict(bedroomType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BedroomType loadBedroomTypeByCriteria(BedroomTypeCriteria bedroomTypeCriteria) {
		BedroomType[] bedroomTypes = listBedroomTypeByCriteria(bedroomTypeCriteria);
		if(bedroomTypes == null || bedroomTypes.length == 0) {
			return null;
		}
		return bedroomTypes[0];
	}
	
	public static BedroomType[] listBedroomTypeByCriteria(BedroomTypeCriteria bedroomTypeCriteria) {
		return bedroomTypeCriteria.listBedroomType();
	}
}
