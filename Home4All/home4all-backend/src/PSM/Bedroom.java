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

public class Bedroom {
	public Bedroom() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == PSM.ORMConstants.KEY_BEDROOM_TYPE) {
			this.type = (PSM.BedroomType) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private PSM.BedroomType type;
	
	private int peopleAmount;
	
	private float area;
	
	private boolean furnished;
	
	private boolean privateBathroom;
	
	private java.util.Date availability;
	
	private float rentPrice;
	
	private boolean sold;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
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
	
	public void setFurnished(boolean value) {
		this.furnished = value;
	}
	
	public boolean getFurnished() {
		return furnished;
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
	
	public void setType(PSM.BedroomType value) {
		this.type = value;
	}
	
	public PSM.BedroomType getType() {
		return type;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
