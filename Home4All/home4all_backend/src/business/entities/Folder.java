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

public class Folder {
	public Folder() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == data.ORMConstants.KEY_FOLDER_PROPERTIES) {
			return ORM_properties;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Set ORM_properties = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void setORM_Properties(java.util.Set value) {
		this.ORM_properties = value;
	}
	
	private java.util.Set getORM_Properties() {
		return ORM_properties;
	}
	
	public final PropertySetCollection properties = new PropertySetCollection(this, _ormAdapter, data.ORMConstants.KEY_FOLDER_PROPERTIES, data.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
