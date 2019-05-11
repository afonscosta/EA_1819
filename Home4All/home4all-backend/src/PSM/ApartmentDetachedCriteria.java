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

public class ApartmentDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public ApartmentDetachedCriteria() {
		super(PSM.Apartment.class, PSM.ApartmentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ownerId = new IntegerExpression("owner.ID", this.getDetachedCriteria());
		owner = new AssociationExpression("owner", this.getDetachedCriteria());
		typologyId = new IntegerExpression("typology.ID", this.getDetachedCriteria());
		typology = new AssociationExpression("typology", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		area = new FloatExpression("area", this.getDetachedCriteria());
		district = new StringExpression("district", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		street = new StringExpression("street", this.getDetachedCriteria());
		allowedMinAge = new IntegerExpression("allowedMinAge", this.getDetachedCriteria());
		allowedMaxAge = new IntegerExpression("allowedMaxAge", this.getDetachedCriteria());
		allowedSmoker = new BooleanExpression("allowedSmoker", this.getDetachedCriteria());
		allowedPets = new BooleanExpression("allowedPets", this.getDetachedCriteria());
		publishDate = new DateExpression("publishDate", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		incomeIncluded = new CollectionExpression("ORM_IncomeIncluded", this.getDetachedCriteria());
		allowedGenders = new CollectionExpression("ORM_AllowedGenders", this.getDetachedCriteria());
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this.getDetachedCriteria());
		equipmentIncluded = new CollectionExpression("ORM_EquipmentIncluded", this.getDetachedCriteria());
		furnished = new BooleanExpression("furnished", this.getDetachedCriteria());
		availability = new DateExpression("availability", this.getDetachedCriteria());
		sellPrice = new FloatExpression("sellPrice", this.getDetachedCriteria());
		rentPrice = new FloatExpression("rentPrice", this.getDetachedCriteria());
		sold = new BooleanExpression("sold", this.getDetachedCriteria());
	}
	
	public ApartmentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.ApartmentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ownerId = new IntegerExpression("owner.ID", this.getDetachedCriteria());
		owner = new AssociationExpression("owner", this.getDetachedCriteria());
		typologyId = new IntegerExpression("typology.ID", this.getDetachedCriteria());
		typology = new AssociationExpression("typology", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		area = new FloatExpression("area", this.getDetachedCriteria());
		district = new StringExpression("district", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		street = new StringExpression("street", this.getDetachedCriteria());
		allowedMinAge = new IntegerExpression("allowedMinAge", this.getDetachedCriteria());
		allowedMaxAge = new IntegerExpression("allowedMaxAge", this.getDetachedCriteria());
		allowedSmoker = new BooleanExpression("allowedSmoker", this.getDetachedCriteria());
		allowedPets = new BooleanExpression("allowedPets", this.getDetachedCriteria());
		publishDate = new DateExpression("publishDate", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		incomeIncluded = new CollectionExpression("ORM_IncomeIncluded", this.getDetachedCriteria());
		allowedGenders = new CollectionExpression("ORM_AllowedGenders", this.getDetachedCriteria());
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this.getDetachedCriteria());
		equipmentIncluded = new CollectionExpression("ORM_EquipmentIncluded", this.getDetachedCriteria());
		furnished = new BooleanExpression("furnished", this.getDetachedCriteria());
		availability = new DateExpression("availability", this.getDetachedCriteria());
		sellPrice = new FloatExpression("sellPrice", this.getDetachedCriteria());
		rentPrice = new FloatExpression("rentPrice", this.getDetachedCriteria());
		sold = new BooleanExpression("sold", this.getDetachedCriteria());
	}
	
	public CommonDetachedCriteria createOwnerCriteria() {
		return new CommonDetachedCriteria(createCriteria("owner"));
	}
	
	public TypologyDetachedCriteria createTypologyCriteria() {
		return new TypologyDetachedCriteria(createCriteria("typology"));
	}
	
	public PSM.CommentDetachedCriteria createCommentsCriteria() {
		return new PSM.CommentDetachedCriteria(createCriteria("ORM_Comments"));
	}
	
	public PSM.ExpensesDetachedCriteria createIncomeIncludedCriteria() {
		return new PSM.ExpensesDetachedCriteria(createCriteria("ORM_IncomeIncluded"));
	}
	
	public PSM.GenderDetachedCriteria createAllowedGendersCriteria() {
		return new PSM.GenderDetachedCriteria(createCriteria("ORM_AllowedGenders"));
	}
	
	public PSM.OccupationDetachedCriteria createAllowedOccupationsCriteria() {
		return new PSM.OccupationDetachedCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public PSM.EquipmentDetachedCriteria createEquipmentIncludedCriteria() {
		return new PSM.EquipmentDetachedCriteria(createCriteria("ORM_EquipmentIncluded"));
	}
	
	public Apartment uniqueApartment(PersistentSession session) {
		return (Apartment) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Apartment[] listApartment(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Apartment[]) list.toArray(new Apartment[list.size()]);
	}
}

