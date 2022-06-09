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
public class DeleteWindow_planner {

	public DeleteWindow_planner() {
		
	}
	
	public void deleteEventWindow(BasicEventManager bem) {
		JFrame frame = new JFrame("Delete event");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(7,1); // 4 rows, 2 columns
		f.setLayout(gl);
		
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel datelb = new JLabel("Select events to delete"); 
	    JButton selectEv1 = new JButton("Event 1 name");
	    JButton selectEv2 = new JButton("Event 2 name");
	    JButton selectEv3 = new JButton("Event 3 name");
	    f.add(datelb);
	    f.add(selectEv1);
	    f.add(selectEv2);
	    f.add(selectEv3);
	    
	    final JButton proceed = new JButton("Proceed");
	    JButton back = new JButton("Back");
	    f.add(proceed);
	    f.add(back);
	    frame.add(f);
	    
	    selectEv1.addActionListener(new ActionListener() {
	    	private int numClicks = 0;
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO delete selected events
				this.numClicks++;
				// if numClicks > 0 and an event number => event is selected
				if ((numClicks > 0) && ((numClicks & 1) == 0)) {
					// add to list of events to remove
				}else {
					// check f on list of elements to remove
					// if it is, remove from list
					// else do nothing
				}
				
				// if numClicks == 0 or an odd number => event is not selected 
			}
	      
	    });
	    
	    proceed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO delete selected events
				
			}
	      
	    });

	    frame.setVisible(true);

	}

	
}
