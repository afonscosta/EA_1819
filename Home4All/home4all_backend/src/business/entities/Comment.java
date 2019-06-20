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

public class Comment {
	public Comment() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == data.ORMConstants.KEY_COMMENT_RESPONSE) {
			this.response = (Comment) owner;
		}
		
		else if (key == data.ORMConstants.KEY_COMMENT_WRITER) {
			this.writer = (Common) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private Comment response;
	
	private Common writer;
	
	private String text;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	public String getText() {
		return text;
	}
	
	public void setResponse(Comment value) {
		this.response = value;
	}
	
	public Comment getResponse() {
		return response;
	}
	
	public void setWriter(Common value) {
		this.writer = value;
	}
	
	public Common getWriter() {
		return writer;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
