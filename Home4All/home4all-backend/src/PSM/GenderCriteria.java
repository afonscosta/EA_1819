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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class GenderCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public GenderCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public GenderCriteria(PersistentSession session) {
		this(session.createCriteria(Gender.class));
	}
	
	public GenderCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public Gender uniqueGender() {
		return (Gender) super.uniqueResult();
	}
	
	public Gender[] listGender() {
		java.util.List list = super.list();
		return (Gender[]) list.toArray(new Gender[list.size()]);
	}
}
