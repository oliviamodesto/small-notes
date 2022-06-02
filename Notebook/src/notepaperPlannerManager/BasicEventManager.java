/** Basic event manager allows users to handle a list of events.
 * can create new events that are automatically added to the list.
 * All events are assigned a unique numerical id.
 * id must be a number
 * can remove events existing on the list.
 * can view all events on the list
 * can view all events past current date
 * can view all events with a specific keyboard 
 */
package notepaperPlannerManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author olivia
 *
 */
public class BasicEventManager implements EventManager{
	private Counter eventIdGenerator;
	protected List<Event> myEvents;
	
	BasicEventManager() {
		this.myEvents = new ArrayList<Event>();
		this.eventIdGenerator = new Counter();
	}
	
	/*get event
	 * @throws Exception if cannot find event*/
	public Event getEvent(String IDEvent) throws Exception{
		Iterator<Event> evI = this.myEvents.iterator();
	
		while(evI.hasNext()) {
			Event curr = evI.next();
			
			if (curr.getID().equals(IDEvent)){
				return curr;
			}
		}
		
		throw new Exception("Event not found");
	}
	
	/* create new empty event
	 * @ return empty event object  */
	public Event createNewEvent() {
		Event emptyEvent = new BasicEvent(eventIdGenerator.getID());
		this.myEvents.add(emptyEvent);
		return emptyEvent;
	}

	/* create new complete event */
	public Event createNewEvent(String date, String description) {
		
		try {
			Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Event full = new BasicEvent(eventIdGenerator.getID(), d, description);
			this.myEvents.add(full);
			return full;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
	/* modify existing event */
	public void updateDateEvent(String toUpdate, String newDate) {
		try {
			// convert to Update to date
			Event ev = this.getEvent(toUpdate);
			Date d = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
			ev.modifyDate(d);
		}catch(Exception e) {
			
		}
	}
	
	/* modify existing event */
	public void updateDescriptionEvent(String toUpdate, String newDescription) {
		try {
			Event ev = this.getEvent(toUpdate);
			ev.modifyDescription(newDescription);
		}catch(Exception e) {
			
		}
	}
	
	/* delete existing event*/
	public void deleteEvent(String toDelete) {
		try {
			this.myEvents.remove(this.getEvent(toDelete));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	/* view all events */
	public List<Event> viewAllEvents(){
		List<Event> lev = new ArrayList<Event>();
		return lev;
	}
	
	/* view all events after current date */
	public List<Event> viewFutureEvents(){
		List<Event> lev = new ArrayList<Event>();
		return lev;
	}
	
	/* view all events for specific date */
	public List<Event> viewEventsOnDay(String dayOfAppointments){
		List<Event> lev = new ArrayList<Event>();
		return lev;
	}
	
	/* view events containing keyword in their description */
	public List<Event> viewEventsWithKey(String keyword){
		List<Event> lev = new ArrayList<Event>();
		return lev;
	}


	private class Counter{
		private int count;
		private int stepValue;
		
		private Counter() {
			count = 0;
			stepValue = 1;
		}
		
		private void increase() {
			count = count + stepValue;
		}
		
		private String getID() {
			this.increase();
			return Integer.toString(count);
		}
	}
	
	
	
}
