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

import business.entities.Notification;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression ordinationId;
	public final AssociationExpression ordination;
	public final StringExpression name;
	public final StringExpression district;
	public final StringExpression city;
	public final StringExpression completeAddress;
	public final FloatExpression minSellPrice;
	public final FloatExpression maxSellPrice;
	public final FloatExpression minRentPrice;
	public final FloatExpression maxRentPrice;
	public final IntegerExpression singleRooms;
	public final IntegerExpression doubleRooms;
	public final BooleanExpression privateWC;
	public final BooleanExpression allowedSmokers;
	public final BooleanExpression allowedPets;
	public final BooleanExpression furnished;
	public final BooleanExpression totalAccess;
	public final CollectionExpression newProperties;
	public final CollectionExpression allowedOccupations;
	public final CollectionExpression typologies;
	public final CollectionExpression propertyTypes;
	public final CollectionExpression multipleRoom;
	
	public NotificationCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		ordinationId = new StringExpression("ordination.name", this);
		ordination = new AssociationExpression("ordination", this);
		name = new StringExpression("name", this);
		district = new StringExpression("district", this);
		city = new StringExpression("city", this);
		completeAddress = new StringExpression("completeAddress", this);
		minSellPrice = new FloatExpression("minSellPrice", this);
		maxSellPrice = new FloatExpression("maxSellPrice", this);
		minRentPrice = new FloatExpression("minRentPrice", this);
		maxRentPrice = new FloatExpression("maxRentPrice", this);
		singleRooms = new IntegerExpression("singleRooms", this);
		doubleRooms = new IntegerExpression("doubleRooms", this);
		privateWC = new BooleanExpression("privateWC", this);
		allowedSmokers = new BooleanExpression("allowedSmokers", this);
		allowedPets = new BooleanExpression("allowedPets", this);
		furnished = new BooleanExpression("furnished", this);
		totalAccess = new BooleanExpression("totalAccess", this);
		newProperties = new CollectionExpression("ORM_NewProperties", this);
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this);
		typologies = new CollectionExpression("ORM_Typologies", this);
		propertyTypes = new CollectionExpression("ORM_PropertyTypes", this);
		multipleRoom = new CollectionExpression("ORM_MultipleRoom", this);
	}
	
	public NotificationCriteria(PersistentSession session) {
		this(session.createCriteria(Notification.class));
	}
	
	public NotificationCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public OrdinationCriteria createOrdinationCriteria() {
		return new OrdinationCriteria(createCriteria("ordination"));
	}
	
	public PropertyCriteria createNewPropertiesCriteria() {
		return new PropertyCriteria(createCriteria("ORM_NewProperties"));
	}
	
	public OccupationCriteria createAllowedOccupationsCriteria() {
		return new OccupationCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public TypologyCriteria createTypologiesCriteria() {
		return new TypologyCriteria(createCriteria("ORM_Typologies"));
	}
	
	public PropertyTypeCriteria createPropertyTypesCriteria() {
		return new PropertyTypeCriteria(createCriteria("ORM_PropertyTypes"));
	}
	
	public MultipleRoomCriteria createMultipleRoomCriteria() {
		return new MultipleRoomCriteria(createCriteria("ORM_MultipleRoom"));
	}
	
	public Notification uniqueNotification() {
		return (Notification) super.uniqueResult();
	}
	
	public Notification[] listNotification() {
		java.util.List list = super.list();
		return (Notification[]) list.toArray(new Notification[list.size()]);
	}
}

