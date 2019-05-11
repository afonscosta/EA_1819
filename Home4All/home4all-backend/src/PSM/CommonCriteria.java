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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommonCriteria extends AbstractORMCriteria {
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
	
	public CommonCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		name = new StringExpression("name", this);
		genderId = new IntegerExpression("gender.ID", this);
		gender = new AssociationExpression("gender", this);
		occupationId = new IntegerExpression("occupation.ID", this);
		occupation = new AssociationExpression("occupation", this);
		age = new IntegerExpression("age", this);
		phone = new StringExpression("phone", this);
		lastLogin = new DateExpression("lastLogin", this);
		properties = new CollectionExpression("ORM_Properties", this);
		notifications = new CollectionExpression("ORM_Notifications", this);
		chats = new CollectionExpression("ORM_Chats", this);
		favorites = new CollectionExpression("ORM_Favorites", this);
	}
	
	public CommonCriteria(PersistentSession session) {
		this(session.createCriteria(Common.class));
	}
	
	public CommonCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public GenderCriteria createGenderCriteria() {
		return new GenderCriteria(createCriteria("gender"));
	}
	
	public OccupationCriteria createOccupationCriteria() {
		return new OccupationCriteria(createCriteria("occupation"));
	}
	
	public PSM.PropertyCriteria createPropertiesCriteria() {
		return new PSM.PropertyCriteria(createCriteria("ORM_Properties"));
	}
	
	public PSM.NotificationCriteria createNotificationsCriteria() {
		return new PSM.NotificationCriteria(createCriteria("ORM_Notifications"));
	}
	
	public PSM.ChatCriteria createChatsCriteria() {
		return new PSM.ChatCriteria(createCriteria("ORM_Chats"));
	}
	
	public PSM.FolderCriteria createFavoritesCriteria() {
		return new PSM.FolderCriteria(createCriteria("ORM_Favorites"));
	}
	
	public Common uniqueCommon() {
		return (Common) super.uniqueResult();
	}
	
	public Common[] listCommon() {
		java.util.List list = super.list();
		return (Common[]) list.toArray(new Common[list.size()]);
	}
}

