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

import business.entities.Chat;
import business.entities.Common;
import business.entities.InternalAccount;
import business.entities.Property;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class CommonDAO {
	public static Common loadCommonByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadCommonByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common getCommonByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getCommonByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common loadCommonByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadCommonByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common getCommonByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return getCommonByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common loadCommonByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Common) session.load(Common.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common getCommonByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Common) session.get(Common.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common loadCommonByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Common) session.load(Common.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common getCommonByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Common) session.get(Common.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCommon(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryCommon(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCommon(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return queryCommon(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common[] listCommonByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listCommonByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common[] listCommonByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return listCommonByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCommon(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Common as Common");
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
	
	public static List queryCommon(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Common as Common");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Common", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common[] listCommonByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCommon(session, condition, orderBy);
			return (Common[]) list.toArray(new Common[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common[] listCommonByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCommon(session, condition, orderBy, lockMode);
			return (Common[]) list.toArray(new Common[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common loadCommonByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadCommonByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common loadCommonByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return loadCommonByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common loadCommonByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Common[] commons = listCommonByQuery(session, condition, orderBy);
		if (commons != null && commons.length > 0)
			return commons[0];
		else
			return null;
	}
	
	public static Common loadCommonByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Common[] commons = listCommonByQuery(session, condition, orderBy, lockMode);
		if (commons != null && commons.length > 0)
			return commons[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCommonByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateCommonByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommonByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Home4AllPersistentManager.instance().getSession();
			return iterateCommonByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommonByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Common as Common");
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
	
	public static java.util.Iterator iterateCommonByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Common as Common");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Common", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Common createCommon() {
		return new Common();
	}
	
	public static boolean save(Common common) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().saveObject(common);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Common common) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().deleteObject(common);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Common common)throws PersistentException {
		if (common instanceof InternalAccount) {
			return InternalAccountDAO.deleteAndDissociate((InternalAccount) common);
		}
		
		try {
			Property[] lPropertiess = common.properties.toArray();
			for(int i = 0; i < lPropertiess.length; i++) {
				lPropertiess[i].setOwner(null);
			}
			Chat[] lChatss = common.chats.toArray();
			for(int i = 0; i < lChatss.length; i++) {
				lChatss[i].setCommon(null);
			}
			return delete(common);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Common common, org.orm.PersistentSession session)throws PersistentException {
		if (common instanceof InternalAccount) {
			return InternalAccountDAO.deleteAndDissociate((InternalAccount) common, session);
		}
		
		try {
			Property[] lPropertiess = common.properties.toArray();
			for(int i = 0; i < lPropertiess.length; i++) {
				lPropertiess[i].setOwner(null);
			}
			Chat[] lChatss = common.chats.toArray();
			for(int i = 0; i < lChatss.length; i++) {
				lChatss[i].setCommon(null);
			}
			try {
				session.delete(common);
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
	
	public static boolean refresh(Common common) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().refresh(common);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Common common) throws PersistentException {
		try {
			Home4AllPersistentManager.instance().getSession().evict(common);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
