package notesManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicNotepaperManagerTest {

	@BeforeEach
	void setUp() throws Exception {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
	}


	@Test
	/**check if Notepaper is added correctly to the Notepaper list*/
	final void testAddNewNotepaper1() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		manager.newNotepaper();
		
		assert(!manager.getAllDocs().isEmpty());
		assert(manager.getAllDocs().size() == 1);
		
		System.out.println(manager.getAllDocs());	
	}
	
	
	
	@Test
	/* test rename of Notepaper
	 * assign new name
	 * */
	final void testRenameNotepaper1() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String docTitle = doc1.getTitle();
		String newDocTitle = "AcceptableTitle01";
		
		try{
			manager.renameNotepaper(docTitle, newDocTitle);
			assert(doc1.getTitle().equals(newDocTitle));
		}catch(Exception e) {
			
		}
		
	}
	 
	
	@Test
	/* test rename of Notepaper
	* assign name that already exists (different object)
	* return exception
	 * */
	final void testRenameNotepaper2() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String docTitle = doc1.getTitle();
		String newDocTitle = "AcceptableTitle01";
		
		
		try{
			manager.renameNotepaper(docTitle, newDocTitle);
			assert(doc1.getTitle().equals(newDocTitle));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		Notepaper doc2 = manager.newNotepaper();
		String docTitle2 = doc2.getTitle();
		String newDocTitle2 = "AcceptableTitle01";
		
		try{
			manager.renameNotepaper(docTitle2, newDocTitle2);
		}catch(Exception e) {
				System.out.println(e);
		}
	}
	
	@Test
	/* test rename of Notepaper
	assign name that does not meet guidelines
	 * */
	final void testRenameNotepaper3() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String docTitle = doc1.getTitle();
		String newDocTitle = "AcceptableTitle01"; //TODO: decide guidelines
		
		try{
			manager.renameNotepaper(docTitle, newDocTitle);
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	@Test
	/* test rename of Notepaper
	assign no name
	 * */
	final void testRenameNotepaper4() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String docTitle = doc1.getTitle();
		String newDocTitle = null;
		
		try{
			manager.renameNotepaper(docTitle, newDocTitle);
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	@Test
	/* test rename of Notepaper
	assign empty string
	 * */
	final void testRenameNotepaper5() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String docTitle = doc1.getTitle();
		String newDocTitle = ""; //TODO: decide guidelines
		
		try{
			manager.renameNotepaper(docTitle, newDocTitle);
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	@Test
	/* test rename of Notepaper
	assign empty spaces to file
	 * */
	final void testRenameNotepaper6() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String docTitle = doc1.getTitle();
		String newDocTitle = "   "; //TODO: decide guidelines
		
		try{
			manager.renameNotepaper(docTitle, newDocTitle);
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	 
	
	@Test
	/* test update of access status
	 * Update status from PROMISCUOUS to RESERVED*/
	final void testUpdateAccessStatus1() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		String doc1ID = doc1.getTitle();

		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		manager.updateAccess(doc1ID, AccessStatus.RESERVED);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
	}
	
	@Test
	/* test update of access status*
	 * Update status from RESERVED to PROMISCUOUS*/
	final void testUpdateAccessStatus2() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		String doc1ID = doc1.getTitle();
		
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		manager.updateAccess(doc1ID, AccessStatus.RESERVED);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
		
		manager.updateAccess(doc1ID, AccessStatus.PROMISCUOUS);
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
	}
	
	@Test
	/* test update of access status*
	 * Update status from PROMISCUOUS to PROMISCUOUS*/
	final void testUpdateAccessStatus3() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String doc1ID = doc1.getTitle();
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		manager.updateAccess(doc1ID, AccessStatus.PROMISCUOUS);
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
	}
	
	@Test
	/* test update of access status
	 * Update status from RESERVED to RESERVED*/
	final void testUpdateAccessStatus4() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String doc1ID = doc1.getTitle();
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		manager.updateAccess(doc1ID, AccessStatus.RESERVED);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
		
		manager.updateAccess(doc1ID, AccessStatus.RESERVED);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
	}
	
	@Test
	/* test update of access status
	 * Update status from PROMISCUOUS to FAKE_STATUS
	 * Status remains PROMISCUOUS*/
	final void testUpdateAccessStatus5() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String doc1ID = doc1.getTitle();
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		//AccessStatus fake = new AccessStatus.FAKE_STATUS;
		
		//manager.updateAccess(doc1ID, AccessStatus.FAKE_STATUS);
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
	}
	
	@Test
	/* test update of access status
	 * Update status from RESERVED to FAKE_STATUS
	 * Status remains RESERVED*/
	final void testUpdateAccessStatus6() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String doc1ID = doc1.getTitle();
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		manager.updateAccess(doc1ID, AccessStatus.RESERVED);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
		
		//manager.updateAccess(doc1ID, AccessStatus.FAKE_STATUS);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
	}
	
	@Test
	/* test update of access status
	 * Update status from PROMISCUOUS to Null
	 * Status remains PROMISCUOUS*/
	final void testUpdateAccessStatus7() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String doc1ID = doc1.getTitle();
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
		
		AccessStatus nullStatus = null;
		
		manager.updateAccess(doc1ID, nullStatus);
		assert(doc1.getStatus().equals(AccessStatus.PROMISCUOUS));
	}
	
	@Test
	/* test update of access status
	 * Update status from RESERVED to Null
	 * Status remains RESERVED*/
	final void testUpdateAccessStatus8() {

		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		Notepaper doc1 = manager.newNotepaper();
		
		String doc1ID = doc1.getTitle();
		manager.updateAccess(doc1ID, AccessStatus.RESERVED);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
		
		AccessStatus nullStatus = null;
		
		manager.updateAccess(doc1ID, nullStatus);
		assert(doc1.getStatus().equals(AccessStatus.RESERVED));
		
	}
	
	
	@Test 
	/* test search by title*/
	final void testSearchByTitle() {}
	
	@Test
	/* test search by content*/
	final void testSearchByContent() {}
		
	@Test
	/**check if Notepaper is removed correctly from the Notepaper list*/
	final void testCorrectRemovalNotepaper() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		manager.newNotepaper();
		
		//assert(!manager.getAllDocs().isEmpty());
		//assert(manager.getAllDocs().size() == 1);
		
		System.out.println(manager.getAllDocs());
		
		manager.deleteNotepaper("Untitled");
		//assert(manager.getAllDocs().isEmpty());
		//assert(manager.getAllDocs().size() == 0);
		
	}
	
	//@Test
	/*check if Notepaper is renamed correctly*/
	
	final void testCorrectRenamingOfNotepaper() {
		BasicNotepaperManager manager = new BasicNotepaperManager();
		assert(manager.getAllDocs().isEmpty());
		
		manager.newNotepaper();
		try{
			manager.renameNotepaper("Untitled", "The_new_title");
			}catch(Exception e) {}
		
		//TODO: check title
	}
	
	
	
}
