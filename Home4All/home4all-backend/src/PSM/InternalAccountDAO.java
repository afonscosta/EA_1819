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

public class InternalAccountDAO {
	public static InternalAccount loadInternalAccountByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadInternalAccountByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount getInternalAccountByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getInternalAccountByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadInternalAccountByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount getInternalAccountByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getInternalAccountByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (InternalAccount) session.load(PSM.InternalAccount.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount getInternalAccountByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (InternalAccount) session.get(PSM.InternalAccount.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (InternalAccount) session.load(PSM.InternalAccount.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount getInternalAccountByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (InternalAccount) session.get(PSM.InternalAccount.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInternalAccount(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryInternalAccount(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInternalAccount(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryInternalAccount(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount[] listInternalAccountByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listInternalAccountByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount[] listInternalAccountByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listInternalAccountByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInternalAccount(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.InternalAccount as InternalAccount");
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
	
	public static List queryInternalAccount(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.InternalAccount as InternalAccount");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("InternalAccount", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount[] listInternalAccountByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInternalAccount(session, condition, orderBy);
			return (InternalAccount[]) list.toArray(new InternalAccount[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount[] listInternalAccountByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInternalAccount(session, condition, orderBy, lockMode);
			return (InternalAccount[]) list.toArray(new InternalAccount[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadInternalAccountByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadInternalAccountByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		InternalAccount[] internalAccounts = listInternalAccountByQuery(session, condition, orderBy);
		if (internalAccounts != null && internalAccounts.length > 0)
			return internalAccounts[0];
		else
			return null;
	}
	
	public static InternalAccount loadInternalAccountByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		InternalAccount[] internalAccounts = listInternalAccountByQuery(session, condition, orderBy, lockMode);
		if (internalAccounts != null && internalAccounts.length > 0)
			return internalAccounts[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInternalAccountByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateInternalAccountByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInternalAccountByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateInternalAccountByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInternalAccountByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.InternalAccount as InternalAccount");
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
	
	public static java.util.Iterator iterateInternalAccountByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.InternalAccount as InternalAccount");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("InternalAccount", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount createInternalAccount() {
		return new PSM.InternalAccount();
	}
	
	public static boolean save(PSM.InternalAccount internalAccount) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().saveObject(internalAccount);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(PSM.InternalAccount internalAccount) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().deleteObject(internalAccount);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(PSM.InternalAccount internalAccount)throws PersistentException {
		try {
			PSM.Property[] lPropertiess = internalAccount.properties.toArray();
			for(int i = 0; i < lPropertiess.length; i++) {
				lPropertiess[i].setOwner(null);
			}
			PSM.Chat[] lChatss = internalAccount.chats.toArray();
			for(int i = 0; i < lChatss.length; i++) {
				lChatss[i].setCommon(null);
			}
			return delete(internalAccount);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(PSM.InternalAccount internalAccount, org.orm.PersistentSession session)throws PersistentException {
		try {
			PSM.Property[] lPropertiess = internalAccount.properties.toArray();
			for(int i = 0; i < lPropertiess.length; i++) {
				lPropertiess[i].setOwner(null);
			}
			PSM.Chat[] lChatss = internalAccount.chats.toArray();
			for(int i = 0; i < lChatss.length; i++) {
				lChatss[i].setCommon(null);
			}
			try {
				session.delete(internalAccount);
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
	
	public static boolean refresh(PSM.InternalAccount internalAccount) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().refresh(internalAccount);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(PSM.InternalAccount internalAccount) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().evict(internalAccount);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static InternalAccount loadInternalAccountByCriteria(InternalAccountCriteria internalAccountCriteria) {
		InternalAccount[] internalAccounts = listInternalAccountByCriteria(internalAccountCriteria);
		if(internalAccounts == null || internalAccounts.length == 0) {
			return null;
		}
		return internalAccounts[0];
	}
	
	public static InternalAccount[] listInternalAccountByCriteria(InternalAccountCriteria internalAccountCriteria) {
		return internalAccountCriteria.listInternalAccount();
	}
}
