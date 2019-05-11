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

public class FolderDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression properties;
	
	public FolderDetachedCriteria() {
		super(PSM.Folder.class, PSM.FolderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
	}
	
	public FolderDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.FolderCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
	}
	
	public PSM.PropertyDetachedCriteria createPropertiesCriteria() {
		return new PSM.PropertyDetachedCriteria(createCriteria("ORM_Properties"));
	}
	
	public Folder uniqueFolder(PersistentSession session) {
		return (Folder) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Folder[] listFolder(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Folder[]) list.toArray(new Folder[list.size()]);
	}
}

