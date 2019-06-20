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

public class Chat {
	public Chat() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_CHAT_COMMON) {
			this.common = (Common) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private Common common;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCommon(Common value) {
		if (common != null) {
			common.chats.remove(this);
		}
		if (value != null) {
			value.chats.add(this);
		}
	}
	
	public Common getCommon() {
		return common;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Common(Common value) {
		this.common = value;
	}
	
	private Common getORM_Common() {
		return common;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
