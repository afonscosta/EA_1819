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

import business.entities.Pet;
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class PetDAO {
	public static Pet loadPetByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPetByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet getPetByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return getPetByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet loadPetByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPetByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet getPetByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return getPetByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet loadPetByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Pet) session.load(Pet.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet getPetByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Pet) session.get(Pet.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet loadPetByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pet) session.load(Pet.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet getPetByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pet) session.get(Pet.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPet(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return queryPet(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPet(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return queryPet(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet[] listPetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return listPetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet[] listPetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return listPetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPet(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Pet as Pet");
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
	
	public static List queryPet(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Pet as Pet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pet", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet[] listPetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPet(session, condition, orderBy);
			return (Pet[]) list.toArray(new Pet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet[] listPetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPet(session, condition, orderBy, lockMode);
			return (Pet[]) list.toArray(new Pet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet loadPetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet loadPetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return loadPetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet loadPetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pet[] pets = listPetByQuery(session, condition, orderBy);
		if (pets != null && pets.length > 0)
			return pets[0];
		else
			return null;
	}
	
	public static Pet loadPetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pet[] pets = listPetByQuery(session, condition, orderBy, lockMode);
		if (pets != null && pets.length > 0)
			return pets[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePetByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return iteratePetByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePetByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = data.Home4AllPersistentManager.instance().getSession();
			return iteratePetByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Pet as Pet");
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
	
	public static java.util.Iterator iteratePetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.entities.Pet as Pet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pet", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pet createPet() {
		return new Pet();
	}
	
	public static boolean save(Pet pet) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().saveObject(pet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Pet pet) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().deleteObject(pet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Pet pet) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().getSession().refresh(pet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Pet pet) throws PersistentException {
		try {
			data.Home4AllPersistentManager.instance().getSession().evict(pet);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
