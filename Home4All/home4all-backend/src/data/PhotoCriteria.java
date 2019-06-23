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

import business.entities.Photo;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PhotoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public PhotoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		path = new StringExpression("path", this);
	}
	
	public PhotoCriteria(PersistentSession session) {
		this(session.createCriteria(Photo.class));
	}
	
	public PhotoCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Photo uniquePhoto() {
		return (Photo) super.uniqueResult();
	}
	
	public Photo[] listPhoto() {
		java.util.List list = super.list();
		return (Photo[]) list.toArray(new Photo[list.size()]);
	}
}

