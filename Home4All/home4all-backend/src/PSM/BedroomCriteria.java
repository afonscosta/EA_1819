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

public class BedroomCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression typeId;
	public final AssociationExpression type;
	public final IntegerExpression peopleAmount;
	public final FloatExpression area;
	public final BooleanExpression furnished;
	public final BooleanExpression privateBathroom;
	public final DateExpression availability;
	public final FloatExpression rentPrice;
	public final BooleanExpression sold;
	
	public BedroomCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		typeId = new IntegerExpression("type.ID", this);
		type = new AssociationExpression("type", this);
		peopleAmount = new IntegerExpression("peopleAmount", this);
		area = new FloatExpression("area", this);
		furnished = new BooleanExpression("furnished", this);
		privateBathroom = new BooleanExpression("privateBathroom", this);
		availability = new DateExpression("availability", this);
		rentPrice = new FloatExpression("rentPrice", this);
		sold = new BooleanExpression("sold", this);
	}
	
	public BedroomCriteria(PersistentSession session) {
		this(session.createCriteria(Bedroom.class));
	}
	
	public BedroomCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public BedroomTypeCriteria createTypeCriteria() {
		return new BedroomTypeCriteria(createCriteria("type"));
	}
	
	public Bedroom uniqueBedroom() {
		return (Bedroom) super.uniqueResult();
	}
	
	public Bedroom[] listBedroom() {
		java.util.List list = super.list();
		return (Bedroom[]) list.toArray(new Bedroom[list.size()]);
	}
}

