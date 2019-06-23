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

import business.entities.BedroomType;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BedroomTypeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	
	public BedroomTypeDetachedCriteria() {
		super(BedroomType.class, BedroomTypeCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public BedroomTypeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, BedroomTypeCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public BedroomType uniqueBedroomType(PersistentSession session) {
		return (BedroomType) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public BedroomType[] listBedroomType(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (BedroomType[]) list.toArray(new BedroomType[list.size()]);
	}
}

