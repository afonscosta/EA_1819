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

import business.entities.PropertyType;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class PropertyTypeDAO {
	public static PropertyType loadPropertyTypeByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyTypeByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType getPropertyTypeByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getPropertyTypeByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyTypeByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType getPropertyTypeByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getPropertyTypeByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (PropertyType) session.load(PropertyType.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType getPropertyTypeByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (PropertyType) session.get(PropertyType.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropertyType) session.load(PropertyType.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType getPropertyTypeByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PropertyType) session.get(PropertyType.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropertyType(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryPropertyType(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropertyType(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryPropertyType(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType[] listPropertyTypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listPropertyTypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType[] listPropertyTypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listPropertyTypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPropertyType(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.PropertyType as PropertyType");
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
	
	public static List queryPropertyType(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.PropertyType as PropertyType");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropertyType", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType[] listPropertyTypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPropertyType(session, condition, orderBy);
			return (PropertyType[]) list.toArray(new PropertyType[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType[] listPropertyTypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPropertyType(session, condition, orderBy, lockMode);
			return (PropertyType[]) list.toArray(new PropertyType[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyTypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyTypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		PropertyType[] propertyTypes = listPropertyTypeByQuery(session, condition, orderBy);
		if (propertyTypes != null && propertyTypes.length > 0)
			return propertyTypes[0];
		else
			return null;
	}
	
	public static PropertyType loadPropertyTypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		PropertyType[] propertyTypes = listPropertyTypeByQuery(session, condition, orderBy, lockMode);
		if (propertyTypes != null && propertyTypes.length > 0)
			return propertyTypes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePropertyTypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iteratePropertyTypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropertyTypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iteratePropertyTypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropertyTypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.PropertyType as PropertyType");
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
	
	public static java.util.Iterator iteratePropertyTypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.PropertyType as PropertyType");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PropertyType", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType createPropertyType() {
		return new PropertyType();
	}
	
	public static boolean save(PropertyType propertyType) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().saveObject(propertyType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(PropertyType propertyType) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().deleteObject(propertyType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(PropertyType propertyType) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().refresh(propertyType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(PropertyType propertyType) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().evict(propertyType);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PropertyType loadPropertyTypeByCriteria(PropertyTypeCriteria propertyTypeCriteria) {
		PropertyType[] propertyTypes = listPropertyTypeByCriteria(propertyTypeCriteria);
		if(propertyTypes == null || propertyTypes.length == 0) {
			return null;
		}
		return propertyTypes[0];
	}
	
	public static PropertyType[] listPropertyTypeByCriteria(PropertyTypeCriteria propertyTypeCriteria) {
		return propertyTypeCriteria.listPropertyType();
	}
}
