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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ChatCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression commonId;
	public final AssociationExpression common;
	
	public ChatCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		commonId = new IntegerExpression("ORM_Common.ID", this);
		common = new AssociationExpression("ORM_Common", this);
	}
	
	public ChatCriteria(PersistentSession session) {
		this(session.createCriteria(Chat.class));
	}
	
	public ChatCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public CommonCriteria createCommonCriteria() {
		return new CommonCriteria(createCriteria("ORM_Common"));
	}
	
	public Chat uniqueChat() {
		return (Chat) super.uniqueResult();
	}
	
	public Chat[] listChat() {
		java.util.List list = super.list();
		return (Chat[]) list.toArray(new Chat[list.size()]);
	}
}

