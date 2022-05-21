/** basic document class implementation
 * 
 */
package notesManager;

//import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author olivia
 *
 */
class BasicDocument implements Document{
	public Title name;
	public Content content;
	public Date creationDate; // TODO: make creationDate static
	public Date lastUpdate;
	public AccessStatus status;
	
	BasicDocument(){
		this.name = setDefaultTitle();
		this.content = setDefaultContent();
		this.creationDate = new Date();
		this.lastUpdate = new Date();
		this.status = setDefaultAccessStatus();
	}
	
	private Title setDefaultTitle() {
		Title basic = new BasicTitle();
		return basic;
	}
	
	private Content setDefaultContent() {
		Content basic = new BasicContent();
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
	
	protected void setUpdatedTitle(Title newTitle) {
		/**check if newTitle is ok
		 * title has to be unique*/
		name = newTitle;
	}
	
	protected void setUpdatedContent(Content newContent) {
		/**check if newContent is ok
		 * */
		content = newContent;
	}
	
	protected void setUpdatedAccessStatus(AccessStatus newStatus) {
		/**check if newStatus is ok
		 * */
		status = newStatus;
	}
	
	protected Title getTitle() {
		return this.name;
	}
	
	protected Content getContent() {
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
