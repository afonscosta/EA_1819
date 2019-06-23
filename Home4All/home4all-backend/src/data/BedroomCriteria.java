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

import business.entities.Bedroom;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BedroomCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression typeId;
	public final AssociationExpression type;
	public final BooleanExpression furnished;
	public final IntegerExpression peopleAmount;
	public final FloatExpression area;
	public final BooleanExpression privateBathroom;
	public final DateExpression availability;
	public final FloatExpression rentPrice;
	public final BooleanExpression sold;
	public final CollectionExpression photos;
	
	public BedroomCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		typeId = new StringExpression("type.name", this);
		type = new AssociationExpression("type", this);
		furnished = new BooleanExpression("furnished", this);
		peopleAmount = new IntegerExpression("peopleAmount", this);
		area = new FloatExpression("area", this);
		privateBathroom = new BooleanExpression("privateBathroom", this);
		availability = new DateExpression("availability", this);
		rentPrice = new FloatExpression("rentPrice", this);
		sold = new BooleanExpression("sold", this);
		photos = new CollectionExpression("ORM_Photos", this);
	}
	
	public BedroomCriteria(PersistentSession session) {
		this(session.createCriteria(Bedroom.class));
	}
	
	public BedroomCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public BedroomTypeCriteria createTypeCriteria() {
		return new BedroomTypeCriteria(createCriteria("type"));
	}
	
	public PhotoCriteria createPhotosCriteria() {
		return new PhotoCriteria(createCriteria("ORM_Photos"));
	}
	
	public Bedroom uniqueBedroom() {
		return (Bedroom) super.uniqueResult();
	}
	
	public Bedroom[] listBedroom() {
		java.util.List list = super.list();
		return (Bedroom[]) list.toArray(new Bedroom[list.size()]);
	}
}

