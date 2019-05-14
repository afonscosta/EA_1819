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

public class Bedroom {
	public Bedroom() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == data.ORMConstants.KEY_BEDROOM_PHOTOS) {
			return ORM_photos;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == data.ORMConstants.KEY_BEDROOM_BEDROOMTYPE) {
			this.bedroomType = (BedroomType) owner;
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
	
	private BedroomType bedroomType;
	
	private boolean furnished;
	
	private int peopleAmount;
	
	private float area;
	
	private boolean privateBathroom;
	
	private java.util.Date availability;
	
	private float rentPrice;
	
	private boolean sold;
	
	private java.util.Set ORM_photos = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setFurnished(boolean value) {
		this.furnished = value;
	}
	
	public boolean getFurnished() {
		return furnished;
	}
	
	public void setPeopleAmount(int value) {
		this.peopleAmount = value;
	}
	
	public int getPeopleAmount() {
		return peopleAmount;
	}
	
	public void setArea(float value) {
		this.area = value;
	}
	
	public float getArea() {
		return area;
	}
	
	public void setPrivateBathroom(boolean value) {
		this.privateBathroom = value;
	}
	
	public boolean getPrivateBathroom() {
		return privateBathroom;
	}
	
	public void setAvailability(java.util.Date value) {
		this.availability = value;
	}
	
	public java.util.Date getAvailability() {
		return availability;
	}
	
	public void setRentPrice(float value) {
		this.rentPrice = value;
	}
	
	public float getRentPrice() {
		return rentPrice;
	}
	
	public void setSold(boolean value) {
		this.sold = value;
	}
	
	public boolean getSold() {
		return sold;
	}
	
	private void setORM_Photos(java.util.Set value) {
		this.ORM_photos = value;
	}
	
	private java.util.Set getORM_Photos() {
		return ORM_photos;
	}
	
	public final PhotoSetCollection photos = new PhotoSetCollection(this, _ormAdapter, data.ORMConstants.KEY_BEDROOM_PHOTOS, data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setBedroomType(BedroomType value) {
		this.bedroomType = value;
	}
	
	public BedroomType getBedroomType() {
		return bedroomType;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
