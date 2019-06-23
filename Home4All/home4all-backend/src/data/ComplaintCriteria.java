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

import business.entities.Complaint;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComplaintCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression description;
	
	public ComplaintCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		description = new StringExpression("description", this);
	}
	
	public ComplaintCriteria(PersistentSession session) {
		this(session.createCriteria(Complaint.class));
	}
	
	public ComplaintCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Complaint uniqueComplaint() {
		return (Complaint) super.uniqueResult();
	}
	
	public Complaint[] listComplaint() {
		java.util.List list = super.list();
		return (Complaint[]) list.toArray(new Complaint[list.size()]);
	}
}

