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

public class Notification {
	public Notification() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_NOTIFICATION_NEWPROPERTIES) {
			return ORM_newProperties;
		}
		else if (key == ORMConstants.KEY_NOTIFICATION_MULTIPLEROOM) {
			return ORM_multipleRoom;
		}
		else if (key == ORMConstants.KEY_NOTIFICATION_TYPOLOGIES) {
			return ORM_typologies;
		}
		else if (key == ORMConstants.KEY_NOTIFICATION_ALLOWEDOCCUPATIONS) {
			return ORM_allowedOccupations;
		}
		else if (key == ORMConstants.KEY_NOTIFICATION_PROPERTYTYPES) {
			return ORM_propertyTypes;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_NOTIFICATION_ORDINATION) {
			this.ordination = (Ordination) owner;
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
	
	private Ordination ordination;
	
	private String name;
	
	private String district;
	
	private String city;
	
	private String completeAddress;
	
	private float minSellPrice;
	
	private float maxSellPrice;
	
	private float minRentPrice;
	
	private float maxRentPrice;
	
	private int peopleAmount;
	
	private int singleRooms;
	
	private int doubleRooms;
	
	private boolean privateWC;
	
	private boolean allowedSmokers;
	
	private boolean allowedPets;
	
	private boolean furnished;
	
	private boolean totalAccess;
	
	private java.util.Set ORM_newProperties = new java.util.HashSet();
	
	private java.util.Set ORM_multipleRoom = new java.util.HashSet();
	
	private java.util.Set ORM_typologies = new java.util.HashSet();
	
	private java.util.Set ORM_allowedOccupations = new java.util.HashSet();
	
	private java.util.Set ORM_propertyTypes = new java.util.HashSet();
	
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
	
	public void setCompleteAddress(String value) {
		this.completeAddress = value;
	}
	
	public String getCompleteAddress() {
		return completeAddress;
	}
	
	public void setMinSellPrice(float value) {
		this.minSellPrice = value;
	}
	
	public float getMinSellPrice() {
		return minSellPrice;
	}
	
	public void setMaxSellPrice(float value) {
		this.maxSellPrice = value;
	}
	
	public float getMaxSellPrice() {
		return maxSellPrice;
	}
	
	public void setMinRentPrice(float value) {
		this.minRentPrice = value;
	}
	
	public float getMinRentPrice() {
		return minRentPrice;
	}
	
	public void setMaxRentPrice(float value) {
		this.maxRentPrice = value;
	}
	
	public float getMaxRentPrice() {
		return maxRentPrice;
	}
	
	public void setPeopleAmount(int value) {
		this.peopleAmount = value;
	}
	
	public int getPeopleAmount() {
		return peopleAmount;
	}
	
	public void setSingleRooms(int value) {
		this.singleRooms = value;
	}
	
	public int getSingleRooms() {
		return singleRooms;
	}
	
	public void setDoubleRooms(int value) {
		this.doubleRooms = value;
	}
	
	public int getDoubleRooms() {
		return doubleRooms;
	}
	
	public void setPrivateWC(boolean value) {
		this.privateWC = value;
	}
	
	public boolean getPrivateWC() {
		return privateWC;
	}
	
	public void setAllowedSmokers(boolean value) {
		this.allowedSmokers = value;
	}
	
	public boolean getAllowedSmokers() {
		return allowedSmokers;
	}
	
	public void setAllowedPets(boolean value) {
		this.allowedPets = value;
	}
	
	public boolean getAllowedPets() {
		return allowedPets;
	}
	
	public void setFurnished(boolean value) {
		this.furnished = value;
	}
	
	public boolean getFurnished() {
		return furnished;
	}
	
	public void setTotalAccess(boolean value) {
		this.totalAccess = value;
	}
	
	public boolean getTotalAccess() {
		return totalAccess;
	}
	
	private void setORM_NewProperties(java.util.Set value) {
		this.ORM_newProperties = value;
	}
	
	private java.util.Set getORM_NewProperties() {
		return ORM_newProperties;
	}
	
	public final PropertySetCollection newProperties = new PropertySetCollection(this, _ormAdapter, ORMConstants.KEY_NOTIFICATION_NEWPROPERTIES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_MultipleRoom(java.util.Set value) {
		this.ORM_multipleRoom = value;
	}
	
	private java.util.Set getORM_MultipleRoom() {
		return ORM_multipleRoom;
	}
	
	public final MultipleRoomSetCollection multipleRoom = new MultipleRoomSetCollection(this, _ormAdapter, ORMConstants.KEY_NOTIFICATION_MULTIPLEROOM, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Typologies(java.util.Set value) {
		this.ORM_typologies = value;
	}
	
	private java.util.Set getORM_Typologies() {
		return ORM_typologies;
	}
	
	public final TypologySetCollection typologies = new TypologySetCollection(this, _ormAdapter, ORMConstants.KEY_NOTIFICATION_TYPOLOGIES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_AllowedOccupations(java.util.Set value) {
		this.ORM_allowedOccupations = value;
	}
	
	private java.util.Set getORM_AllowedOccupations() {
		return ORM_allowedOccupations;
	}
	
	public final OccupationSetCollection allowedOccupations = new OccupationSetCollection(this, _ormAdapter, ORMConstants.KEY_NOTIFICATION_ALLOWEDOCCUPATIONS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_PropertyTypes(java.util.Set value) {
		this.ORM_propertyTypes = value;
	}
	
	private java.util.Set getORM_PropertyTypes() {
		return ORM_propertyTypes;
	}
	
	public final PropertyTypeSetCollection propertyTypes = new PropertyTypeSetCollection(this, _ormAdapter, ORMConstants.KEY_NOTIFICATION_PROPERTYTYPES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setOrdination(Ordination value) {
		this.ordination = value;
	}
	
	public Ordination getOrdination() {
		return ordination;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
