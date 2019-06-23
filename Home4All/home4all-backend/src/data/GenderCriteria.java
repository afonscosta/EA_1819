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

import business.entities.Gender;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class GenderCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	
	public GenderCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
	}
	
	public GenderCriteria(PersistentSession session) {
		this(session.createCriteria(Gender.class));
	}
	
	public GenderCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Gender uniqueGender() {
		return (Gender) super.uniqueResult();
	}
	
	public Gender[] listGender() {
		java.util.List list = super.list();
		return (Gender[]) list.toArray(new Gender[list.size()]);
	}
}

