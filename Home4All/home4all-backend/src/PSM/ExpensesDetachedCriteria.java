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

public class ExpensesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ExpensesDetachedCriteria() {
		super(PSM.Expenses.class, PSM.ExpensesCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ExpensesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.ExpensesCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public Expenses uniqueExpenses(PersistentSession session) {
		return (Expenses) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Expenses[] listExpenses(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Expenses[]) list.toArray(new Expenses[list.size()]);
	}
}

