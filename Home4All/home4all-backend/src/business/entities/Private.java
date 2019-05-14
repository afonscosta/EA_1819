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

public class Private extends Property {
	public Private() {
	}
	
	private boolean furnished;
	
	private java.util.Date availability;
	
	private float sellPrice;
	
	private float rentPrice;
	
	private boolean sold;
	
	public void setFurnished(boolean value) {
		this.furnished = value;
	}
	
	public boolean getFurnished() {
		return furnished;
	}
	
	public void setAvailability(java.util.Date value) {
		this.availability = value;
	}
	
	public java.util.Date getAvailability() {
		return availability;
	}
	
	public void setSellPrice(float value) {
		this.sellPrice = value;
	}
	
	public float getSellPrice() {
		return sellPrice;
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
	
	public String toString() {
		return super.toString();
	}
	
}
