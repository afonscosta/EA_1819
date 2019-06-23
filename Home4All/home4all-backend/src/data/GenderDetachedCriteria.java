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

import business.entities.Gender;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class GenderDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	
	public GenderDetachedCriteria() {
		super(Gender.class, GenderCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public GenderDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, GenderCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public Gender uniqueGender(PersistentSession session) {
		return (Gender) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Gender[] listGender(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Gender[]) list.toArray(new Gender[list.size()]);
	}
}

