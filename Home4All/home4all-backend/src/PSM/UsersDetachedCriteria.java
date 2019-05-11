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

public class UsersDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression name;
	
	public UsersDetachedCriteria() {
		super(PSM.Users.class, PSM.UsersCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public UsersDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.UsersCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public Users uniqueUsers(PersistentSession session) {
		return (Users) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Users[] listUsers(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Users[]) list.toArray(new Users[list.size()]);
	}
}

