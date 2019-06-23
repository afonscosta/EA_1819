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

import business.entities.Comment;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommentDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression responseId;
	public final AssociationExpression response;
	public final IntegerExpression writerId;
	public final AssociationExpression writer;
	public final StringExpression text;
	
	public CommentDetachedCriteria() {
		super(Comment.class, CommentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		responseId = new IntegerExpression("response.ID", this.getDetachedCriteria());
		response = new AssociationExpression("response", this.getDetachedCriteria());
		writerId = new IntegerExpression("writer.ID", this.getDetachedCriteria());
		writer = new AssociationExpression("writer", this.getDetachedCriteria());
		text = new StringExpression("text", this.getDetachedCriteria());
	}
	
	public CommentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CommentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		responseId = new IntegerExpression("response.ID", this.getDetachedCriteria());
		response = new AssociationExpression("response", this.getDetachedCriteria());
		writerId = new IntegerExpression("writer.ID", this.getDetachedCriteria());
		writer = new AssociationExpression("writer", this.getDetachedCriteria());
		text = new StringExpression("text", this.getDetachedCriteria());
	}
	
	public CommentDetachedCriteria createResponseCriteria() {
		return new CommentDetachedCriteria(createCriteria("response"));
	}
	
	public CommonDetachedCriteria createWriterCriteria() {
		return new CommonDetachedCriteria(createCriteria("writer"));
	}
	
	public Comment uniqueComment(PersistentSession session) {
		return (Comment) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comment[] listComment(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comment[]) list.toArray(new Comment[list.size()]);
	}
}

