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

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class Common extends Users {
	public Common() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_COMMON_PROPERTIES) {
			return ORM_properties;
		}
		else if (key == ORMConstants.KEY_COMMON_NOTIFICATIONS) {
			return ORM_notifications;
		}
		else if (key == ORMConstants.KEY_COMMON_CHATS) {
			return ORM_chats;
		}
		else if (key == ORMConstants.KEY_COMMON_FAVORITES) {
			return ORM_favorites;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private Gender gender;
	
	private Occupation occupation;
	
	private java.util.Date birthdate;
	
	private String phone;
	
	private java.util.Date lastLogin;
	
	private boolean blocked;
	
	private java.util.Set ORM_properties = new java.util.HashSet();
	
	private java.util.Set ORM_notifications = new java.util.HashSet();
	
	private java.util.Set ORM_chats = new java.util.HashSet();
	
	private java.util.Set ORM_favorites = new java.util.HashSet();
	
	public void setBirthdate(java.util.Date value) {
		this.birthdate = value;
	}
	
	public java.util.Date getBirthdate() {
		return birthdate;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setLastLogin(java.util.Date value) {
		this.lastLogin = value;
	}
	
	public java.util.Date getLastLogin() {
		return lastLogin;
	}
	
	public void setBlocked(boolean value) {
		this.blocked = value;
	}
	
	public boolean getBlocked() {
		return blocked;
	}
	
	private void setORM_Properties(java.util.Set value) {
		this.ORM_properties = value;
	}
	
	private java.util.Set getORM_Properties() {
		return ORM_properties;
	}
	
	public final PropertySetCollection properties = new PropertySetCollection(this, _ormAdapter, ORMConstants.KEY_COMMON_PROPERTIES, ORMConstants.KEY_PROPERTY_OWNER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notifications(java.util.Set value) {
		this.ORM_notifications = value;
	}
	
	private java.util.Set getORM_Notifications() {
		return ORM_notifications;
	}
	
	public final NotificationSetCollection notifications = new NotificationSetCollection(this, _ormAdapter, ORMConstants.KEY_COMMON_NOTIFICATIONS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Chats(java.util.Set value) {
		this.ORM_chats = value;
	}
	
	private java.util.Set getORM_Chats() {
		return ORM_chats;
	}
	
	public final ChatSetCollection chats = new ChatSetCollection(this, _ormAdapter, ORMConstants.KEY_COMMON_CHATS, ORMConstants.KEY_CHAT_COMMON, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Favorites(java.util.Set value) {
		this.ORM_favorites = value;
	}
	
	private java.util.Set getORM_Favorites() {
		return ORM_favorites;
	}
	
	public final FolderSetCollection favorites = new FolderSetCollection(this, _ormAdapter, ORMConstants.KEY_COMMON_FAVORITES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setOccupation(Occupation value) {
		this.occupation = value;
	}
	
	public Occupation getOccupation() {
		return occupation;
	}
	
	public void setGender(Gender value) {
		this.gender = value;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public String toString() {
		return super.toString();
	}

	public int getAge() {
		Calendar a = Calendar.getInstance();
		a.setTime(this.birthdate);
		Calendar b = Calendar.getInstance();

		int diff = b.get(YEAR) - a.get(YEAR);
		if (a.get(MONTH) > b.get(MONTH) ||
				(a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
			diff--;
		}
		return diff;
	}
}
