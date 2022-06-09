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
public class CreateWindow_planner {
	
	public CreateWindow_planner() {
		
	}
		// call create new event: window requesting date and description of event and confirm
		public void createWindow(BasicEventManager bem) {
			JFrame frame = new JFrame("Create new event");
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
