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

import business.entities.InternalAccount;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class InternalAccountCriteria extends AbstractORMCriteria {
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
	public final StringExpression password;
	
	public InternalAccountCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		name = new StringExpression("name", this);
		genderId = new StringExpression("gender.name", this);
		gender = new AssociationExpression("gender", this);
		occupationId = new StringExpression("occupation.name", this);
		occupation = new AssociationExpression("occupation", this);
		birthdate = new DateExpression("birthdate", this);
		phone = new StringExpression("phone", this);
		lastLogin = new DateExpression("lastLogin", this);
		blocked = new BooleanExpression("blocked", this);
		properties = new CollectionExpression("ORM_Properties", this);
		notifications = new CollectionExpression("ORM_Notifications", this);
		chats = new CollectionExpression("ORM_Chats", this);
		favorites = new CollectionExpression("ORM_Favorites", this);
		password = new StringExpression("password", this);
	}
	
	public InternalAccountCriteria(PersistentSession session) {
		this(session.createCriteria(InternalAccount.class));
	}
	
	public InternalAccountCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public GenderCriteria createGenderCriteria() {
		return new GenderCriteria(createCriteria("gender"));
	}
	
	public OccupationCriteria createOccupationCriteria() {
		return new OccupationCriteria(createCriteria("occupation"));
	}
	
	public PropertyCriteria createPropertiesCriteria() {
		return new PropertyCriteria(createCriteria("ORM_Properties"));
	}
	
	public NotificationCriteria createNotificationsCriteria() {
		return new NotificationCriteria(createCriteria("ORM_Notifications"));
	}
	
	public ChatCriteria createChatsCriteria() {
		return new ChatCriteria(createCriteria("ORM_Chats"));
	}
	
	public FolderCriteria createFavoritesCriteria() {
		return new FolderCriteria(createCriteria("ORM_Favorites"));
	}
	
	public InternalAccount uniqueInternalAccount() {
		return (InternalAccount) super.uniqueResult();
	}
	
	public InternalAccount[] listInternalAccount() {
		java.util.List list = super.list();
		return (InternalAccount[]) list.toArray(new InternalAccount[list.size()]);
	}
}

