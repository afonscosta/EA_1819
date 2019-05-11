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

public class EquipmentCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public EquipmentCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public EquipmentCriteria(PersistentSession session) {
		this(session.createCriteria(Equipment.class));
	}
	
	public EquipmentCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public Equipment uniqueEquipment() {
		return (Equipment) super.uniqueResult();
	}
	
	public Equipment[] listEquipment() {
		java.util.List list = super.list();
		return (Equipment[]) list.toArray(new Equipment[list.size()]);
	}
}

