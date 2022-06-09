/** interface representing generic Notepaper
 * A Notepaper must have a title, a creation date and an access status
 * Content and last update may be null
 */
package notesManager;

import java.util.Date;

//import java.util.Date;

/**
 * @author olivia
 *
 */
abstract class Notepaper {
	
	abstract protected String getTitle();
	abstract protected String getContent();
	abstract protected Date getCreationDate(); // TODO: make creationDate static
	abstract protected Date getLastUpdate();
	abstract protected AccessStatus getStatus();
	
	abstract protected void setUpdatedTitle(String newName);
	abstract protected void setUpdatedContent(String newContent);
	abstract protected void setUpdatedAccessStatus(AccessStatus newStatus);
}
