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

import business.entities.Ordination;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class OrdinationCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	
	public OrdinationCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
	}
	
	public OrdinationCriteria(PersistentSession session) {
		this(session.createCriteria(Ordination.class));
	}
	
	public OrdinationCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Ordination uniqueOrdination() {
		return (Ordination) super.uniqueResult();
	}
	
	public Ordination[] listOrdination() {
		java.util.List list = super.list();
		return (Ordination[]) list.toArray(new Ordination[list.size()]);
	}
}

