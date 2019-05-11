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

public class PrivateCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression ownerId;
	public final AssociationExpression owner;
	public final IntegerExpression typologyId;
	public final AssociationExpression typology;
	public final StringExpression name;
	public final StringExpression description;
	public final FloatExpression area;
	public final StringExpression district;
	public final StringExpression city;
	public final StringExpression street;
	public final IntegerExpression allowedMinAge;
	public final IntegerExpression allowedMaxAge;
	public final BooleanExpression allowedSmoker;
	public final BooleanExpression allowedPets;
	public final DateExpression publishDate;
	public final CollectionExpression comments;
	public final CollectionExpression incomeIncluded;
	public final CollectionExpression allowedGenders;
	public final CollectionExpression allowedOccupations;
	public final CollectionExpression equipmentIncluded;
	public final BooleanExpression furnished;
	public final DateExpression availability;
	public final FloatExpression sellPrice;
	public final FloatExpression rentPrice;
	public final BooleanExpression sold;
	
	public PrivateCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		ownerId = new IntegerExpression("owner.ID", this);
		owner = new AssociationExpression("owner", this);
		typologyId = new IntegerExpression("typology.ID", this);
		typology = new AssociationExpression("typology", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
		area = new FloatExpression("area", this);
		district = new StringExpression("district", this);
		city = new StringExpression("city", this);
		street = new StringExpression("street", this);
		allowedMinAge = new IntegerExpression("allowedMinAge", this);
		allowedMaxAge = new IntegerExpression("allowedMaxAge", this);
		allowedSmoker = new BooleanExpression("allowedSmoker", this);
		allowedPets = new BooleanExpression("allowedPets", this);
		publishDate = new DateExpression("publishDate", this);
		comments = new CollectionExpression("ORM_Comments", this);
		incomeIncluded = new CollectionExpression("ORM_IncomeIncluded", this);
		allowedGenders = new CollectionExpression("ORM_AllowedGenders", this);
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this);
		equipmentIncluded = new CollectionExpression("ORM_EquipmentIncluded", this);
		furnished = new BooleanExpression("furnished", this);
		availability = new DateExpression("availability", this);
		sellPrice = new FloatExpression("sellPrice", this);
		rentPrice = new FloatExpression("rentPrice", this);
		sold = new BooleanExpression("sold", this);
	}
	
	public PrivateCriteria(PersistentSession session) {
		this(session.createCriteria(Private.class));
	}
	
	public PrivateCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public CommonCriteria createOwnerCriteria() {
		return new CommonCriteria(createCriteria("owner"));
	}
	
	public TypologyCriteria createTypologyCriteria() {
		return new TypologyCriteria(createCriteria("typology"));
	}
	
	public PSM.CommentCriteria createCommentsCriteria() {
		return new PSM.CommentCriteria(createCriteria("ORM_Comments"));
	}
	
	public PSM.ExpensesCriteria createIncomeIncludedCriteria() {
		return new PSM.ExpensesCriteria(createCriteria("ORM_IncomeIncluded"));
	}
	
	public PSM.GenderCriteria createAllowedGendersCriteria() {
		return new PSM.GenderCriteria(createCriteria("ORM_AllowedGenders"));
	}
	
	public PSM.OccupationCriteria createAllowedOccupationsCriteria() {
		return new PSM.OccupationCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public PSM.EquipmentCriteria createEquipmentIncludedCriteria() {
		return new PSM.EquipmentCriteria(createCriteria("ORM_EquipmentIncluded"));
	}
	
	public Private uniquePrivate() {
		return (Private) super.uniqueResult();
	}
	
	public Private[] listPrivate() {
		java.util.List list = super.list();
		return (Private[]) list.toArray(new Private[list.size()]);
	}
}

