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

public class OrdinationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public OrdinationDetachedCriteria() {
		super(PSM.Ordination.class, PSM.OrdinationCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public OrdinationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.OrdinationCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public Ordination uniqueOrdination(PersistentSession session) {
		return (Ordination) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ordination[] listOrdination(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ordination[]) list.toArray(new Ordination[list.size()]);
	}
}

