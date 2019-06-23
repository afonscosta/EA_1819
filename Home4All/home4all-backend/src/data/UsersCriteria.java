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

import business.entities.Users;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UsersCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression name;
	
	public UsersCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		name = new StringExpression("name", this);
	}
	
	public UsersCriteria(PersistentSession session) {
		this(session.createCriteria(Users.class));
	}
	
	public UsersCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Users uniqueUsers() {
		return (Users) super.uniqueResult();
	}
	
	public Users[] listUsers() {
		java.util.List list = super.list();
		return (Users[]) list.toArray(new Users[list.size()]);
	}
}

