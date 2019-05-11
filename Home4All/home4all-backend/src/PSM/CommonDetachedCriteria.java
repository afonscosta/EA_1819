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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommonDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression name;
	public final IntegerExpression genderId;
	public final AssociationExpression gender;
	public final IntegerExpression occupationId;
	public final AssociationExpression occupation;
	public final IntegerExpression age;
	public final StringExpression phone;
	public final DateExpression lastLogin;
	public final CollectionExpression properties;
	public final CollectionExpression notifications;
	public final CollectionExpression chats;
	public final CollectionExpression favorites;
	
	public CommonDetachedCriteria() {
		super(PSM.Common.class, PSM.CommonCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		genderId = new IntegerExpression("gender.ID", this.getDetachedCriteria());
		gender = new AssociationExpression("gender", this.getDetachedCriteria());
		occupationId = new IntegerExpression("occupation.ID", this.getDetachedCriteria());
		occupation = new AssociationExpression("occupation", this.getDetachedCriteria());
		age = new IntegerExpression("age", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		lastLogin = new DateExpression("lastLogin", this.getDetachedCriteria());
		properties = new CollectionExpression("ORM_Properties", this.getDetachedCriteria());
		notifications = new CollectionExpression("ORM_Notifications", this.getDetachedCriteria());
		chats = new CollectionExpression("ORM_Chats", this.getDetachedCriteria());
		favorites = new CollectionExpression("ORM_Favorites", this.getDetachedCriteria());
	}
	
	public CommonDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PSM.CommonCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		genderId = new IntegerExpression("gender.ID", this.getDetachedCriteria());
		gender = new AssociationExpression("gender", this.getDetachedCriteria());
		occupationId = new IntegerExpression("occupation.ID", this.getDetachedCriteria());
		occupation = new AssociationExpression("occupation", this.getDetachedCriteria());
		age = new IntegerExpression("age", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		lastLogin = new DateExpression("lastLogin", this.getDetachedCriteria());
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
	
	public PSM.PropertyDetachedCriteria createPropertiesCriteria() {
		return new PSM.PropertyDetachedCriteria(createCriteria("ORM_Properties"));
	}
	
	public PSM.NotificationDetachedCriteria createNotificationsCriteria() {
		return new PSM.NotificationDetachedCriteria(createCriteria("ORM_Notifications"));
	}
	
	public PSM.ChatDetachedCriteria createChatsCriteria() {
		return new PSM.ChatDetachedCriteria(createCriteria("ORM_Chats"));
	}
	
	public PSM.FolderDetachedCriteria createFavoritesCriteria() {
		return new PSM.FolderDetachedCriteria(createCriteria("ORM_Favorites"));
	}
	
	public Common uniqueCommon(PersistentSession session) {
		return (Common) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Common[] listCommon(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Common[]) list.toArray(new Common[list.size()]);
	}
}

