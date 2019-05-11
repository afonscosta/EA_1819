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

public class Common extends PSM.Users {
	public Common() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == PSM.ORMConstants.KEY_COMMON_PROPERTIES) {
			return ORM_properties;
		}
		else if (key == PSM.ORMConstants.KEY_COMMON_NOTIFICATIONS) {
			return ORM_notifications;
		}
		else if (key == PSM.ORMConstants.KEY_COMMON_CHATS) {
			return ORM_chats;
		}
		else if (key == PSM.ORMConstants.KEY_COMMON_FAVORITES) {
			return ORM_favorites;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private PSM.Gender gender;
	
	private PSM.Occupation occupation;
	
	private int age;
	
	private String phone;
	
	private java.util.Date lastLogin;
	
	private java.util.Set ORM_properties = new java.util.HashSet();
	
	private java.util.Set ORM_notifications = new java.util.HashSet();
	
	private java.util.Set ORM_chats = new java.util.HashSet();
	
	private java.util.Set ORM_favorites = new java.util.HashSet();
	
	public void setAge(int value) {
		this.age = value;
	}
	
	public int getAge() {
		return age;
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
	
	private void setORM_Properties(java.util.Set value) {
		this.ORM_properties = value;
	}
	
	private java.util.Set getORM_Properties() {
		return ORM_properties;
	}
	
	public final PSM.PropertySetCollection properties = new PSM.PropertySetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_COMMON_PROPERTIES, PSM.ORMConstants.KEY_PROPERTY_OWNER, PSM.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notifications(java.util.Set value) {
		this.ORM_notifications = value;
	}
	
	private java.util.Set getORM_Notifications() {
		return ORM_notifications;
	}
	
	public final PSM.NotificationSetCollection notifications = new PSM.NotificationSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_COMMON_NOTIFICATIONS, PSM.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Chats(java.util.Set value) {
		this.ORM_chats = value;
	}
	
	private java.util.Set getORM_Chats() {
		return ORM_chats;
	}
	
	public final PSM.ChatSetCollection chats = new PSM.ChatSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_COMMON_CHATS, PSM.ORMConstants.KEY_CHAT_COMMON, PSM.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setOccupation(PSM.Occupation value) {
		this.occupation = value;
	}
	
	public PSM.Occupation getOccupation() {
		return occupation;
	}
	
	private void setORM_Favorites(java.util.Set value) {
		this.ORM_favorites = value;
	}
	
	private java.util.Set getORM_Favorites() {
		return ORM_favorites;
	}
	
	public final PSM.FolderSetCollection favorites = new PSM.FolderSetCollection(this, _ormAdapter, PSM.ORMConstants.KEY_COMMON_FAVORITES, PSM.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setGender(PSM.Gender value) {
		this.gender = value;
	}
	
	public PSM.Gender getGender() {
		return gender;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
