/**
 * 
 */
package notesManager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author olivia
 *
 */
public class BasicNotepaperManager implements NotepaperManager {
	
	private List<Notepaper> allDocs;
	
	BasicNotepaperManager(){
		this.allDocs = new ArrayList<Notepaper>();
	}

	@Override
	public Notepaper newNotepaper() {
		//BasicNotepaper newDoc = new BasicNotepaper();
		Notepaper newDoc = new SimpleNotepaper();
		this.updateNotepapersList(newDoc);
		return newDoc;
		
	}
	
	@Override
	public void updateNotepaper(String title, String updatedContent){
		
		try{
			Notepaper doc = this.getNotepaper(title);
			doc.setUpdatedContent(updatedContent);
		}catch(Exception e) {
			System.out.print("Cannot open Notepaper \n");
		}
		
	}
	
	/*Verify if Notepaper exists
	 * @param doc
	 * @returns True if exists
	 * @returns False if it doesnt
	 * */
	private boolean NotepaperExists(String title) {
		
		Iterator<Notepaper> iter = this.allDocs.iterator();
		
		while(iter.hasNext()) {
			Notepaper doc = iter.next();
			
			String currTitle = doc.getTitle();
			System.out.println("currTitle: " + currTitle);

			if (currTitle.equals(title)){
				return true;
			}
		}
		return false;
		
	}

	@Override
	public void deleteNotepaper(String docID) {
		System.out.println("Enter delete Notepaper");
		if (this.NotepaperExists(docID)) {
			System.out.println("Enter Notepaper exists \n");
			this.allDocs.remove(0);
		}
	}

	@Override
	public void renameNotepaper(String docID, String newName) throws Exception {
		if (this.nameConformsToGuidelines(newName)) {
			try {
				this.getNotepaper(docID).setUpdatedTitle(newName);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
			throw new Exception("Suggested name not complaint with standard");
		}
	}
	
	/* Check if suggested file name conforms to guidelines
	 * @param nameToCheck : name to check 
	 * @ return true if it adheres to guidelines
	 * @ return false if it doesn't
	 * */
	private boolean nameConformsToGuidelines(String nameToCheck) {
		return true;//TODO
	}

	/* returns existing Notepaper in list such that Notepaper.title.name == docID
	 * @param docID: Notepaper identifier
	 * @returns matchingNotepaper: Notepaper that matches the identifier 
	 * @throws Exception if Notepaper doesn't exist 
	 * */
	private Notepaper getNotepaper(String docID) throws Exception {
		Iterator<Notepaper> iter = this.allDocs.iterator();
		
		while(iter.hasNext()) {
			Notepaper doc = iter.next();
			
			String currTitle = doc.getTitle();
			System.out.println("currTitle: " + currTitle);
				
			if (currTitle.equals(docID)){
				return doc;
			}
			
		}
		throw new Exception("Notepaper not found");

	}
	
	@Override
	public void updateAccess(String docID, AccessStatus newStatus) {
		
		try{
			Notepaper doc = this.getNotepaper(docID);
			
			if (!newStatus.equals(null)) {
				doc.setUpdatedAccessStatus(newStatus);
			}
			
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("Cannot update access status");
		}
		
	}

	@Override
	public List<Notepaper> searchByTitle(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notepaper> searchByContent(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*Update Notepaper list with newly created Notepaper
	 * @param newDoc: new Notepaper we want to add to the list*/
	private void updateNotepapersList(Notepaper newDoc) {
		this.allDocs.add(newDoc);
	}
	
	protected List<Notepaper> getAllDocs(){
		return this.allDocs;
	}
	
	/** view Notepaper in a spring window*/
	@Override
	public void viewNotepaper(String docID) {
		try{
			Notepaper doc = this.getNotepaper(docID);
			this.viewInWindow(doc);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/** view txt file in window
	 * @param doc: Notepaper referring to the txt file
	 * */
	private void viewInWindow(Notepaper doc) {
		String content = doc.getContent();
		
		JFrame f = new JFrame("A JFrame");
	    f.setSize(400, 400);
	    f.setLocation(300,200);
	    final JTextArea textArea = new JTextArea(15, 40);
	    f.getContentPane().add(BorderLayout.CENTER, textArea);
	    final JButton button = new JButton("Click Me");
	    f.getContentPane().add(BorderLayout.SOUTH, button);
	    button.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            textArea.append(content);

	        }
	    });

	    f.setVisible(true);
	}
	
	
	/*Get Notepaper content text*/
	protected String getNotepaperData(String docID) throws Exception{
		try {
			Notepaper doc = this.getNotepaper(docID);
			String content = doc.getContent();
			return content;
		}catch(Exception e) {
			throw new Exception("Notepaper doesn't exist");
		}
	}
	
	/**Get Notepaper metadata*/
}
