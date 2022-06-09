/**
 * 
 */

/**
 * @author olivia
 *
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import notepaperPlannerManager.BasicEventManager;
import notepaperPlannerManager.window_planner;
import notepaperPlannerManager.CreateWindow_planner;
import notepaperPlannerManager.ViewEventsWindow_planner;
import notepaperPlannerManager.ModifyEventsWindow_planner;
import notepaperPlannerManager.DeleteWindow_planner;

//TODO: ONLY ONE WINDOW AT THE TIME !!!
public class Planner_interface {

	private static window_planner wp = new window_planner();
	private static CreateWindow_planner cwp = new CreateWindow_planner();
	private static BasicEventManager bem = new BasicEventManager();
	private static ViewEventsWindow_planner vew = new ViewEventsWindow_planner();
	private static ModifyEventsWindow_planner mew = new ModifyEventsWindow_planner(); 
	private static DeleteWindow_planner dw = new DeleteWindow_planner();
	
	public static void main(String[] args) {

		beginWindow(bem);
		
	}

	// begin window
	// ask: what would you like to do ?
	// create new event
	// view existing events
	// update events
	// settings
	private static void beginWindow(BasicEventManager bem) {
		JFrame frame = new JFrame("Start window");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(7,1); // 5 rows, 1 column
		f.setLayout(gl);
		
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel title = new JLabel("What wold you like to do?"); 
	    JButton createEventButton = new JButton("Create new event");
	    JButton viewEventButton = new JButton("View my events");
	    JButton modifyEventButton = new JButton("Update events");
	    JButton deleteEventButton = new JButton("Delete events");
	    JButton Settings = new JButton("Settings");
	    JButton Exit = new JButton("Exit");
	    
	    f.add(title);
	    f.add(createEventButton);
	    f.add(viewEventButton);
	    f.add(modifyEventButton);
	    f.add(deleteEventButton);
	    f.add(Settings);
	    f.add(Exit);
	    
	    frame.add(f);
	    frame.setVisible(true);

	    createEventButton.addActionListener(new ActionListener() {
	      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            cwp.createWindow(bem);
	            
	        }
	    });

	    //viewEventButton
	    viewEventButton.addActionListener(new ActionListener() {
		      
		    	@Override
		        public void actionPerformed(ActionEvent e) {
		            vew.viewEventsWindow(bem);
		            
		        }
		    });
	    
	    //modifyEventButton
	    modifyEventButton.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            selectEventWindow(bem);
	            
	        }
	    });
	    
	    //delete event button
	    deleteEventButton.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            dw.deleteEventWindow(bem);
	            
	        }
	    });
	    
	    //Settings
	    Settings.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            settingsWindow(bem);
	            
	        }
	    });
	    
	    //Exit
	    Exit.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            exitWindow(bem);
	            
	        }
	    });
 
	    
	}
	
	
	private static void settingsWindow(BasicEventManager bem) {
		
	}
	
	private static void exitWindow(BasicEventManager bem) {
		
	}
	
	
	private static void selectEventWindow(BasicEventManager bem) {
		JFrame frame = new JFrame("Select event");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(7,1); // 4 rows, 2 columns
		f.setLayout(gl);
		
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel datelb = new JLabel("Select event to update"); 
	    JButton selectEv1 = new JButton("Event 1 name");
	    JButton selectEv2 = new JButton("Event 2 name");
	    JButton selectEv3 = new JButton("Event 3 name");
	    f.add(datelb);
	    f.add(selectEv1);
	    f.add(selectEv2);
	    f.add(selectEv3);
	    
	    //final JButton proceed = new JButton("Proceed");
	    JButton back = new JButton("Back");
	    //f.add(proceed);
	    f.add(back);
	    frame.add(f);
	    
	    selectEv1.addActionListener(new ActionListener() {
	    	String IDEvent = "1";
	    	@Override
			public void actionPerformed(ActionEvent e) {
	    		wp.viewSingleEventWindow(bem, IDEvent);  		
	    	}
	      
	    });
	    
	    frame.setVisible(true);


	}
	

	/*
		private static void viewSingleEventWindow(BasicEventManager bem, String IDEvent) {
		try {
			String evDate = bem.getEventDate(IDEvent);
			String evDesc = bem.getEventDescription(IDEvent);
			
			wp.singleEventWindow(evDate, evDesc);
		}catch(Exception e) {
			wp.cannotFindEventWindow();
		}
		
		
	}
	*/
}

