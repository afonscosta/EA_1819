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

import business.entities.MultipleRoom;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class MultipleRoomDAO {
	public static MultipleRoom loadMultipleRoomByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadMultipleRoomByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom getMultipleRoomByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getMultipleRoomByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadMultipleRoomByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom getMultipleRoomByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getMultipleRoomByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (MultipleRoom) session.load(MultipleRoom.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom getMultipleRoomByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (MultipleRoom) session.get(MultipleRoom.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (MultipleRoom) session.load(MultipleRoom.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom getMultipleRoomByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (MultipleRoom) session.get(MultipleRoom.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMultipleRoom(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryMultipleRoom(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMultipleRoom(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryMultipleRoom(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom[] listMultipleRoomByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listMultipleRoomByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom[] listMultipleRoomByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listMultipleRoomByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMultipleRoom(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.MultipleRoom as MultipleRoom");
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
	
	public static List queryMultipleRoom(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.MultipleRoom as MultipleRoom");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("MultipleRoom", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom[] listMultipleRoomByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMultipleRoom(session, condition, orderBy);
			return (MultipleRoom[]) list.toArray(new MultipleRoom[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom[] listMultipleRoomByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMultipleRoom(session, condition, orderBy, lockMode);
			return (MultipleRoom[]) list.toArray(new MultipleRoom[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadMultipleRoomByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadMultipleRoomByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		MultipleRoom[] multipleRooms = listMultipleRoomByQuery(session, condition, orderBy);
		if (multipleRooms != null && multipleRooms.length > 0)
			return multipleRooms[0];
		else
			return null;
	}
	
	public static MultipleRoom loadMultipleRoomByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		MultipleRoom[] multipleRooms = listMultipleRoomByQuery(session, condition, orderBy, lockMode);
		if (multipleRooms != null && multipleRooms.length > 0)
			return multipleRooms[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMultipleRoomByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateMultipleRoomByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMultipleRoomByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateMultipleRoomByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMultipleRoomByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.MultipleRoom as MultipleRoom");
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
	
	public static java.util.Iterator iterateMultipleRoomByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.MultipleRoom as MultipleRoom");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("MultipleRoom", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom createMultipleRoom() {
		return new MultipleRoom();
	}
	
	public static boolean save(MultipleRoom multipleRoom) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().saveObject(multipleRoom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(MultipleRoom multipleRoom) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().deleteObject(multipleRoom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(MultipleRoom multipleRoom) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().refresh(multipleRoom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(MultipleRoom multipleRoom) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().evict(multipleRoom);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static MultipleRoom loadMultipleRoomByCriteria(MultipleRoomCriteria multipleRoomCriteria) {
		MultipleRoom[] multipleRooms = listMultipleRoomByCriteria(multipleRoomCriteria);
		if(multipleRooms == null || multipleRooms.length == 0) {
			return null;
		}
		return multipleRooms[0];
	}
	
	public static MultipleRoom[] listMultipleRoomByCriteria(MultipleRoomCriteria multipleRoomCriteria) {
		return multipleRoomCriteria.listMultipleRoom();
	}
}
