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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class MultipleRoomCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression peopleAmount;
	public final IntegerExpression quantity;
	
	public MultipleRoomCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		peopleAmount = new IntegerExpression("peopleAmount", this);
		quantity = new IntegerExpression("quantity", this);
	}
	
	public MultipleRoomCriteria(PersistentSession session) {
		this(session.createCriteria(MultipleRoom.class));
	}
	
	public MultipleRoomCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public MultipleRoom uniqueMultipleRoom() {
		return (MultipleRoom) super.uniqueResult();
	}
	
	public MultipleRoom[] listMultipleRoom() {
		java.util.List list = super.list();
		return (MultipleRoom[]) list.toArray(new MultipleRoom[list.size()]);
	}
}

