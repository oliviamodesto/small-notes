/**
 * 
 */
package notepaperPlannerManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author olivia
 *
 */
public class window_planner {

	public window_planner() {
		
	}
	
	public void viewSingleEventWindow(BasicEventManager bem, String IDEvent) {
		try {
			String evDate = bem.getEventDate(IDEvent);
			String evDesc = bem.getEventDescription(IDEvent);
			
			this.singleEventWindow(bem, evDate, evDesc);
		}catch(Exception e) {
			this.cannotFindEventWindow();
		}
		
		
	}
	
	public void cannotFindEventWindow() {
		JFrame frame = new JFrame("Cannot find event!");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(2,1); // 4 rows, 2 columns
		f.setLayout(gl);
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel datelb = new JLabel("Cannot find event!"); 
	    f.add(datelb);
	    
	    JButton ok = new JButton("ok");
	    f.add(ok);
	    
	    frame.add(f);
	    
	    ok.addActionListener(new ActionListener() {
	      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	        	        }
	    });

	    frame.setVisible(true);

	}
	
	public void singleEventWindow(BasicEventManager bem, String evDate, String evDesc) {
		JFrame frame = new JFrame("Current event");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(3,2); // 4 rows, 2 columns
		f.setLayout(gl);
		
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel datelb = new JLabel("Date"); 
	    JTextField date = new JTextField(evDate, 8);
	    f.add(datelb);
	    f.add(date);
	    
	    JLabel descriptionlb = new JLabel("Description");
	    JTextField description = new JTextField(evDesc, 10);
	    f.add(descriptionlb);
	    f.add(description);
	    
	    final JButton save = new JButton("Save");
	    final JButton back = new JButton("Back");
	    f.add(save);
	    f.add(back);
	    frame.add(f);
	    
	    save.addActionListener(new ActionListener() {
	      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            String submittedDate = date.getText();
	            String submittedDescription = description.getText();
	            String toUpdate = "1"; //ID of event to update
	    		
	    		try {
	    			bem.updateDateEvent(toUpdate, submittedDate);
	    			bem.updateDescriptionEvent(toUpdate, submittedDescription);
	    		} catch (Exception e1) {
					this.cannotUpdateEventWindow();
				}
	        }
	    	
	    	private void cannotUpdateEventWindow() {
	    		JFrame frame = new JFrame("Cannot update event!");
	    		JPanel f = new JPanel();
	    		GridLayout gl = new GridLayout(2,1); // 4 rows, 2 columns
	    		f.setLayout(gl);
	    		
	    		frame.setSize(400, 400);
	    	    frame.setLocation(300,200);
	    	    
	    	    JLabel datelb = new JLabel("Cannot update event!"); 
	    	    f.add(datelb);
	    	    
	    	    JButton ok = new JButton("ok");
	    	    f.add(ok);
	    	    
	    	    frame.add(f);
	    	    
	    	    ok.addActionListener(new ActionListener() {
	    	      
	    	    	@Override
	    	        public void actionPerformed(ActionEvent e) {
	    	        	        }
	    	    });

	    	    frame.setVisible(true);

	    	}
	    });

	    frame.setVisible(true);
	}

	
}
