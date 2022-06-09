/**
 * 
 */
package notesManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author olivia
 *
 */
class NotepaperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	
	/**Create Notepaper
	 * get title
	 * get content 
	 * get creation date
	 * get last update
	 * get access status
	 * */
	@Test
	final void test() {
		Notepaper doc1 = new SimpleNotepaper();
		
		assert(doc1.getTitle().equals("Unknown"));
		assert(doc1.getContent().equals(""));
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
	}

}
