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

public class Comment {
	public Comment() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == PSM.ORMConstants.KEY_COMMENT_RESPONSE) {
			this.response = (PSM.Comment) owner;
		}
		
		else if (key == PSM.ORMConstants.KEY_COMMENT_WRITER) {
			this.writer = (PSM.Common) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private PSM.Comment response;
	
	private PSM.Common writer;
	
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
	
	public void setResponse(PSM.Comment value) {
		this.response = value;
	}
	
	public PSM.Comment getResponse() {
		return response;
	}
	
	public void setWriter(PSM.Common value) {
		this.writer = value;
	}
	
	public PSM.Common getWriter() {
		return writer;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
