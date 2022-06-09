/**
 * 
 */
package notesManager;

import java.util.Date;

/**
 * @author olivia
 *
 */
class SimpleNotepaper extends Notepaper{
	protected String name;
	protected String content;
	protected Date creationDate; // TODO: make creationDate static
	protected Date lastUpdate;
	protected AccessStatus status;
	
	SimpleNotepaper(){
		this.name = setDefaultTitle();
		this.content = setDefaultContent();
		this.creationDate = new Date();
		this.lastUpdate = new Date();
		this.status = setDefaultAccessStatus();
	}
	
	private String setDefaultTitle() {
		String basic = this.generateDefaultTitle();
		return basic;
	}
	
	private String generateDefaultTitle() {
		return "Unknown";
	}
	
	private String setDefaultContent() {
		String basic = "";
		return basic;
	}
	
	private AccessStatus setDefaultAccessStatus() {
		AccessStatus basic = AccessStatus.PROMISCUOUS;
		return basic;
	}
	
	protected void setLastUpdateDate() {
		Date now = new Date();
		lastUpdate = now;
	}
	
	/** updates title
	 * assumes title is ok with guidelines
	 * @param newTitle: new title for the Notepaper
	 * */
	protected void setUpdatedTitle(String newTitle) {
			this.name = newTitle;		
	}
	
	
	protected void setUpdatedContent(String newContent) {
		this.content = newContent;		
	}
	
	protected void setUpdatedAccessStatus(AccessStatus newStatus) {
		this.status = newStatus;
	}
	
	
	protected String getTitle() {
		return this.name;
	}
	
	protected String getContent() {
		return this.content;
	}
	
	protected Date getCreationDate() {
		return this.creationDate;
	}
	
	protected Date getLastUpdate() {
		return this.lastUpdate;
	}
	
	protected AccessStatus getStatus() {
		return this.status;
	}


}
