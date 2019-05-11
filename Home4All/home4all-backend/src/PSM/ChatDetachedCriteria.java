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

public class ChatDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression commonId;
	public final AssociationExpression common;
	
	public ChatDetachedCriteria() {
		super(PSM.Chat.class, PSM.ChatCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		commonId = new IntegerExpression("ORM_Common.ID", this.getDetachedCriteria());
		common = new AssociationExpression("ORM_Common", this.getDetachedCriteria());
	}
	
	public ChatDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.ChatCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		commonId = new IntegerExpression("ORM_Common.ID", this.getDetachedCriteria());
		common = new AssociationExpression("ORM_Common", this.getDetachedCriteria());
	}
	
	public CommonDetachedCriteria createCommonCriteria() {
		return new CommonDetachedCriteria(createCriteria("ORM_Common"));
	}
	
	public Chat uniqueChat(PersistentSession session) {
		return (Chat) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Chat[] listChat(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Chat[]) list.toArray(new Chat[list.size()]);
	}
}

