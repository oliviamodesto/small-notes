package notesManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentManagerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	/*returns new object Document*/
	final void testNewDocument() {
		BasicDocument test1 = new BasicDocument();
		BasicTitle test1Title = (BasicTitle) test1.getTitle();
		BasicContent test1Content = (BasicContent) test1.getContent();
		
		Date test1Creation = test1.getCreationDate();
		Date test1Update = test1.getLastUpdate();
		
		AccessStatus test1Status = test1.getStatus();
		assertTrue(test1Title.name.equals("Untitled"));
		assertTrue(test1Content.content.equals(""));
		
		System.out.print(test1Creation);
		System.out.print(test1Update);
		
		assertTrue(test1Status.equals(AccessStatus.PROMISCUOUS));
	}
	
	@Test
	/*modify title new document*/
	final void testNewDocument2() {
		BasicDocument test1 = new BasicDocument();
		BasicTitle test1Title = (BasicTitle) test1.getTitle();
		
		assertTrue(test1Title.name.equals("Untitled"));
		
		BasicTitle newTitle = new BasicTitle("Hello world");
				
		test1.setUpdatedTitle(newTitle);

		BasicTitle test1UpdatedTitle = (BasicTitle) test1.getTitle();
		assertTrue(test1UpdatedTitle.name.equals("Hello world"));
		
	}
	
	final void testNewDocument3() {
		
	}
}
