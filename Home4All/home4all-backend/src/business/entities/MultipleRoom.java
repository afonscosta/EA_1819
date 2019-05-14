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

public class MultipleRoom {
	public MultipleRoom() {
	}
	
	private int ID;
	
	private int peopleAmount;
	
	private int quantity;
	
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
	
	public void setQuantity(int value) {
		this.quantity = value;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
