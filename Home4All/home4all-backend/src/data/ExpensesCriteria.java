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

import business.entities.Expenses;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ExpensesCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	
	public ExpensesCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
	}
	
	public ExpensesCriteria(PersistentSession session) {
		this(session.createCriteria(Expenses.class));
	}
	
	public ExpensesCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Expenses uniqueExpenses() {
		return (Expenses) super.uniqueResult();
	}
	
	public Expenses[] listExpenses() {
		java.util.List list = super.list();
		return (Expenses[]) list.toArray(new Expenses[list.size()]);
	}
}

