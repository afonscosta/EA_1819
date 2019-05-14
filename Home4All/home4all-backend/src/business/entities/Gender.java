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

public class Gender {
	public Gender() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Gender))
			return false;
		Gender gender = (Gender)aObj;
		if ((getName() != null && !getName().equals(gender.getName())) || (getName() == null && gender.getName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
		return hashcode;
	}
	
	private String name;
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getORMID() {
		return getName();
	}
	
	public String toString() {
		return String.valueOf(getName());
	}
	
}
