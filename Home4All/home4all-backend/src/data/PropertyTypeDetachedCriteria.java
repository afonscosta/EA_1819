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

import business.entities.PropertyType;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PropertyTypeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	
	public PropertyTypeDetachedCriteria() {
		super(PropertyType.class, PropertyTypeCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public PropertyTypeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PropertyTypeCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public PropertyType uniquePropertyType(PersistentSession session) {
		return (PropertyType) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PropertyType[] listPropertyType(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PropertyType[]) list.toArray(new PropertyType[list.size()]);
	}
}

