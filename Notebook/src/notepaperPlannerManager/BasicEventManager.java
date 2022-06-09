/** Basic event manager allows users to handle a list of events.
 * can create new events that are automatically added to the list.
 * All events are assigned a unique numerical id.
 * id must be a number
 * can remove events existing on the list.
 * can view all events on the list
 * can view all events past current date
 * can view all events with a specific keyword 
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
	
	public BasicEventManager() {
		this.myEvents = new ArrayList<Event>();
		this.eventIdGenerator = new Counter();
	}
	
	/* get event
	 * @param IDEvent: unique identifier of the event we want to find
	 * @throws EventNotFoundException if cannot find event*/
	public Event getEvent(String IDEvent) throws Exception{
		Iterator<Event> evI = this.myEvents.iterator();
	
		while(evI.hasNext()) {
			Event curr = evI.next();
			
			if (curr.getID().equals(IDEvent)){
				return curr;
			}
		}
		
		throw new EventNotFoundException();
	}
	
	/*get event date
	 * @param IDEvent: unique identifier of the event we want to find
	 * @returns date: date of the event in format "dd/mm/yyyy"
	 * @throws EventNotFoundException if cannot find event*/
	public String getEventDate(String IDEvent) throws Exception{
		try {
			String date = this.fromDateToString(this.getEvent(IDEvent).getDate());
			return date;
		}catch(EventNotFoundException e) {
			throw new EventNotFoundException();
		}catch(Exception e) {
			throw new Exception();
		}
	}
	
	/*convert Date object to String "dd/MM/YYYY"*/
	private String fromDateToString(Date toConvert){
		String rawDate = toConvert.toString();
		return rawDate;
	}
	
	/*get event date
	 * @param IDEvent: unique identifier of the event we want to find
	 * @returns date: date of the event in format "dd/mm/yyyy"
	 * @throws EventNotFoundException if cannot find event*/
	public String getEventDescription(String IDEvent) throws Exception{
		try {
			String desc = this.getEvent(IDEvent).getDescription();
			return desc;
		}catch(EventNotFoundException e) {
			throw new EventNotFoundException();
		}catch(Exception e) {
			throw new Exception();
		}
	}
	
	/* create new empty event
	 * @return empty event object  */
	public Event createNewEvent() {
		Event emptyEvent = new BasicEvent(eventIdGenerator.getID());
		this.myEvents.add(emptyEvent);
		return emptyEvent;
	}

	/* create new complete event
	 * @param date: date of the event, must be in dd/MM/yyyy format
	 * @param description: description of the event
	 * @return full event object */
	public Event createNewEvent(String date, String description) {
		
		try {
			Date d = this.fromStringToDate(date);
			Event full = new BasicEvent(eventIdGenerator.getID(), d, description);
			this.myEvents.add(full);
			return full;
		} catch (ParseException e) {
			System.out.println("New date in wrong format\n");
		} catch (Exception e) {
			System.out.println("Event creation failed\n");
		}
		return null; 
		
	}
	
	/* modify existing event 
	 * @param toUpdate: unique identifier of event we want to update
	 * @param newDate: new event date, must be in format dd/MM/yyyy */
	public void updateDateEvent(String toUpdate, String newDate) {
		try {
			Event ev = this.getEvent(toUpdate);
			Date d = this.fromStringToDate(newDate);
			ev.modifyDate(d);
		}catch(EventNotFoundException e) {
			//System.out.println(e);
		}catch(ParseException e) {
			//System.out.println("New date in wrong format\n");
			throw new ParseException("New date is in wrong format\n");
		}catch(Exception e) {
			System.out.println("Update failed\n");
		}
	}
	
	/* modify existing event 
	 * @param toUpdate: unique identifier of event we want to update
	 * @param newDescription: new event description*/
	public void updateDescriptionEvent(String toUpdate, String newDescription) {
		try {
			Event ev = this.getEvent(toUpdate);
			ev.modifyDescription(newDescription);
		}catch(EventNotFoundException e) {
			
		}catch(Exception e) {
			
		}
	}
	
	/* delete existing event
	 * @param toDelete: unique identifier of event to delete*/
	public void deleteEvent(String toDelete) {
		try {
			this.myEvents.remove(this.getEvent(toDelete));
		} catch (EventNotFoundException e) {
			//System.out.println(e);
		} catch(Exception e) {
			
		}
		
	}
	
	/* view all events */
	public List<Event> viewAllEvents(){
		return this.myEvents;
	}
	
	/* view all events after current date */
	public List<Event> viewFutureEvents(){
		Date curr = new Date();
		List<Event> futureEv = new ArrayList<Event>();
		
		Iterator<Event> evI = this.myEvents.iterator();
		
		while(evI.hasNext()) {
			Event ev = evI.next();
			Date evD = ev.getDate();
			
			if(evD != null && evD.compareTo(curr) > 0) {
				futureEv.add(ev);
			}
		}
		return futureEv;
	}
	
	/* view all events for specific date */
	public List<Event> viewEventsOnDay(String dayOfAppointments){
		List<Event> onDayEv = new ArrayList<Event>();
		Iterator<Event> evI = this.myEvents.iterator();
		
		try{
			Date specialDay = this.fromStringToDate(dayOfAppointments);
		
			while(evI.hasNext()) {
				Event ev = evI.next();
				Date evD = ev.getDate();
			
				if(evD != null && evD.compareTo(specialDay) == 0) {
					onDayEv.add(ev);
				}
			}
		} catch(ParseException e) {
			System.out.println("Date in wrong format\n");
		} catch(Exception e) {
			System.out.println("Cannot view events on day\n");
		}
		return onDayEv;
	}
	
	/* view events containing keyword in their description */
	public List<Event> viewEventsWithKey(String keyword){
		List<Event> lev = new ArrayList<Event>();
		return lev;
	}

	
	/*Convert string to Date object
	 * @param newDate: dd/MM/yyyy string to convert to date
	 * @return d: date object matching newDate
	 * @throws ParseException if newDate not in correct format*/
	private Date fromStringToDate(String newDate) throws ParseException {
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
		return d;
	}

	/*Counter object for generating unique ids for events*/
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
