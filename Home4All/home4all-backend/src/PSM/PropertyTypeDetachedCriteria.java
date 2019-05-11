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

public class PropertyTypeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public PropertyTypeDetachedCriteria() {
		super(PSM.PropertyType.class, PSM.PropertyTypeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public PropertyTypeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.PropertyTypeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public PropertyType uniquePropertyType(PersistentSession session) {
		return (PropertyType) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PropertyType[] listPropertyType(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PropertyType[]) list.toArray(new PropertyType[list.size()]);
	}
}

