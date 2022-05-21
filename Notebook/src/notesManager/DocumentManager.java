/** Manages note document files.
 * Create new document object.
 * Modify existing document object.
 * Delete existing document object.
 * Rename existing document object.
 * Name existing document object.
 * Change access status to document.
 * Search by document title.
 * Search by document content.
 */
package notesManager;

import java.util.List;

/**
 * @author olivia
 *
 */
public interface DocumentManager {
	
	/*Create new Document object*/
	public void newDocument();
	
	/*Update existing Document object*/
	public void updateDocument();
	
	/*Delete Document object*/
	public void deleteDocument();
	
	/*Rename Document object*/
	public void renameDocument();
	
	public void nameDocument();
	
	public void updateAccess();
	
	/*
	 * @param key: 
	 * @return list of Document objects with key in their title 
	 * */
	public List<Document> searchByTitle(Title key);
	
	/*
	 * @param key: 
	 * @return list of Document objects with key in their content 
	 * */
	public List<Document> searchByContent(Content key);



}
