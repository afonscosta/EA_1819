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

public class Address {
	public Address() {
	}
	
	private int ID;
	
	private String district;
	
	private String city;
	
	private String completeAddress;
	
	private float coordLat;
	
	private float coordLng;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
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
	
	public void setCoordLat(float value) {
		this.coordLat = value;
	}
	
	public float getCoordLat() {
		return coordLat;
	}
	
	public void setCoordLng(float value) {
		this.coordLng = value;
	}
	
	public float getCoordLng() {
		return coordLng;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
