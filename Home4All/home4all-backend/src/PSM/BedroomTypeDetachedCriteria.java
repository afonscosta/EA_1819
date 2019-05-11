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

public class BedroomTypeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public BedroomTypeDetachedCriteria() {
		super(PSM.BedroomType.class, PSM.BedroomTypeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public BedroomTypeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.BedroomTypeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public BedroomType uniqueBedroomType(PersistentSession session) {
		return (BedroomType) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public BedroomType[] listBedroomType(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (BedroomType[]) list.toArray(new BedroomType[list.size()]);
	}
}

