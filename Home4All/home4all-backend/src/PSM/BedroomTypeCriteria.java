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

public class BedroomTypeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public BedroomTypeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public BedroomTypeCriteria(PersistentSession session) {
		this(session.createCriteria(BedroomType.class));
	}
	
	public BedroomTypeCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public BedroomType uniqueBedroomType() {
		return (BedroomType) super.uniqueResult();
	}
	
	public BedroomType[] listBedroomType() {
		java.util.List list = super.list();
		return (BedroomType[]) list.toArray(new BedroomType[list.size()]);
	}
}

