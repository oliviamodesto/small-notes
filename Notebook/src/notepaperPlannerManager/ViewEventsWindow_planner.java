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

/**
 * @author olivia
 *
 */
public class ViewEventsWindow_planner {

	public ViewEventsWindow_planner(){
		
	}
	
	public void viewEventsWindow(BasicEventManager bem) {
		
		JFrame frame = new JFrame("View Events window");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(6,1); // 5 rows, 1 column
		f.setLayout(gl);
		
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel title = new JLabel("View events:"); 
	    JButton allEvents = new JButton("View all events");
	    JButton todayEvents = new JButton("View today's events");
	    JButton onDateEvents = new JButton("View events on date");
	    JButton keywordEvents = new JButton("View events with keyword");
	    JButton Back = new JButton("Back");
	    
	    f.add(title);
	    f.add(allEvents);
	    f.add(todayEvents);
	    f.add(onDateEvents);
	    f.add(keywordEvents);
	    f.add(Back);
	    
	    frame.add(f);
	    frame.setVisible(true);

	    allEvents.addActionListener(new ActionListener() {
	      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            //TODO: view all events
	            
	        }
	    });

	    todayEvents.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	    		// TODO: view todays events
	        }
	    });
	    
	    onDateEvents.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            //TODO: ask for date
	    		//view events on same window
	            
	        }
	    });
	    
	    keywordEvents.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            //TODO: ask for keyword
	    		//view events on same window	            
	        }
	    });
	    
	    Back.addActionListener(new ActionListener() {
		      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            //TODO: return to start window
	        }
	    });

	}
	
}
