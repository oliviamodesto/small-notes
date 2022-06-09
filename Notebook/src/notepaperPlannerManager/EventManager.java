/** Basic event manager allows users to handle a set of events.
 * can create new events that are automatically added to the set.
 * can remove events existing on the set.
 * can view all events on the list
 * can view all events past current date
 * can view all events with a specific keyboard 
 */
package notepaperPlannerManager;

import java.util.Date;
import java.util.List;

/**
 * @author olivia
 *
 */
public interface EventManager {
	
	/* create new event */
	public Event createNewEvent();

	/* create new event */
	public Event createNewEvent(String date, String description);
	
	/* modify existing event */
	public void updateDateEvent(String toUpdate, String newDate);
	
	/* modify existing event */
	public void updateDescriptionEvent(String toUpdate, String newDescription);
	
	
	/* delete existing event*/
	public void deleteEvent(String toDelete);
	
	/* view all events */
	public List<Event> viewAllEvents();
	
	/* view all events after current date */
	public List<Event> viewFutureEvents();
	
	/* view all events for specific date */
	public List<Event> viewEventsOnDay(String dayOfAppointments);
	
	/* view events containing keyword in their description */
	public List<Event> viewEventsWithKey(String keyword);
	
	// TODO: view events in a given time interval ?
	// TODO: should there be a limit to the number of events?
}
