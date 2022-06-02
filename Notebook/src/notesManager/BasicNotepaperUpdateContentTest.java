/**
 * 
 */
package notesManager;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author olivia
 *
 */
class BasicNotepaperManagerUpdateContentTest {

	
	public static void main(String[] args) {
		
		BasicNotepaperManager manager = new BasicNotepaperManager();
		manager.newNotepaper();
		try {
			String content = manager.getNotepaperData("Unknown");
		
			JFrame f = new JFrame("A JFrame");
		    f.setSize(400, 400);
		    f.setLocation(300,200);
		    final JTextArea textArea = new JTextArea(15, 40);
		    f.getContentPane().add(BorderLayout.CENTER, textArea);
		    final JButton button = new JButton("Click Me");
		    f.getContentPane().add(BorderLayout.SOUTH, button);
		    textArea.append(content);
		    button.addActionListener(new ActionListener() {
		      
		    	@Override
		        public void actionPerformed(ActionEvent e) {
		            String completeUpdate = textArea.getText();
		            manager.updateNotepaper("Unknown", completeUpdate);
		    		
		    		try {
		    			System.out.println("Notepaper data is: \n" + manager.getNotepaperData("Unknown"));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		    });

		    f.setVisible(true);
		    
		    
		
		}catch(Exception e) {
			System.out.print("Exception occured");
		}
		
		
		// view in GUI window
		//manager.updateNotepaper("Unknown");
		
		
		//testUpdateNotepaper1(contentUpdate);
	}
	
	
}
