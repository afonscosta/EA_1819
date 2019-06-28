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

import business.entities.Private;
import business.entities.Property;
import business.entities.Shared;
import org.hibernate.SQLQuery;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.orm.*;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PropertyDAO {
	public static Property loadPropertyByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property getPropertyByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getPropertyByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property getPropertyByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getPropertyByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Property) session.load(Property.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property getPropertyByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Property) session.get(Property.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Property) session.load(Property.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property getPropertyByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Property) session.get(Property.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProperty(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryProperty(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProperty(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryProperty(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property[] listPropertyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listPropertyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property[] listPropertyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listPropertyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProperty(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Property as Property");
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
	
	public static List queryProperty(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Property as Property");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Property", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property[] listPropertyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProperty(session, condition, orderBy);
			return (Property[]) list.toArray(new Property[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property[] listPropertyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProperty(session, condition, orderBy, lockMode);
			return (Property[]) list.toArray(new Property[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadPropertyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Property[] propertys = listPropertyByQuery(session, condition, orderBy);
		if (propertys != null && propertys.length > 0)
			return propertys[0];
		else
			return null;
	}
	
	public static Property loadPropertyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Property[] propertys = listPropertyByQuery(session, condition, orderBy, lockMode);
		if (propertys != null && propertys.length > 0)
			return propertys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePropertyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iteratePropertyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropertyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iteratePropertyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePropertyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Property as Property");
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
	
	public static java.util.Iterator iteratePropertyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Property as Property");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Property", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property createProperty() {
		return new Property();
	}
	
	public static boolean save(Property property) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().saveObject(property);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Property property) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().deleteObject(property);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Property property)throws PersistentException {
		if (property instanceof Shared) {
			return SharedDAO.deleteAndDissociate((Shared) property);
		}
		
		if (property instanceof Private) {
			return PrivateDAO.deleteAndDissociate((Private) property);
		}
		
		try {
			if (property.getOwner() != null) {
				property.getOwner().properties.remove(property);
			}
			
			return delete(property);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Property property, org.orm.PersistentSession session)throws PersistentException {
		if (property instanceof Shared) {
			return SharedDAO.deleteAndDissociate((Shared) property, session);
		}
		
		if (property instanceof Private) {
			return PrivateDAO.deleteAndDissociate((Private) property, session);
		}
		
		try {
			if (property.getOwner() != null) {
				property.getOwner().properties.remove(property);
			}
			
			try {
				session.delete(property);
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
	
	public static boolean refresh(Property property) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().refresh(property);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Property property) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().evict(property);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Property loadPropertyByCriteria(PropertyCriteria propertyCriteria) {
		Property[] propertys = listPropertyByCriteria(propertyCriteria);
		if(propertys == null || propertys.length == 0) {
			return null;
		}
		return propertys[0];
	}
	
	public static Property[] listPropertyByCriteria(PropertyCriteria propertyCriteria) {
		return propertyCriteria.listProperty();
	}



	// COSTUMED METHODS

	public static Property loadPropertyByQuery(String condition, String orderBy, Map<String, Object> parameters) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();

			StringBuilder sb = new StringBuilder("From business.entities.Property as Property");
			if (condition != null)
				sb.append(" Where ").append(condition);
			if (orderBy != null)
				sb.append(" Order By ").append(orderBy);
			Query query = session.createQuery(sb.toString());

			for (Map.Entry<String, Object> p: parameters.entrySet()) {
				query.setParameter(p.getKey(), p.getValue());
			}

			List properties = query.list();
			if (properties != null && properties.size() > 0)
				return (Property) properties.get(0);
			else
				return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List<Property> listPropertyByQuery(String condition, String orderBy, String limit, Map<String, Object> parameters) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();

			StringBuilder sb = new StringBuilder("From business.entities.Property as Property");
			if (condition != null)
				sb.append(" Where ").append(condition);
			if (orderBy != null)
				sb.append(" Order By ").append(orderBy);
			if (limit != null)
				sb.append(" Limit ").append(limit);
			Query query = session.createQuery(sb.toString());

			for (Map.Entry<String, Object> p: parameters.entrySet()) {
				query.setParameter(p.getKey(), p.getValue());
			}

			List properties = query.list();
			if (properties != null && properties.size() > 0)
				return Arrays.asList((Property[]) properties.toArray(new Property[properties.size()]));
			else
				return new ArrayList<>();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}


	public static List<Property> listPropertyBySQLQuery(PersistentSession session, String joinTables,
														String condition, String orderBy,
														String limit, String offset,
														Map<String, Object> parameters)
			throws PersistentException {
		try {
			StringBuilder sb = new StringBuilder("SELECT * FROM (SELECT DISTINCT Property.* FROM Property");
			if (joinTables != null)
				sb.append(joinTables);
			if (condition != null)
				sb.append(" WHERE ").append(condition);
			sb.append(") AS Property ");
			if (orderBy != null)
				sb.append(" ORDER BY ").append(orderBy);
			if (limit != null)
				sb.append(" LIMIT ").append(limit);
			if (limit != null)
				sb.append(" OFFSET ").append(offset);

			System.out.println(sb.toString());

			SQLQuery query = session.createSQLQuery(sb.toString());

			for (Map.Entry<String, Object> p: parameters.entrySet()) {
				query.setParameter(p.getKey(), p.getValue());
			}

			query.addEntity("Property", Property.class);

			List<Property> properties = query.list();

			if (properties != null && properties.size() > 0)
				return properties;
			else
				return new ArrayList<>();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
}
