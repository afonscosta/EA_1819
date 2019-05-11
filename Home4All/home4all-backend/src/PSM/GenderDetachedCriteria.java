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

public class GenderDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public GenderDetachedCriteria() {
		super(PSM.Gender.class, PSM.GenderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public GenderDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.GenderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public Gender uniqueGender(PersistentSession session) {
		return (Gender) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Gender[] listGender(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Gender[]) list.toArray(new Gender[list.size()]);
	}
}

