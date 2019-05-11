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

public class ChatDAO {
	public static Chat loadChatByORMID(int ID, PSM.Common common) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadChatByORMID(session, ID, common);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat getChatByORMID(int ID, PSM.Common common) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getChatByORMID(session, ID, common);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByORMID(int ID, PSM.Common common, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadChatByORMID(session, ID, common, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat getChatByORMID(int ID, PSM.Common common, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return getChatByORMID(session, ID, common, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByORMID(PersistentSession session, int ID, PSM.Common common) throws PersistentException {
		try {
			Chat chat = new PSM.Chat();
			chat.setID(ID);
			chat.setORM_Common(common);
			
			return (Chat) session.load(PSM.Chat.class, chat);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat getChatByORMID(PersistentSession session, int ID, PSM.Common common) throws PersistentException {
		try {
			Chat chat = new PSM.Chat();
			chat.setID(ID);
			chat.setORM_Common(common);
			
			return (Chat) session.get(PSM.Chat.class, chat);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByORMID(PersistentSession session, int ID, PSM.Common common, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Chat chat = new PSM.Chat();
			chat.setID(ID);
			chat.setORM_Common(common);
			
			return (Chat) session.load(PSM.Chat.class, chat, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat getChatByORMID(PersistentSession session, int ID, PSM.Common common, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Chat chat = new PSM.Chat();
			chat.setID(ID);
			chat.setORM_Common(common);
			
			return (Chat) session.get(PSM.Chat.class, chat, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryChat(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryChat(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryChat(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return queryChat(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat[] listChatByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listChatByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat[] listChatByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return listChatByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryChat(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Chat as Chat");
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
	
	public static List queryChat(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Chat as Chat");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Chat", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat[] listChatByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryChat(session, condition, orderBy);
			return (Chat[]) list.toArray(new Chat[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat[] listChatByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryChat(session, condition, orderBy, lockMode);
			return (Chat[]) list.toArray(new Chat[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadChatByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return loadChatByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Chat[] chats = listChatByQuery(session, condition, orderBy);
		if (chats != null && chats.length > 0)
			return chats[0];
		else
			return null;
	}
	
	public static Chat loadChatByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Chat[] chats = listChatByQuery(session, condition, orderBy, lockMode);
		if (chats != null && chats.length > 0)
			return chats[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateChatByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateChatByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateChatByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PSM.Home4AllPersistentManager.instance().getSession();
			return iterateChatByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateChatByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Chat as Chat");
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
	
	public static java.util.Iterator iterateChatByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From PSM.Chat as Chat");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Chat", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat createChat() {
		return new PSM.Chat();
	}
	
	public static boolean save(PSM.Chat chat) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().saveObject(chat);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(PSM.Chat chat) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().deleteObject(chat);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(PSM.Chat chat)throws PersistentException {
		try {
			PSM.Common common = chat.getCommon();
			if (chat.getCommon() != null) {
				chat.getCommon().chats.remove(chat);
			}
			chat.setORM_Common(common);
			
			return delete(chat);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(PSM.Chat chat, org.orm.PersistentSession session)throws PersistentException {
		try {
			PSM.Common common = chat.getCommon();
			if (chat.getCommon() != null) {
				chat.getCommon().chats.remove(chat);
			}
			chat.setORM_Common(common);
			
			try {
				session.delete(chat);
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
	
	public static boolean refresh(PSM.Chat chat) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().refresh(chat);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(PSM.Chat chat) throws PersistentException {
		try {
			PSM.Home4AllPersistentManager.instance().getSession().evict(chat);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Chat loadChatByCriteria(ChatCriteria chatCriteria) {
		Chat[] chats = listChatByCriteria(chatCriteria);
		if(chats == null || chats.length == 0) {
			return null;
		}
		return chats[0];
	}
	
	public static Chat[] listChatByCriteria(ChatCriteria chatCriteria) {
		return chatCriteria.listChat();
	}
}
