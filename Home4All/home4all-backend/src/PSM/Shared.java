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

public class Shared extends PSM.Property {
	public Shared() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == PSM.ORMConstants.KEY_SHARED_BEDROOMS) {
			return ORM_bedrooms;
		}
		else if (key == PSM.ORMConstants.KEY_SHARED_OCCUPATIONS) {
			return ORM_occupations;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int females;
	
	private int males;
	
	private int smokers;
	
	private int pets;
	
	private boolean totalAccess;
	
	private java.util.Set ORM_bedrooms = new java.util.HashSet();
	
	private java.util.Set ORM_occupations = new java.util.HashSet();
	
	public void setFemales(int value) {
		this.females = value;
	}
	
	public int getFemales() {
		return females;
	}
	
	public void setMales(int value) {
		this.males = value;
	}
	
	public int getMales() {
		return males;
	}
	
	public void setSmokers(int value) {
		this.smokers = value;
	}
	
	public int getSmokers() {
		return smokers;
	}
	
	public void setPets(int value) {
		this.pets = value;
	}
	
	public int getPets() {
		return pets;
	}
	
	public void setTotalAccess(boolean value) {
		this.totalAccess = value;
	}
	
	public boolean getTotalAccess() {
		return totalAccess;
	}
	
	private void setORM_Bedrooms(java.util.Set value) {
		this.ORM_bedrooms = value;
	}
	
	private java.util.Set getORM_Bedrooms() {
		return ORM_bedrooms;
	}
	
	public final PSM.BedroomSetCollection bedrooms = new PSM.BedroomSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_SHARED_BEDROOMS, PSM.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Occupations(java.util.Set value) {
		this.ORM_occupations = value;
	}
	
	private java.util.Set getORM_Occupations() {
		return ORM_occupations;
	}
	
	public final PSM.OccupationSetCollection occupations = new PSM.OccupationSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_SHARED_OCCUPATIONS, PSM.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
