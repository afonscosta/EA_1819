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

import business.entities.Occupation;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class OccupationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	
	public OccupationDetachedCriteria() {
		super(Occupation.class, OccupationCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public OccupationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, OccupationCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public Occupation uniqueOccupation(PersistentSession session) {
		return (Occupation) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Occupation[] listOccupation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Occupation[]) list.toArray(new Occupation[list.size()]);
	}
}

