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

import business.entities.Shared;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class SharedDAO {
	public static Shared loadSharedByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadSharedByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared getSharedByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getSharedByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadSharedByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared getSharedByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getSharedByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Shared) session.load(Shared.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared getSharedByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Shared) session.get(Shared.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Shared) session.load(Shared.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared getSharedByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Shared) session.get(Shared.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryShared(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryShared(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryShared(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryShared(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared[] listSharedByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listSharedByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared[] listSharedByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listSharedByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryShared(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Shared as Shared");
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
	
	public static List queryShared(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Shared as Shared");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Shared", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared[] listSharedByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryShared(session, condition, orderBy);
			return (Shared[]) list.toArray(new Shared[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared[] listSharedByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryShared(session, condition, orderBy, lockMode);
			return (Shared[]) list.toArray(new Shared[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadSharedByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadSharedByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Shared[] shareds = listSharedByQuery(session, condition, orderBy);
		if (shareds != null && shareds.length > 0)
			return shareds[0];
		else
			return null;
	}
	
	public static Shared loadSharedByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Shared[] shareds = listSharedByQuery(session, condition, orderBy, lockMode);
		if (shareds != null && shareds.length > 0)
			return shareds[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSharedByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateSharedByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSharedByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateSharedByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSharedByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Shared as Shared");
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
	
	public static java.util.Iterator iterateSharedByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Shared as Shared");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Shared", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared createShared() {
		return new Shared();
	}
	
	public static boolean save(Shared shared) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().saveObject(shared);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Shared shared) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().deleteObject(shared);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Shared shared)throws PersistentException {
		try {
			if (shared.getOwner() != null) {
				shared.getOwner().properties.remove(shared);
			}
			
			return delete(shared);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Shared shared, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (shared.getOwner() != null) {
				shared.getOwner().properties.remove(shared);
			}
			
			try {
				session.delete(shared);
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
	
	public static boolean refresh(Shared shared) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().refresh(shared);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Shared shared) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().evict(shared);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Shared loadSharedByCriteria(SharedCriteria sharedCriteria) {
		Shared[] shareds = listSharedByCriteria(sharedCriteria);
		if(shareds == null || shareds.length == 0) {
			return null;
		}
		return shareds[0];
	}
	
	public static Shared[] listSharedByCriteria(SharedCriteria sharedCriteria) {
		return sharedCriteria.listShared();
	}
}
