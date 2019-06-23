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

import business.entities.Admin;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AdminCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression name;
	public final StringExpression password;
	
	public AdminCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		name = new StringExpression("name", this);
		password = new StringExpression("password", this);
	}
	
	public AdminCriteria(PersistentSession session) {
		this(session.createCriteria(Admin.class));
	}
	
	public AdminCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Admin uniqueAdmin() {
		return (Admin) super.uniqueResult();
	}
	
	public Admin[] listAdmin() {
		java.util.List list = super.list();
		return (Admin[]) list.toArray(new Admin[list.size()]);
	}
}

