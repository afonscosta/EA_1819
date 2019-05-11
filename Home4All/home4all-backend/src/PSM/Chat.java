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

import java.io.Serializable;
public class Chat implements Serializable {
	public Chat() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Chat))
			return false;
		Chat chat = (Chat)aObj;
		if (getID() != chat.getID())
			return false;
		if (getCommon() == null) {
			if (chat.getCommon() != null)
				return false;
		}
		else if (!getCommon().equals(chat.getCommon()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getID();
		if (getCommon() != null) {
			hashcode = hashcode + (int) getCommon().getORMID();
		}
		return hashcode;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == PSM.ORMConstants.KEY_CHAT_COMMON) {
			this.common = (PSM.Common) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private PSM.Common common;
	
	private int commonId;
	
	private void setCommonId(int value) {
		this.commonId = value;
	}
	
	public int getCommonId() {
		return commonId;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setCommon(PSM.Common value) {
		if (common != null) {
			common.chats.remove(this);
		}
		if (value != null) {
			value.chats.add(this);
		}
	}
	
	public PSM.Common getCommon() {
		return common;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Common(PSM.Common value) {
		this.common = value;
	}
	
	private PSM.Common getORM_Common() {
		return common;
	}
	
	public String toString() {
		return String.valueOf(getID() + " " + ((getCommon() == null) ? "" : String.valueOf(getCommon().getORMID())));
	}
	
}
