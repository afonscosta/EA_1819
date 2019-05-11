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

public class NotificationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression ordinationId;
	public final AssociationExpression ordination;
	public final StringExpression name;
	public final StringExpression district;
	public final StringExpression city;
	public final StringExpression street;
	public final FloatExpression minSellPrice;
	public final FloatExpression maxSellPrice;
	public final FloatExpression minRentPrice;
	public final FloatExpression maxRentPrice;
	public final IntegerExpression peopleAmount;
	public final IntegerExpression singleRooms;
	public final IntegerExpression doubleRooms;
	public final BooleanExpression privateWC;
	public final BooleanExpression allowedSmokers;
	public final BooleanExpression allowedPets;
	public final BooleanExpression furnished;
	public final BooleanExpression totalAccess;
	public final CollectionExpression newProperties;
	public final CollectionExpression typologies;
	public final CollectionExpression allowedOccupations;
	public final CollectionExpression types;
	
	public NotificationDetachedCriteria() {
		super(PSM.Notification.class, PSM.NotificationCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ordinationId = new IntegerExpression("ordination.ID", this.getDetachedCriteria());
		ordination = new AssociationExpression("ordination", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		district = new StringExpression("district", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		street = new StringExpression("street", this.getDetachedCriteria());
		minSellPrice = new FloatExpression("minSellPrice", this.getDetachedCriteria());
		maxSellPrice = new FloatExpression("maxSellPrice", this.getDetachedCriteria());
		minRentPrice = new FloatExpression("minRentPrice", this.getDetachedCriteria());
		maxRentPrice = new FloatExpression("maxRentPrice", this.getDetachedCriteria());
		peopleAmount = new IntegerExpression("peopleAmount", this.getDetachedCriteria());
		singleRooms = new IntegerExpression("singleRooms", this.getDetachedCriteria());
		doubleRooms = new IntegerExpression("doubleRooms", this.getDetachedCriteria());
		privateWC = new BooleanExpression("privateWC", this.getDetachedCriteria());
		allowedSmokers = new BooleanExpression("allowedSmokers", this.getDetachedCriteria());
		allowedPets = new BooleanExpression("allowedPets", this.getDetachedCriteria());
		furnished = new BooleanExpression("furnished", this.getDetachedCriteria());
		totalAccess = new BooleanExpression("totalAccess", this.getDetachedCriteria());
		newProperties = new CollectionExpression("ORM_NewProperties", this.getDetachedCriteria());
		typologies = new CollectionExpression("ORM_Typologies", this.getDetachedCriteria());
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this.getDetachedCriteria());
		types = new CollectionExpression("ORM_Types", this.getDetachedCriteria());
	}
	
	public NotificationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.NotificationCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ordinationId = new IntegerExpression("ordination.ID", this.getDetachedCriteria());
		ordination = new AssociationExpression("ordination", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		district = new StringExpression("district", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		street = new StringExpression("street", this.getDetachedCriteria());
		minSellPrice = new FloatExpression("minSellPrice", this.getDetachedCriteria());
		maxSellPrice = new FloatExpression("maxSellPrice", this.getDetachedCriteria());
		minRentPrice = new FloatExpression("minRentPrice", this.getDetachedCriteria());
		maxRentPrice = new FloatExpression("maxRentPrice", this.getDetachedCriteria());
		peopleAmount = new IntegerExpression("peopleAmount", this.getDetachedCriteria());
		singleRooms = new IntegerExpression("singleRooms", this.getDetachedCriteria());
		doubleRooms = new IntegerExpression("doubleRooms", this.getDetachedCriteria());
		privateWC = new BooleanExpression("privateWC", this.getDetachedCriteria());
		allowedSmokers = new BooleanExpression("allowedSmokers", this.getDetachedCriteria());
		allowedPets = new BooleanExpression("allowedPets", this.getDetachedCriteria());
		furnished = new BooleanExpression("furnished", this.getDetachedCriteria());
		totalAccess = new BooleanExpression("totalAccess", this.getDetachedCriteria());
		newProperties = new CollectionExpression("ORM_NewProperties", this.getDetachedCriteria());
		typologies = new CollectionExpression("ORM_Typologies", this.getDetachedCriteria());
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this.getDetachedCriteria());
		types = new CollectionExpression("ORM_Types", this.getDetachedCriteria());
	}
	
	public OrdinationDetachedCriteria createOrdinationCriteria() {
		return new OrdinationDetachedCriteria(createCriteria("ordination"));
	}
	
	public PSM.PropertyDetachedCriteria createNewPropertiesCriteria() {
		return new PSM.PropertyDetachedCriteria(createCriteria("ORM_NewProperties"));
	}
	
	public PSM.TypologyDetachedCriteria createTypologiesCriteria() {
		return new PSM.TypologyDetachedCriteria(createCriteria("ORM_Typologies"));
	}
	
	public PSM.OccupationDetachedCriteria createAllowedOccupationsCriteria() {
		return new PSM.OccupationDetachedCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public PSM.PropertyTypeDetachedCriteria createTypesCriteria() {
		return new PSM.PropertyTypeDetachedCriteria(createCriteria("ORM_Types"));
	}
	
	public Notification uniqueNotification(PersistentSession session) {
		return (Notification) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notification[] listNotification(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notification[]) list.toArray(new Notification[list.size()]);
	}
}

