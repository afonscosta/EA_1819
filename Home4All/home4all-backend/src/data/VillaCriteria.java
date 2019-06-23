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

import business.entities.Villa;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class VillaCriteria extends AbstractORMCriteria {
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
	public final BooleanExpression furnished;
	public final DateExpression availability;
	public final FloatExpression sellPrice;
	public final FloatExpression rentPrice;
	public final BooleanExpression sold;
	
	public VillaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		addressId = new IntegerExpression("address.ID", this);
		address = new AssociationExpression("address", this);
		allowedGendersId = new StringExpression("allowedGenders.name", this);
		allowedGenders = new AssociationExpression("allowedGenders", this);
		typologyId = new StringExpression("typology.name", this);
		typology = new AssociationExpression("typology", this);
		ownerId = new IntegerExpression("owner.ID", this);
		owner = new AssociationExpression("owner", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
		area = new FloatExpression("area", this);
		allowedMinAge = new IntegerExpression("allowedMinAge", this);
		allowedMaxAge = new IntegerExpression("allowedMaxAge", this);
		allowedSmoker = new BooleanExpression("allowedSmoker", this);
		allowedPets = new BooleanExpression("allowedPets", this);
		publishDate = new DateExpression("publishDate", this);
		blocked = new BooleanExpression("blocked", this);
		comments = new CollectionExpression("ORM_Comments", this);
		photos = new CollectionExpression("ORM_Photos", this);
		expensesIncluded = new CollectionExpression("ORM_ExpensesIncluded", this);
		allowedOccupations = new CollectionExpression("ORM_AllowedOccupations", this);
		equipmentIncluded = new CollectionExpression("ORM_EquipmentIncluded", this);
		complaints = new CollectionExpression("ORM_Complaints", this);
		furnished = new BooleanExpression("furnished", this);
		availability = new DateExpression("availability", this);
		sellPrice = new FloatExpression("sellPrice", this);
		rentPrice = new FloatExpression("rentPrice", this);
		sold = new BooleanExpression("sold", this);
	}
	
	public VillaCriteria(PersistentSession session) {
		this(session.createCriteria(Villa.class));
	}
	
	public VillaCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public AddressCriteria createAddressCriteria() {
		return new AddressCriteria(createCriteria("address"));
	}
	
	public GenderCriteria createAllowedGendersCriteria() {
		return new GenderCriteria(createCriteria("allowedGenders"));
	}
	
	public TypologyCriteria createTypologyCriteria() {
		return new TypologyCriteria(createCriteria("typology"));
	}
	
	public CommonCriteria createOwnerCriteria() {
		return new CommonCriteria(createCriteria("owner"));
	}
	
	public CommentCriteria createCommentsCriteria() {
		return new CommentCriteria(createCriteria("ORM_Comments"));
	}
	
	public PhotoCriteria createPhotosCriteria() {
		return new PhotoCriteria(createCriteria("ORM_Photos"));
	}
	
	public ExpensesCriteria createExpensesIncludedCriteria() {
		return new ExpensesCriteria(createCriteria("ORM_ExpensesIncluded"));
	}
	
	public OccupationCriteria createAllowedOccupationsCriteria() {
		return new OccupationCriteria(createCriteria("ORM_AllowedOccupations"));
	}
	
	public EquipmentCriteria createEquipmentIncludedCriteria() {
		return new EquipmentCriteria(createCriteria("ORM_EquipmentIncluded"));
	}
	
	public ComplaintCriteria createComplaintsCriteria() {
		return new ComplaintCriteria(createCriteria("ORM_Complaints"));
	}
	
	public Villa uniqueVilla() {
		return (Villa) super.uniqueResult();
	}
	
	public Villa[] listVilla() {
		java.util.List list = super.list();
		return (Villa[]) list.toArray(new Villa[list.size()]);
	}
}

