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

import business.entities.Photo;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;
import java.util.Map;

public class PhotoDAO {
	public static Photo loadPhotoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPhotoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo getPhotoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return getPhotoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo loadPhotoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPhotoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo getPhotoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return getPhotoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo loadPhotoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Photo) session.load(Photo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo getPhotoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Photo) session.get(Photo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo loadPhotoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Photo) session.load(Photo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo getPhotoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Photo) session.get(Photo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPhoto(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return queryPhoto(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPhoto(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return queryPhoto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo[] listPhotoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return listPhotoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo[] listPhotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return listPhotoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPhoto(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Photo as Photo");
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
	
	public static List queryPhoto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Photo as Photo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Photo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo[] listPhotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPhoto(session, condition, orderBy);
			return (Photo[]) list.toArray(new Photo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo[] listPhotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPhoto(session, condition, orderBy, lockMode);
			return (Photo[]) list.toArray(new Photo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo loadPhotoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPhotoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}


	public static Photo loadPhotoByQuery(String condition, String orderBy, Map<String, Object> parameters) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();

			StringBuffer sb = new StringBuffer("From business.entities.Photo as Photo");
			if (condition != null)
				sb.append(" Where ").append(condition);
			if (orderBy != null)
				sb.append(" Order By ").append(orderBy);
			Query query = session.createQuery(sb.toString());

			for (Map.Entry<String, Object> p: parameters.entrySet()) {
				query.setParameter(p.getKey(), p.getValue());
			}

			List photos =  query.list();

			if (photos != null && photos.size() > 0)
				return (Photo) photos.get(0);
			else
				return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo loadPhotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPhotoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo loadPhotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Photo[] photos = listPhotoByQuery(session, condition, orderBy);
		if (photos != null && photos.length > 0)
			return photos[0];
		else
			return null;
	}
	
	public static Photo loadPhotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Photo[] photos = listPhotoByQuery(session, condition, orderBy, lockMode);
		if (photos != null && photos.length > 0)
			return photos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePhotoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return iteratePhotoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePhotoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return iteratePhotoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePhotoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Photo as Photo");
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
	
	public static java.util.Iterator iteratePhotoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Photo as Photo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Photo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Photo createPhoto() {
		return new Photo();
	}
	
	public static boolean save(Photo photo) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().saveObject(photo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Photo photo) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().deleteObject(photo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Photo photo) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().getSession().refresh(photo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Photo photo) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().getSession().evict(photo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
