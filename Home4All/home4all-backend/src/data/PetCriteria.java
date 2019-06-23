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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PetCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression type;
	
	public PetCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		type = new StringExpression("type", this);
	}
	
	public PetCriteria(PersistentSession session) {
		this(session.createCriteria(Pet.class));
	}
	
	public PetCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Pet uniquePet() {
		return (Pet) super.uniqueResult();
	}
	
	public Pet[] listPet() {
		java.util.List list = super.list();
		return (Pet[]) list.toArray(new Pet[list.size()]);
	}
}

