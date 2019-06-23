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

import business.entities.Bedroom;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BedroomDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public BedroomDetachedCriteria() {
		super(Bedroom.class, BedroomCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		typeId = new StringExpression("type.name", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		furnished = new BooleanExpression("furnished", this.getDetachedCriteria());
		peopleAmount = new IntegerExpression("peopleAmount", this.getDetachedCriteria());
		area = new FloatExpression("area", this.getDetachedCriteria());
		privateBathroom = new BooleanExpression("privateBathroom", this.getDetachedCriteria());
		availability = new DateExpression("availability", this.getDetachedCriteria());
		rentPrice = new FloatExpression("rentPrice", this.getDetachedCriteria());
		sold = new BooleanExpression("sold", this.getDetachedCriteria());
		photos = new CollectionExpression("ORM_Photos", this.getDetachedCriteria());
	}
	
	public BedroomDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, BedroomCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		typeId = new StringExpression("type.name", this.getDetachedCriteria());
		type = new AssociationExpression("type", this.getDetachedCriteria());
		furnished = new BooleanExpression("furnished", this.getDetachedCriteria());
		peopleAmount = new IntegerExpression("peopleAmount", this.getDetachedCriteria());
		area = new FloatExpression("area", this.getDetachedCriteria());
		privateBathroom = new BooleanExpression("privateBathroom", this.getDetachedCriteria());
		availability = new DateExpression("availability", this.getDetachedCriteria());
		rentPrice = new FloatExpression("rentPrice", this.getDetachedCriteria());
		sold = new BooleanExpression("sold", this.getDetachedCriteria());
		photos = new CollectionExpression("ORM_Photos", this.getDetachedCriteria());
	}
	
	public BedroomTypeDetachedCriteria createTypeCriteria() {
		return new BedroomTypeDetachedCriteria(createCriteria("type"));
	}
	
	public PhotoDetachedCriteria createPhotosCriteria() {
		return new PhotoDetachedCriteria(createCriteria("ORM_Photos"));
	}
	
	public Bedroom uniqueBedroom(PersistentSession session) {
		return (Bedroom) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Bedroom[] listBedroom(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Bedroom[]) list.toArray(new Bedroom[list.size()]);
	}
}

