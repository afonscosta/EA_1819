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

public class Common extends Users {
	public Common() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == data.ORMConstants.KEY_COMMON_PROPERTIES) {
			return ORM_properties;
		}
		else if (key == data.ORMConstants.KEY_COMMON_NOTIFICATIONS) {
			return ORM_notifications;
		}
		else if (key == data.ORMConstants.KEY_COMMON_CHATS) {
			return ORM_chats;
		}
		else if (key == data.ORMConstants.KEY_COMMON_FAVORITES) {
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
	
	public final PropertySetCollection properties = new PropertySetCollection(this, _ormAdapter, data.ORMConstants.KEY_COMMON_PROPERTIES, data.ORMConstants.KEY_PROPERTY_OWNER, data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notifications(java.util.Set value) {
		this.ORM_notifications = value;
	}
	
	private java.util.Set getORM_Notifications() {
		return ORM_notifications;
	}
	
	public final NotificationSetCollection notifications = new NotificationSetCollection(this, _ormAdapter, data.ORMConstants.KEY_COMMON_NOTIFICATIONS, data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Chats(java.util.Set value) {
		this.ORM_chats = value;
	}
	
	private java.util.Set getORM_Chats() {
		return ORM_chats;
	}
	
	public final ChatSetCollection chats = new ChatSetCollection(this, _ormAdapter, data.ORMConstants.KEY_COMMON_CHATS, data.ORMConstants.KEY_CHAT_COMMON, data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Favorites(java.util.Set value) {
		this.ORM_favorites = value;
	}
	
	private java.util.Set getORM_Favorites() {
		return ORM_favorites;
	}
	
	public final FolderSetCollection favorites = new FolderSetCollection(this, _ormAdapter, data.ORMConstants.KEY_COMMON_FAVORITES, data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
	
}