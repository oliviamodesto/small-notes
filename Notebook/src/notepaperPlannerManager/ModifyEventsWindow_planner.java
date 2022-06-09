/**
 * 
 */
package notepaperPlannerManager;

import java.awt.BorderLayout;
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
public class ModifyEventsWindow_planner {

	public ModifyEventsWindow_planner(){
		
	}
	
	private void modifyEventWindow(BasicEventManager bem) {
		JFrame frame = new JFrame("Modify existing event");
		JPanel f = new JPanel();
		GridLayout gl = new GridLayout(3,2); // 4 rows, 2 columns
		f.setLayout(gl);
		
		
		frame.setSize(400, 400);
	    frame.setLocation(300,200);
	    
	    JLabel datelb = new JLabel("Date"); 
	    JTextField date = new JTextField("", 8);
	    f.add(datelb);
	    f.add(date);
	    
	    JLabel descriptionlb = new JLabel("Description");
	    JTextField description = new JTextField("", 10);
	    f.add(descriptionlb);
	    f.add(description);
	    
	    final JButton button = new JButton("Save");
	    f.add(BorderLayout.SOUTH, button);
	    
	    frame.add(f);
	    
	    button.addActionListener(new ActionListener() {
	      
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            String submittedDate = date.getText();
	            String submittedDescription = description.getText();
	            
	    		
	    		try {
	    			System.out.println("Enter try");
	    			bem.createNewEvent(submittedDate, submittedDescription);
	    			System.out.println(bem.viewAllEvents());
				} catch (Exception e1) {
					System.out.println(e1);
				}
	        }
	    });

	    frame.setVisible(true);

	}

}
