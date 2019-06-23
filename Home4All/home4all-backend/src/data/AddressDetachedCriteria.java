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

import business.entities.Address;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AddressDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression district;
	public final StringExpression city;
	public final StringExpression completeAddress;
	public final FloatExpression coordLat;
	public final FloatExpression coordLng;
	
	public AddressDetachedCriteria() {
		super(Address.class, AddressCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		district = new StringExpression("district", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		completeAddress = new StringExpression("completeAddress", this.getDetachedCriteria());
		coordLat = new FloatExpression("coordLat", this.getDetachedCriteria());
		coordLng = new FloatExpression("coordLng", this.getDetachedCriteria());
	}
	
	public AddressDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, AddressCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		district = new StringExpression("district", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		completeAddress = new StringExpression("completeAddress", this.getDetachedCriteria());
		coordLat = new FloatExpression("coordLat", this.getDetachedCriteria());
		coordLng = new FloatExpression("coordLng", this.getDetachedCriteria());
	}
	
	public Address uniqueAddress(PersistentSession session) {
		return (Address) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Address[] listAddress(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Address[]) list.toArray(new Address[list.size()]);
	}
}

