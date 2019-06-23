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

import business.entities.Address;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AddressCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression district;
	public final StringExpression city;
	public final StringExpression completeAddress;
	public final FloatExpression coordLat;
	public final FloatExpression coordLng;
	
	public AddressCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		district = new StringExpression("district", this);
		city = new StringExpression("city", this);
		completeAddress = new StringExpression("completeAddress", this);
		coordLat = new FloatExpression("coordLat", this);
		coordLng = new FloatExpression("coordLng", this);
	}
	
	public AddressCriteria(PersistentSession session) {
		this(session.createCriteria(Address.class));
	}
	
	public AddressCriteria() throws PersistentException {
		this(Home4AllPersistentManager.instance().getSession());
	}
	
	public Address uniqueAddress() {
		return (Address) super.uniqueResult();
	}
	
	public Address[] listAddress() {
		java.util.List list = super.list();
		return (Address[]) list.toArray(new Address[list.size()]);
	}
}

