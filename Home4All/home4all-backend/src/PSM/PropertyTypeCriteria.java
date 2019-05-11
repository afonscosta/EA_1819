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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PropertyTypeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public PropertyTypeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public PropertyTypeCriteria(PersistentSession session) {
		this(session.createCriteria(PropertyType.class));
	}
	
	public PropertyTypeCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public PropertyType uniquePropertyType() {
		return (PropertyType) super.uniqueResult();
	}
	
	public PropertyType[] listPropertyType() {
		java.util.List list = super.list();
		return (PropertyType[]) list.toArray(new PropertyType[list.size()]);
	}
}

