/**
 * 
 */
package notepaperPlannerManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
		
		bem.deleteEvent("1");
		
		try {
			bem.getEvent("1");
		}catch(Exception e) {
			System.out.print(e);
		}
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
		
		try {
			bem.getEvent("1");
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	@Test
	/*delete existing empty event*/
	final void testDeleteExistingEvent3() throws Exception {
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent();
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate() == null);
		assert(bem.getEvent("1").getDescription() == null);
		
		bem.deleteEvent("1");
		
		try {
			bem.getEvent("1");
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	@Test
	/*delete existing empty event*/
	final void testDeleteExistingEvent4() throws Exception {
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent();
		assert(bem.getEvent("1").getID().equals("1"));
		assert(bem.getEvent("1").getDate() == null);
		assert(bem.getEvent("1").getDescription() == null);
		
		bem.deleteEvent("5");
		bem.deleteEvent("4");
		bem.deleteEvent("1");
		bem.deleteEvent("3");
		bem.deleteEvent("2");
		
		try {
			bem.getEvent("1");
			bem.getEvent("2");
			bem.getEvent("3");
			bem.getEvent("4");
			bem.getEvent("5");
		}catch(Exception e) {
			System.out.print(e);
		}
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
		List<Event> futureEv = bem.viewFutureEvents();
		assert(futureEv.isEmpty());

	}
	
	@Test
	/*view all events after current date when there aren't any*/
	final void testViewFutureEvents2() {
		BasicEventManager bem = new BasicEventManager();

		bem.createNewEvent("12/02/1990", "Buy stocks");
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent("09/01/2003", "Buy stocks");
		bem.createNewEvent("12/02/2017", "Buy stocks");
		bem.createNewEvent("12/02/2019", "Buy stocks");
		bem.createNewEvent("01/01/2022", "Buy stocks");
		
		List<Event> futureEv = bem.viewFutureEvents();
		System.out.println(futureEv);
		assert(futureEv.isEmpty());
	}
	
	@Test
	/*view all events after current date when there are*/
	final void testViewFutureEvents3() {
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent("12/02/1990", "Buy stocks");
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent("09/01/2003", "Buy stocks");
		bem.createNewEvent("12/02/2045", "Buy stocks");
		bem.createNewEvent("12/02/2023", "Buy stocks");
		bem.createNewEvent("18/07/2022", "Buy stocks");
		
		List<Event> futureEv = bem.viewFutureEvents();

		for (Event ev: futureEv) {
			System.out.println(ev.getDate());
		}
		
	}
	
	@Test
	/*view all events scheduled on a specific day when there aren't any events for that day*/
	final void testViewScheduledEvents1() {
		BasicEventManager bem = new BasicEventManager();
		String dayOfAppointments = "12/03/2003";
		List<Event> onDayev = bem.viewEventsOnDay(dayOfAppointments);
		
		assert(onDayev.isEmpty());
	}
	
	@Test
	/*view all events scheduled on a specific day when there aren't any events for that day*/
	final void testViewScheduledEvents2() {
		BasicEventManager bem = new BasicEventManager();
		
		bem.createNewEvent("12/02/1990", "Buy stocks");
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent("09/01/2003", "Buy stocks");
		bem.createNewEvent("12/02/2045", "Buy stocks");
		bem.createNewEvent("12/02/2023", "Buy stocks");
		bem.createNewEvent("18/07/2022", "Buy stocks");
		
		
		String dayOfAppointments = "12/03/2003";
		List<Event> onDayev = bem.viewEventsOnDay(dayOfAppointments);
		
		assert(onDayev.isEmpty());
	}
	
	@Test
	/*view all events scheduled on a specific day when there are events scheduled for that day*/
	final void testViewScheduledEvents3() {
		BasicEventManager bem = new BasicEventManager();

		bem.createNewEvent("12/02/1990", "Buy stocks");
		bem.createNewEvent();
		bem.createNewEvent();
		bem.createNewEvent("12/03/2003", "Buy stocks");
		bem.createNewEvent("12/02/2045", "Buy stocks");
		bem.createNewEvent("12/02/2023", "Buy stocks");
		bem.createNewEvent("12/03/2003", "Buy stocks");
		bem.createNewEvent("12/03/2003", "Buy stocks");
		bem.createNewEvent("18/07/2022", "Buy stocks");
		
		
		String dayOfAppointments = "12/03/2003";
		List<Event> onDayev = bem.viewEventsOnDay(dayOfAppointments);
		
		for (Event ev: onDayev) {
			System.out.println(ev.getDate());
		}
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