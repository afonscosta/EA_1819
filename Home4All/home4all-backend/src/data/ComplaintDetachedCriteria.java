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

import business.entities.Complaint;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComplaintDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression description;
	
	public ComplaintDetachedCriteria() {
		super(Complaint.class, ComplaintCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
	}
	
	public ComplaintDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ComplaintCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
	}
	
	public Complaint uniqueComplaint(PersistentSession session) {
		return (Complaint) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Complaint[] listComplaint(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Complaint[]) list.toArray(new Complaint[list.size()]);
	}
}

