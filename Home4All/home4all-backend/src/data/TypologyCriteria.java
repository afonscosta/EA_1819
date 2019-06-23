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

import business.entities.Typology;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TypologyCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	
	public TypologyCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
	}
	
	public TypologyCriteria(PersistentSession session) {
		this(session.createCriteria(Typology.class));
	}
	
	public TypologyCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Typology uniqueTypology() {
		return (Typology) super.uniqueResult();
	}
	
	public Typology[] listTypology() {
		java.util.List list = super.list();
		return (Typology[]) list.toArray(new Typology[list.size()]);
	}
}

