/** Event object 
 * An event must have a unique id, a date, and a description
 */
package notepaperPlannerManager;

import java.util.Date;

/**
 * @author olivia
 *
 */
abstract class Event {

	
	/** Get date of the event*/
	abstract protected Date getDate();
	
	/** Get description of the event*/
	abstract protected String getDescription();
	
	/* Get event unique identifier*/
	abstract protected String getID();
	
	/* Modify date of the event*/
	abstract protected void modifyDate(Date newDate);
	
	/* MOdify description of the event*/
	abstract protected void modifyDescription(String newDescription);

}
