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

public class OccupationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public OccupationCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public OccupationCriteria(PersistentSession session) {
		this(session.createCriteria(Occupation.class));
	}
	
	public OccupationCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public Occupation uniqueOccupation() {
		return (Occupation) super.uniqueResult();
	}
	
	public Occupation[] listOccupation() {
		java.util.List list = super.list();
		return (Occupation[]) list.toArray(new Occupation[list.size()]);
	}
}

