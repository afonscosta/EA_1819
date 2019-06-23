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

import business.entities.Folder;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FolderDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression properties;
	
	public FolderDetachedCriteria() {
		super(Folder.class, FolderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
	}
	
	public FolderDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, FolderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
	}
	
	public PropertyDetachedCriteria createPropertiesCriteria() {
		return new PropertyDetachedCriteria(createCriteria("ORM_Properties"));
	}
	
	public Folder uniqueFolder(PersistentSession session) {
		return (Folder) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Folder[] listFolder(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Folder[]) list.toArray(new Folder[list.size()]);
	}
}

