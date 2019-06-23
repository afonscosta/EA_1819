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

import business.entities.Ordination;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class OrdinationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	
	public OrdinationDetachedCriteria() {
		super(Ordination.class, OrdinationCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public OrdinationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, OrdinationCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public Ordination uniqueOrdination(PersistentSession session) {
		return (Ordination) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ordination[] listOrdination(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ordination[]) list.toArray(new Ordination[list.size()]);
	}
}

