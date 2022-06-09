/**
 * 
 */
package notepaperPlannerManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author olivia
 *
 */
class BasicEventTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	/* create empty new BasicEvent object*/
	final void testCreateBasicEvent() {
		BasicEvent be = new BasicEvent("1");
	}
	
	@Test
	/* create new BasicEvent object*/
	final void testCreateBasicEvent2() {
		Date d = new GregorianCalendar(2015, 3, 9).getTime();
		String desc = "Post office, pick up package";
		BasicEvent be = new BasicEvent("1", d, desc);
		
		assert(be.getDate().equals(new GregorianCalendar(2015, 3, 9).getTime()));
		assert(be.getDescription().equals(desc));
	}
	
	@Test
	/* get default date of BasicEvent object*/
	final void testGetDate() {
		BasicEvent be = new BasicEvent("1");
		assert(be.getDate() == null);
	}
	
	@Test
	/* set date of BasicEvent object*/
	final void testModifyDate() {
		BasicEvent be = new BasicEvent("1");
		assert(be.getDate() == null);

		Date d = new GregorianCalendar(2014, 2, 11).getTime();
		be.modifyDate(d);
		assert(be.getDate().equals(new GregorianCalendar(2014, 2, 11).getTime()));

	}
	
	@Test
	/* get default description of BasicEvent object*/
	final void testGetDescription() {
		BasicEvent be = new BasicEvent("1");
		assert(be.getDescription() == null);
	}
	
	@Test
	/* set description of BasicEvent object*/
	final void testModifyDescription() {
		BasicEvent be = new BasicEvent("1");
		assert(be.getDescription() == null);
		
		String appointment = "Dentist";
		
		be.modifyDescription(appointment);
		assert(be.getDescription().equals("Dentist"));
		
	}
	
}
