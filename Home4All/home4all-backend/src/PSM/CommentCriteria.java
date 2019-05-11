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

public class CommentCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression responseId;
	public final AssociationExpression response;
	public final IntegerExpression writerId;
	public final AssociationExpression writer;
	public final StringExpression text;
	
	public CommentCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		responseId = new IntegerExpression("response.ID", this);
		response = new AssociationExpression("response", this);
		writerId = new IntegerExpression("writer.ID", this);
		writer = new AssociationExpression("writer", this);
		text = new StringExpression("text", this);
	}
	
	public CommentCriteria(PersistentSession session) {
		this(session.createCriteria(Comment.class));
	}
	
	public CommentCriteria() throws PersistentException {
		this(PSM.Home4AllPersistentManager.instance().getSession());
	}
	
	public CommentCriteria createResponseCriteria() {
		return new CommentCriteria(createCriteria("response"));
	}
	
	public CommonCriteria createWriterCriteria() {
		return new CommonCriteria(createCriteria("writer"));
	}
	
	public Comment uniqueComment() {
		return (Comment) super.uniqueResult();
	}
	
	public Comment[] listComment() {
		java.util.List list = super.list();
		return (Comment[]) list.toArray(new Comment[list.size()]);
	}
}

