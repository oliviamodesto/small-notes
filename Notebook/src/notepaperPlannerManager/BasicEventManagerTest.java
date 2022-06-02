/**
 * 
 */
package notepaperPlannerManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author olivia
 *
 */
class BasicEventManagerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	/*create new empty event*/
	final void testCreateEmptyEvent() throws Exception {
		
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent();
		
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate() == null);
		assert(bem.getEvent("1").getDescription() == null);
	}

	@Test
	/*create new complete event*/
	final void testCreateCompleteEvent() throws Exception {
		BasicEventManager bem = new BasicEventManager();
		
		String dS = "12/02/2019";
		String desc = "Post office, pick up package";
		
		bem.createNewEvent(dS, desc);
		
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(dS);
		
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate().equals(d));
		assert(bem.getEvent("1").getDescription().equals("Post office, pick up package"));
	}

	@Test
	/*delete existing complete event*/
	final void testDeleteExistingEvent1() throws Exception {
		BasicEventManager bem = new BasicEventManager();
		
		String dS = "12/02/2019";
		String desc = "Post office, pick up package";
		
		bem.createNewEvent(dS, desc);
		
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(dS);
		
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate().equals(d));
		assert(bem.getEvent("1").getDescription().equals("Post office, pick up package"));
	}
	
	@Test
	/*delete existing empty event*/
	final void testDeleteExistingEvent2() throws Exception {
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent();
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate() == null);
		assert(bem.getEvent("1").getDescription() == null);
		
		bem.deleteEvent("1");
		bem.getEvent("1");
		
	}
	
	@Test
	/*delete non existing event*/
	final void testDeleteNonExistingEvent() throws Exception {
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent();
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate() == null);
		assert(bem.getEvent("1").getDescription() == null);
		
		bem.deleteEvent("2");
	}
	
	@Test
	/*view all events of empty event manager*/
	final void testViewAllExistingEvents1() {
		BasicEventManager bem = new BasicEventManager();
		bem.viewAllEvents();
	}

	@Test
	/*view all events of non empty event manager*/
	final void testViewAllExistingEvents2() {
		BasicEventManager bem = new BasicEventManager();
		
		//TODO: generate some empty and non empty events to view
		bem.viewAllEvents();
	}
	@Test
	/*view all events after current date when there aren't any events at all*/
	final void testViewFutureEvents1() {
		BasicEventManager bem = new BasicEventManager();
		bem.viewFutureEvents();
	}
	
	@Test
	/*view all events after current date when there aren't any*/
	final void testViewFutureEvents2() {
		BasicEventManager bem = new BasicEventManager();
		// TODO generate past events
		bem.viewFutureEvents();
	}
	
	@Test
	/*view all events after current date when there are*/
	final void testViewFutureEvents3() {
		BasicEventManager bem = new BasicEventManager();
		// TODO generate past and future events events
		bem.viewFutureEvents();
	}
	
	@Test
	/*view all events scheduled on a specific day when there aren't any events for that day*/
	final void testViewScheduledEvents1() {
		BasicEventManager bem = new BasicEventManager();
		String dayOfAppointments = "12/03/2003";
		bem.viewEventsOnDay(dayOfAppointments);
	}
	
	@Test
	/*view all events scheduled on a specific day when there aren't any events for that day*/
	final void testViewScheduledEvents2() {
		BasicEventManager bem = new BasicEventManager();
		// TODO generate past and future events events
		String dayOfAppointments = "12/03/2003";
		bem.viewEventsOnDay(dayOfAppointments);
	}
	
	@Test
	/*view all events scheduled on a specific day when there are events scheduled for that day*/
	final void testViewScheduledEvents3() {
		BasicEventManager bem = new BasicEventManager();
		// TODO generate past and future events events
		String dayOfAppointments = "12/03/2003";
		bem.viewEventsOnDay(dayOfAppointments);
	}
	
	@Test
	/*view all events that contain a keyword in their description when such days do not exist*/
	final void testLookForKeyword1() {
		BasicEventManager bem = new BasicEventManager();
		String keyword = "post office";
		bem.viewEventsWithKey(keyword);
	}
	
	@Test
	/*view all events that contain a keyword in their description when such days do not exist*/
	final void testLookForKeyword2() {
		BasicEventManager bem = new BasicEventManager();
		String keyword = "post office";
		bem.viewEventsWithKey(keyword);
	}
	
	@Test
	/*view all events that contain a keyword in their description when such days do exist*/
	final void testLookForKeyword3() {
		BasicEventManager bem = new BasicEventManager();
		String keyword = "post office";
		bem.viewEventsWithKey(keyword);
	}

}