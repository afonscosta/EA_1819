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

public class Property {
	public Property() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == PSM.ORMConstants.KEY_PROPERTY_COMMENTS) {
			return ORM_comments;
		}
		else if (key == PSM.ORMConstants.KEY_PROPERTY_INCOMEINCLUDED) {
			return ORM_incomeIncluded;
		}
		else if (key == PSM.ORMConstants.KEY_PROPERTY_ALLOWEDGENDERS) {
			return ORM_allowedGenders;
		}
		else if (key == PSM.ORMConstants.KEY_PROPERTY_ALLOWEDOCCUPATIONS) {
			return ORM_allowedOccupations;
		}
		else if (key == PSM.ORMConstants.KEY_PROPERTY_EQUIPMENTINCLUDED) {
			return ORM_equipmentIncluded;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == PSM.ORMConstants.KEY_PROPERTY_OWNER) {
			this.owner = (PSM.Common) owner;
		}
		
		else if (key == PSM.ORMConstants.KEY_PROPERTY_TYPOLOGY) {
			this.typology = (PSM.Typology) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private PSM.Common owner;
	
	private PSM.Typology typology;
	
	private String name;
	
	private String description;
	
	private float area;
	
	private String district;
	
	private String city;
	
	private String street;
	
	private int allowedMinAge;
	
	private int allowedMaxAge;
	
	private boolean allowedSmoker;
	
	private boolean allowedPets;
	
	private java.util.Date publishDate;
	
	private java.util.Set ORM_comments = new java.util.HashSet();
	
	private java.util.Set ORM_incomeIncluded = new java.util.HashSet();
	
	private java.util.Set ORM_allowedGenders = new java.util.HashSet();
	
	private java.util.Set ORM_allowedOccupations = new java.util.HashSet();
	
	private java.util.Set ORM_equipmentIncluded = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setArea(float value) {
		this.area = value;
	}
	
	public float getArea() {
		return area;
	}
	
	public void setDistrict(String value) {
		this.district = value;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setCity(String value) {
		this.city = value;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setStreet(String value) {
		this.street = value;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setAllowedMinAge(int value) {
		this.allowedMinAge = value;
	}
	
	public int getAllowedMinAge() {
		return allowedMinAge;
	}
	
	public void setAllowedMaxAge(int value) {
		this.allowedMaxAge = value;
	}
	
	public int getAllowedMaxAge() {
		return allowedMaxAge;
	}
	
	public void setAllowedSmoker(boolean value) {
		this.allowedSmoker = value;
	}
	
	public boolean getAllowedSmoker() {
		return allowedSmoker;
	}
	
	public void setAllowedPets(boolean value) {
		this.allowedPets = value;
	}
	
	public boolean getAllowedPets() {
		return allowedPets;
	}
	
	public void setPublishDate(java.util.Date value) {
		this.publishDate = value;
	}
	
	public java.util.Date getPublishDate() {
		return publishDate;
	}
	
	public void setOwner(PSM.Common value) {
		if (owner != null) {
			owner.properties.remove(this);
		}
		if (value != null) {
			value.properties.add(this);
		}
	}
	
	public PSM.Common getOwner() {
		return owner;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Owner(PSM.Common value) {
		this.owner = value;
	}
	
	private PSM.Common getORM_Owner() {
		return owner;
	}
	
	private void setORM_Comments(java.util.Set value) {
		this.ORM_comments = value;
	}
	
	private java.util.Set getORM_Comments() {
		return ORM_comments;
	}
	
	public final PSM.CommentSetCollection comments = new PSM.CommentSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_PROPERTY_COMMENTS, PSM.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setTypology(PSM.Typology value) {
		this.typology = value;
	}
	
	public PSM.Typology getTypology() {
		return typology;
	}
	
	private void setORM_IncomeIncluded(java.util.Set value) {
		this.ORM_incomeIncluded = value;
	}
	
	private java.util.Set getORM_IncomeIncluded() {
		return ORM_incomeIncluded;
	}
	
	public final PSM.ExpensesSetCollection incomeIncluded = new PSM.ExpensesSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_PROPERTY_INCOMEINCLUDED, PSM.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_AllowedGenders(java.util.Set value) {
		this.ORM_allowedGenders = value;
	}
	
	private java.util.Set getORM_AllowedGenders() {
		return ORM_allowedGenders;
	}
	
	public final PSM.GenderSetCollection allowedGenders = new PSM.GenderSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_PROPERTY_ALLOWEDGENDERS, PSM.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_AllowedOccupations(java.util.Set value) {
		this.ORM_allowedOccupations = value;
	}
	
	private java.util.Set getORM_AllowedOccupations() {
		return ORM_allowedOccupations;
	}
	
	public final PSM.OccupationSetCollection allowedOccupations = new PSM.OccupationSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_PROPERTY_ALLOWEDOCCUPATIONS, PSM.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_EquipmentIncluded(java.util.Set value) {
		this.ORM_equipmentIncluded = value;
	}
	
	private java.util.Set getORM_EquipmentIncluded() {
		return ORM_equipmentIncluded;
	}
	
	public final PSM.EquipmentSetCollection equipmentIncluded = new PSM.EquipmentSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_PROPERTY_EQUIPMENTINCLUDED, PSM.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
