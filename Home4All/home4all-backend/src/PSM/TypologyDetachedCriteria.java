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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TypologyDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public TypologyDetachedCriteria() {
		super(PSM.Typology.class, PSM.TypologyCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public TypologyDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.TypologyCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public Typology uniqueTypology(PersistentSession session) {
		return (Typology) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Typology[] listTypology(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Typology[]) list.toArray(new Typology[list.size()]);
	}
}

