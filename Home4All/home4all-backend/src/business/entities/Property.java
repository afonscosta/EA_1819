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
package business.entities;

import data.ORMConstants;
import org.hibernate.annotations.Formula;

public class Property {
	public Property() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PROPERTY_COMMENTS) {
			return ORM_comments;
		}
		else if (key == ORMConstants.KEY_PROPERTY_PHOTOS) {
			return ORM_photos;
		}
		else if (key == ORMConstants.KEY_PROPERTY_EXPENSESINCLUDED) {
			return ORM_expensesIncluded;
		}
		else if (key == ORMConstants.KEY_PROPERTY_ALLOWEDOCCUPATIONS) {
			return ORM_allowedOccupations;
		}
		else if (key == ORMConstants.KEY_PROPERTY_EQUIPMENTINCLUDED) {
			return ORM_equipmentIncluded;
		}
		else if (key == ORMConstants.KEY_PROPERTY_COMPLAINTS) {
			return ORM_complaints;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PROPERTY_OWNER) {
			this.owner = (Common) owner;
		}
		
		else if (key == ORMConstants.KEY_PROPERTY_TYPOLOGY) {
			this.typology = (Typology) owner;
		}
		
		else if (key == ORMConstants.KEY_PROPERTY_ALLOWEDGENDERS) {
			this.allowedGenders = (Gender) owner;
		}
		
		else if (key == ORMConstants.KEY_PROPERTY_ADDRESS) {
			this.address = (Address) owner;
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
	
	private Address address;
	
	private Gender allowedGenders;
	
	private Typology typology;
	
	private Common owner;
	
	private String name;
	
	private String description;
	
	private float area;
	
	private Integer allowedMinAge;
	
	private Integer allowedMaxAge;
	
	private boolean allowedSmoker;
	
	private boolean allowedPets;
	
	private java.util.Date publishDate;
	
	private boolean blocked;
	
	private java.util.Set ORM_comments = new java.util.HashSet();
	
	private java.util.Set ORM_photos = new java.util.HashSet();
	
	private java.util.Set ORM_expensesIncluded = new java.util.HashSet();
	
	private java.util.Set ORM_allowedOccupations = new java.util.HashSet();
	
	private java.util.Set ORM_equipmentIncluded = new java.util.HashSet();
	
	private java.util.Set ORM_complaints = new java.util.HashSet();

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
	
	public void setAllowedMinAge(Integer value) {
		this.allowedMinAge = value;
	}
	
	public Integer getAllowedMinAge() {
		return allowedMinAge;
	}
	
	public void setAllowedMaxAge(Integer value) {
		this.allowedMaxAge = value;
	}
	
	public Integer getAllowedMaxAge() {
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
	
	public void setBlocked(boolean value) {
		this.blocked = value;
	}
	
	public boolean getBlocked() {
		return blocked;
	}
	
	public void setOwner(Common value) {
		if (owner != null) {
			owner.properties.remove(this);
		}
		if (value != null) {
			value.properties.add(this);
		}
	}
	
	public Common getOwner() {
		return owner;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Owner(Common value) {
		this.owner = value;
	}
	
	private Common getORM_Owner() {
		return owner;
	}
	
	private void setORM_Comments(java.util.Set value) {
		this.ORM_comments = value;
	}
	
	private java.util.Set getORM_Comments() {
		return ORM_comments;
	}
	
	public final CommentSetCollection comments = new CommentSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPERTY_COMMENTS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Photos(java.util.Set value) {
		this.ORM_photos = value;
	}
	
	private java.util.Set getORM_Photos() {
		return ORM_photos;
	}
	
	public final PhotoSetCollection photos = new PhotoSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPERTY_PHOTOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ExpensesIncluded(java.util.Set value) {
		this.ORM_expensesIncluded = value;
	}
	
	private java.util.Set getORM_ExpensesIncluded() {
		return ORM_expensesIncluded;
	}
	
	public final ExpensesSetCollection expensesIncluded = new ExpensesSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPERTY_EXPENSESINCLUDED, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setTypology(Typology value) {
		this.typology = value;
	}
	
	public Typology getTypology() {
		return typology;
	}
	
	private void setORM_AllowedOccupations(java.util.Set value) {
		this.ORM_allowedOccupations = value;
	}
	
	private java.util.Set getORM_AllowedOccupations() {
		return ORM_allowedOccupations;
	}
	
	public final OccupationSetCollection allowedOccupations = new OccupationSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPERTY_ALLOWEDOCCUPATIONS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_EquipmentIncluded(java.util.Set value) {
		this.ORM_equipmentIncluded = value;
	}
	
	private java.util.Set getORM_EquipmentIncluded() {
		return ORM_equipmentIncluded;
	}
	
	public final EquipmentSetCollection equipmentIncluded = new EquipmentSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPERTY_EQUIPMENTINCLUDED, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setAllowedGenders(Gender value) {
		this.allowedGenders = value;
	}
	
	public Gender getAllowedGenders() {
		return allowedGenders;
	}
	
	public void setAddress(Address value) {
		this.address = value;
	}
	
	public Address getAddress() {
		return address;
	}
	
	private void setORM_Complaints(java.util.Set value) {
		this.ORM_complaints = value;
	}
	
	private java.util.Set getORM_Complaints() {
		return ORM_complaints;
	}
	
	public final ComplaintSetCollection complaints = new ComplaintSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPERTY_COMPLAINTS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}

}
