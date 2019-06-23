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

import java.util.List;

import business.entities.Expenses;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ExpensesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	
	public ExpensesDetachedCriteria() {
		super(Expenses.class, ExpensesCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public ExpensesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ExpensesCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public Expenses uniqueExpenses(PersistentSession session) {
		return (Expenses) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Expenses[] listExpenses(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Expenses[]) list.toArray(new Expenses[list.size()]);
	}
}

