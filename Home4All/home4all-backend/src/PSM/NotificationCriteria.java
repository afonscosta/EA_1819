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

public class NotificationCriteria extends AbstractORMCriteria {
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
	
	public NotificationCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		ordinationId = new IntegerExpression("ordination.ID", this);
		ordination = new AssociationExpression("ordination", this);
		name = new StringExpression("name", this);
		district = new StringExpression("district", this);
		city = new StringExpression("city", this);
		street = new StringExpression("street", this);
		minSellPrice = new FloatExpression("minSellPrice", this);
		maxSellPrice = new FloatExpression("maxSellPrice", this);
		minRentPrice = new FloatExpression("minRentPrice", this);
		maxRentPrice = new FloatExpression("maxRentPrice", this);
		peopleAmount = new IntegerExpression("peopleAmount", this);
		singleRooms = new IntegerExpression("singleRooms", this);
		doubleRooms = new IntegerExpression("doubleRooms", this);
		privateWC = new BooleanExpression("privateWC", this);
		allowedSmokers = new BooleanExpression("allowedSmokers", this);
		allowedPets = new BooleanExpression("allowedPets", this);
		furnished = new BooleanExpression("furnished", this);
		totalAccess = new BooleanExpression("totalAccess", this);
		newProperties = new CollectionExpression("ORM_NewProperties", this);
		typologies = new CollectionExpression("ORM_Typologies", this);
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this);
		types = new CollectionExpression("ORM_Types", this);
	}
	
	public NotificationCriteria(PersistentSession session) {
		this(session.createCriteria(Notification.class));
	}
	
	public NotificationCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public OrdinationCriteria createOrdinationCriteria() {
		return new OrdinationCriteria(createCriteria("ordination"));
	}
	
	public PSM.PropertyCriteria createNewPropertiesCriteria() {
		return new PSM.PropertyCriteria(createCriteria("ORM_NewProperties"));
	}
	
	public PSM.TypologyCriteria createTypologiesCriteria() {
		return new PSM.TypologyCriteria(createCriteria("ORM_Typologies"));
	}
	
	public PSM.OccupationCriteria createAllowedOccupationsCriteria() {
		return new PSM.OccupationCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public PSM.PropertyTypeCriteria createTypesCriteria() {
		return new PSM.PropertyTypeCriteria(createCriteria("ORM_Types"));
	}
	
	public Notification uniqueNotification() {
		return (Notification) super.uniqueResult();
	}
	
	public Notification[] listNotification() {
		java.util.List list = super.list();
		return (Notification[]) list.toArray(new Notification[list.size()]);
	}
}

