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
package data;

import java.util.List;

import business.entities.Common;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommonDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression name;
	public final StringExpression genderId;
	public final AssociationExpression gender;
	public final StringExpression occupationId;
	public final AssociationExpression occupation;
	public final DateExpression birthdate;
	public final StringExpression phone;
	public final DateExpression lastLogin;
	public final BooleanExpression blocked;
	public final CollectionExpression properties;
	public final CollectionExpression notifications;
	public final CollectionExpression chats;
	public final CollectionExpression favorites;
	
	public CommonDetachedCriteria() {
		super(Common.class, CommonCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		genderId = new StringExpression("gender.name", this.getDetachedCriteria());
		gender = new AssociationExpression("gender", this.getDetachedCriteria());
		occupationId = new StringExpression("occupation.name", this.getDetachedCriteria());
		occupation = new AssociationExpression("occupation", this.getDetachedCriteria());
		birthdate = new DateExpression("birthdate", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		lastLogin = new DateExpression("lastLogin", this.getDetachedCriteria());
		blocked = new BooleanExpression("blocked", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
		notifications = new CollectionExpression("ORM_Notifications", this.getDetachedCriteria());
		chats = new CollectionExpression("ORM_Chats", this.getDetachedCriteria());
		favorites = new CollectionExpression("ORM_Favorites", this.getDetachedCriteria());
	}
	
	public CommonDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CommonCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		genderId = new StringExpression("gender.name", this.getDetachedCriteria());
		gender = new AssociationExpression("gender", this.getDetachedCriteria());
		occupationId = new StringExpression("occupation.name", this.getDetachedCriteria());
		occupation = new AssociationExpression("occupation", this.getDetachedCriteria());
		birthdate = new DateExpression("birthdate", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		lastLogin = new DateExpression("lastLogin", this.getDetachedCriteria());
		blocked = new BooleanExpression("blocked", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
		notifications = new CollectionExpression("ORM_Notifications", this.getDetachedCriteria());
		chats = new CollectionExpression("ORM_Chats", this.getDetachedCriteria());
		favorites = new CollectionExpression("ORM_Favorites", this.getDetachedCriteria());
	}
	
	public GenderDetachedCriteria createGenderCriteria() {
		return new GenderDetachedCriteria(createCriteria("gender"));
	}
	
	public OccupationDetachedCriteria createOccupationCriteria() {
		return new OccupationDetachedCriteria(createCriteria("occupation"));
	}
	
	public PropertyDetachedCriteria createPropertiesCriteria() {
		return new PropertyDetachedCriteria(createCriteria("ORM_Properties"));
	}
	
	public NotificationDetachedCriteria createNotificationsCriteria() {
		return new NotificationDetachedCriteria(createCriteria("ORM_Notifications"));
	}
	
	public ChatDetachedCriteria createChatsCriteria() {
		return new ChatDetachedCriteria(createCriteria("ORM_Chats"));
	}
	
	public FolderDetachedCriteria createFavoritesCriteria() {
		return new FolderDetachedCriteria(createCriteria("ORM_Favorites"));
	}
	
	public Common uniqueCommon(PersistentSession session) {
		return (Common) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Common[] listCommon(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Common[]) list.toArray(new Common[list.size()]);
	}
}

