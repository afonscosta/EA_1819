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

import business.entities.Shared;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class SharedDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression addressId;
	public final AssociationExpression address;
	public final StringExpression allowedGendersId;
	public final AssociationExpression allowedGenders;
	public final StringExpression typologyId;
	public final AssociationExpression typology;
	public final IntegerExpression ownerId;
	public final AssociationExpression owner;
	public final StringExpression name;
	public final StringExpression description;
	public final FloatExpression area;
	public final IntegerExpression allowedMinAge;
	public final IntegerExpression allowedMaxAge;
	public final BooleanExpression allowedSmoker;
	public final BooleanExpression allowedPets;
	public final DateExpression publishDate;
	public final BooleanExpression blocked;
	public final CollectionExpression comments;
	public final CollectionExpression photos;
	public final CollectionExpression expensesIncluded;
	public final CollectionExpression allowedOccupations;
	public final CollectionExpression equipmentIncluded;
	public final CollectionExpression complaints;
	public final IntegerExpression females;
	public final IntegerExpression males;
	public final IntegerExpression smokers;
	public final IntegerExpression petsQuantity;
	public final BooleanExpression totalAccess;
	public final CollectionExpression bedrooms;
	public final CollectionExpression pets;
	public final CollectionExpression occupations;
	
	public SharedDetachedCriteria() {
		super(Shared.class, SharedCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		addressId = new IntegerExpression("address.ID", this.getDetachedCriteria());
		address = new AssociationExpression("address", this.getDetachedCriteria());
		allowedGendersId = new StringExpression("allowedGenders.name", this.getDetachedCriteria());
		allowedGenders = new AssociationExpression("allowedGenders", this.getDetachedCriteria());
		typologyId = new StringExpression("typology.name", this.getDetachedCriteria());
		typology = new AssociationExpression("typology", this.getDetachedCriteria());
		ownerId = new IntegerExpression("owner.ID", this.getDetachedCriteria());
		owner = new AssociationExpression("owner", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		area = new FloatExpression("area", this.getDetachedCriteria());
		allowedMinAge = new IntegerExpression("allowedMinAge", this.getDetachedCriteria());
		allowedMaxAge = new IntegerExpression("allowedMaxAge", this.getDetachedCriteria());
		allowedSmoker = new BooleanExpression("allowedSmoker", this.getDetachedCriteria());
		allowedPets = new BooleanExpression("allowedPets", this.getDetachedCriteria());
		publishDate = new DateExpression("publishDate", this.getDetachedCriteria());
		blocked = new BooleanExpression("blocked", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		photos = new CollectionExpression("ORM_Photos", this.getDetachedCriteria());
		expensesIncluded = new CollectionExpression("ORM_ExpensesIncluded", this.getDetachedCriteria());
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this.getDetachedCriteria());
		equipmentIncluded = new CollectionExpression("ORM_EquipmentIncluded", this.getDetachedCriteria());
		complaints = new CollectionExpression("ORM_Complaints", this.getDetachedCriteria());
		females = new IntegerExpression("females", this.getDetachedCriteria());
		males = new IntegerExpression("males", this.getDetachedCriteria());
		smokers = new IntegerExpression("smokers", this.getDetachedCriteria());
		petsQuantity = new IntegerExpression("petsQuantity", this.getDetachedCriteria());
		totalAccess = new BooleanExpression("totalAccess", this.getDetachedCriteria());
		bedrooms = new CollectionExpression("ORM_Bedrooms", this.getDetachedCriteria());
		pets = new CollectionExpression("ORM_Pets", this.getDetachedCriteria());
		occupations = new CollectionExpression("ORM_Occupations", this.getDetachedCriteria());
	}
	
	public SharedDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, SharedCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		addressId = new IntegerExpression("address.ID", this.getDetachedCriteria());
		address = new AssociationExpression("address", this.getDetachedCriteria());
		allowedGendersId = new StringExpression("allowedGenders.name", this.getDetachedCriteria());
		allowedGenders = new AssociationExpression("allowedGenders", this.getDetachedCriteria());
		typologyId = new StringExpression("typology.name", this.getDetachedCriteria());
		typology = new AssociationExpression("typology", this.getDetachedCriteria());
		ownerId = new IntegerExpression("owner.ID", this.getDetachedCriteria());
		owner = new AssociationExpression("owner", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		area = new FloatExpression("area", this.getDetachedCriteria());
		allowedMinAge = new IntegerExpression("allowedMinAge", this.getDetachedCriteria());
		allowedMaxAge = new IntegerExpression("allowedMaxAge", this.getDetachedCriteria());
		allowedSmoker = new BooleanExpression("allowedSmoker", this.getDetachedCriteria());
		allowedPets = new BooleanExpression("allowedPets", this.getDetachedCriteria());
		publishDate = new DateExpression("publishDate", this.getDetachedCriteria());
		blocked = new BooleanExpression("blocked", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		photos = new CollectionExpression("ORM_Photos", this.getDetachedCriteria());
		expensesIncluded = new CollectionExpression("ORM_ExpensesIncluded", this.getDetachedCriteria());
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this.getDetachedCriteria());
		equipmentIncluded = new CollectionExpression("ORM_EquipmentIncluded", this.getDetachedCriteria());
		complaints = new CollectionExpression("ORM_Complaints", this.getDetachedCriteria());
		females = new IntegerExpression("females", this.getDetachedCriteria());
		males = new IntegerExpression("males", this.getDetachedCriteria());
		smokers = new IntegerExpression("smokers", this.getDetachedCriteria());
		petsQuantity = new IntegerExpression("petsQuantity", this.getDetachedCriteria());
		totalAccess = new BooleanExpression("totalAccess", this.getDetachedCriteria());
		bedrooms = new CollectionExpression("ORM_Bedrooms", this.getDetachedCriteria());
		pets = new CollectionExpression("ORM_Pets", this.getDetachedCriteria());
		occupations = new CollectionExpression("ORM_Occupations", this.getDetachedCriteria());
	}
	
	public BedroomDetachedCriteria createBedroomsCriteria() {
		return new BedroomDetachedCriteria(createCriteria("ORM_Bedrooms"));
	}
	
	public PetDetachedCriteria createPetsCriteria() {
		return new PetDetachedCriteria(createCriteria("ORM_Pets"));
	}
	
	public OccupationDetachedCriteria createOccupationsCriteria() {
		return new OccupationDetachedCriteria(createCriteria("ORM_Occupations"));
	}
	
	public AddressDetachedCriteria createAddressCriteria() {
		return new AddressDetachedCriteria(createCriteria("address"));
	}
	
	public GenderDetachedCriteria createAllowedGendersCriteria() {
		return new GenderDetachedCriteria(createCriteria("allowedGenders"));
	}
	
	public TypologyDetachedCriteria createTypologyCriteria() {
		return new TypologyDetachedCriteria(createCriteria("typology"));
	}
	
	public CommonDetachedCriteria createOwnerCriteria() {
		return new CommonDetachedCriteria(createCriteria("owner"));
	}
	
	public CommentDetachedCriteria createCommentsCriteria() {
		return new CommentDetachedCriteria(createCriteria("ORM_Comments"));
	}
	
	public PhotoDetachedCriteria createPhotosCriteria() {
		return new PhotoDetachedCriteria(createCriteria("ORM_Photos"));
	}
	
	public ExpensesDetachedCriteria createExpensesIncludedCriteria() {
		return new ExpensesDetachedCriteria(createCriteria("ORM_ExpensesIncluded"));
	}
	
	public OccupationDetachedCriteria createAllowedOccupationsCriteria() {
		return new OccupationDetachedCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public EquipmentDetachedCriteria createEquipmentIncludedCriteria() {
		return new EquipmentDetachedCriteria(createCriteria("ORM_EquipmentIncluded"));
	}
	
	public ComplaintDetachedCriteria createComplaintsCriteria() {
		return new ComplaintDetachedCriteria(createCriteria("ORM_Complaints"));
	}
	
	public Shared uniqueShared(PersistentSession session) {
		return (Shared) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Shared[] listShared(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Shared[]) list.toArray(new Shared[list.size()]);
	}
}

