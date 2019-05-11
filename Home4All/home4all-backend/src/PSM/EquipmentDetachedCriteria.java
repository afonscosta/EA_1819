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

public class EquipmentDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public EquipmentDetachedCriteria() {
		super(PSM.Equipment.class, PSM.EquipmentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public EquipmentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.EquipmentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public Equipment uniqueEquipment(PersistentSession session) {
		return (Equipment) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Equipment[] listEquipment(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Equipment[]) list.toArray(new Equipment[list.size()]);
	}
}

