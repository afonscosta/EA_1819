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

public class SharedCriteria extends AbstractORMCriteria {
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
	public final IntegerExpression females;
	public final IntegerExpression males;
	public final IntegerExpression smokers;
	public final IntegerExpression pets;
	public final BooleanExpression totalAccess;
	public final CollectionExpression bedrooms;
	public final CollectionExpression occupations;
	
	public SharedCriteria(Criteria criteria) {
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
		females = new IntegerExpression("females", this);
		males = new IntegerExpression("males", this);
		smokers = new IntegerExpression("smokers", this);
		pets = new IntegerExpression("pets", this);
		totalAccess = new BooleanExpression("totalAccess", this);
		bedrooms = new CollectionExpression("ORM_Bedrooms", this);
		occupations = new CollectionExpression("ORM_Occupations", this);
	}
	
	public SharedCriteria(PersistentSession session) {
		this(session.createCriteria(Shared.class));
	}
	
	public SharedCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public PSM.BedroomCriteria createBedroomsCriteria() {
		return new PSM.BedroomCriteria(createCriteria("ORM_Bedrooms"));
	}
	
	public PSM.OccupationCriteria createOccupationsCriteria() {
		return new PSM.OccupationCriteria(createCriteria("ORM_Occupations"));
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
	
	public Shared uniqueShared() {
		return (Shared) super.uniqueResult();
	}
	
	public Shared[] listShared() {
		java.util.List list = super.list();
		return (Shared[]) list.toArray(new Shared[list.size()]);
	}
}

