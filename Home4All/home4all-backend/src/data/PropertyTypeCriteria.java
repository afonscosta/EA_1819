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

import business.entities.PropertyType;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PropertyTypeCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	
	public PropertyTypeCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
	}
	
	public PropertyTypeCriteria(PersistentSession session) {
		this(session.createCriteria(PropertyType.class));
	}
	
	public PropertyTypeCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public PropertyType uniquePropertyType() {
		return (PropertyType) super.uniqueResult();
	}
	
	public PropertyType[] listPropertyType() {
		java.util.List list = super.list();
		return (PropertyType[]) list.toArray(new PropertyType[list.size()]);
	}
}

