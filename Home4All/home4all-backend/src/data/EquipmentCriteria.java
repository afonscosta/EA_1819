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

import business.entities.Equipment;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EquipmentCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	
	public EquipmentCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
	}
	
	public EquipmentCriteria(PersistentSession session) {
		this(session.createCriteria(Equipment.class));
	}
	
	public EquipmentCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Equipment uniqueEquipment() {
		return (Equipment) super.uniqueResult();
	}
	
	public Equipment[] listEquipment() {
		java.util.List list = super.list();
		return (Equipment[]) list.toArray(new Equipment[list.size()]);
	}
}

