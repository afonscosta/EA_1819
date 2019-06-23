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

import java.util.List;

import business.entities.Pet;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PetDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression type;
	
	public PetDetachedCriteria() {
		super(Pet.class, PetCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
	}
	
	public PetDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PetCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
	}
	
	public Pet uniquePet(PersistentSession session) {
		return (Pet) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pet[] listPet(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pet[]) list.toArray(new Pet[list.size()]);
	}
}

