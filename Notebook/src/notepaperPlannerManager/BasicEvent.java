/** implementation of Event object.
 * An event must have a unique id, a date, and a description.
 * date can be null
 * description can be null
 */
package notepaperPlannerManager;

import java.util.Date;

/**
 * @author olivia
 *
 */
class BasicEvent extends Event{
	private String id;
	private Date date; //TODO: update to java.time
	private String description;
	
	BasicEvent(String chosenID){
		this.id = chosenID;
		this.date = null;
		this.description = null;
	}
	
	BasicEvent(String chosenID, Date dateEvent, String descriptionEvent){
		this.id = chosenID;
		this.date = dateEvent;
		this.description = descriptionEvent;
	}
	
	/*get event id*/
	protected String getID() {
		return this.id;
	}
	@Override
	/** Get date of the event*/
	protected Date getDate() {
		return this.date;
	}
	
	@Override
	/** Get description of the event*/
	protected String getDescription() {
		return this.description;
	}
	
	@Override
	/* Modify date of the event*/
	protected void modifyDate(Date newDate) {
		this.date = newDate;
	}

	@Override
	/* MOdify description of the event*/
	protected void modifyDescription(String newDescription) {
		this.description = newDescription;
	}
	
}
