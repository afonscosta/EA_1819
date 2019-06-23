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

import business.entities.Folder;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FolderCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression properties;
	
	public FolderCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		properties = new CollectionExpression("ORM_Properties", this);
	}
	
	public FolderCriteria(PersistentSession session) {
		this(session.createCriteria(Folder.class));
	}
	
	public FolderCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public PropertyCriteria createPropertiesCriteria() {
		return new PropertyCriteria(createCriteria("ORM_Properties"));
	}
	
	public Folder uniqueFolder() {
		return (Folder) super.uniqueResult();
	}
	
	public Folder[] listFolder() {
		java.util.List list = super.list();
		return (Folder[]) list.toArray(new Folder[list.size()]);
	}
}

