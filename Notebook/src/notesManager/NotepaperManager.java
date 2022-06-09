/** Manages note Notepaper files.
 * Create new Notepaper object.
 * Modify existing Notepaper object.
 * Delete existing Notepaper object.
 * Rename existing Notepaper object.
 * Name existing Notepaper object.
 * Change access status to Notepaper.
 * Search by Notepaper title.
 * Search by Notepaper content.
 */
package notesManager;

import java.util.List;

/**
 * @author olivia
 *
 */
public interface NotepaperManager {
	
	/*Create new Notepaper object*/
	public Notepaper newNotepaper();
	
	/*Update existing Notepaper object*/
	public void updateNotepaper(String docID, String updatedContent); // TODO: Change data type
	
	/*Delete Notepaper object*/
	public void deleteNotepaper(String docID); // TODO: Change data type
	
	/*Rename Notepaper object*/
	public void renameNotepaper(String docID, String newName) throws Exception ;
	
	/*Update Notepaper status*/
	public void updateAccess(String docID, AccessStatus newStatus);
	
	/*
	 * @param key: 
	 * @return list of Notepaper objects with key in their title 
	 * */
	public List<Notepaper> searchByTitle(String key);
	
	/*
	 * @param key: 
	 * @return list of Notepaper objects with key in their content 
	 * */
	public List<Notepaper> searchByContent(String key);

	/*view Notepaper in GUI window
	 * @param docID: Notepaper we want to open
	 * */
	public void viewNotepaper(String docID);

}
