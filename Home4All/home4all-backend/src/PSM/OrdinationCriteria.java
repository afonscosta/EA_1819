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

public class OrdinationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public OrdinationCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public OrdinationCriteria(PersistentSession session) {
		this(session.createCriteria(Ordination.class));
	}
	
	public OrdinationCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public Ordination uniqueOrdination() {
		return (Ordination) super.uniqueResult();
	}
	
	public Ordination[] listOrdination() {
		java.util.List list = super.list();
		return (Ordination[]) list.toArray(new Ordination[list.size()]);
	}
}

