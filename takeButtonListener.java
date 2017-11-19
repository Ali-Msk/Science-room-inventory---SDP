/**
 * takeButtonListener
 * when an item is selected a window will pop up asking if the user is signing stuff in or singing stuff out
 * If they click sign in, they will select their name, a list of their items will appear and they will select the item to sign in
 * If they click sign out, a window will pop up with the item they selected, and will ask for them to select their name and the number they wish to sign out
 * @author Israel Shpilman
 * @date November 15 2017
 * Version 1.0
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class takeButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//should only activate if an item is selected and the take button is clicked
		Object[] options = { "Sign In", "Sign Out" };
	    int selection = JOptionPane.showOptionDialog(null, "Are you signing some equipment in or out", "Equipment Inventory",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
	    System.out.println("Selection: " + selection);
	    if (selection == 0) {
	    	//have to add a dropdown list for them to select their names and for the equipment to show up for them to select to sign in
	    	 int signIn = JOptionPane.showOptionDialog(null, "Are you signing some equipment in or out", "Equipment Inventory",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
	 	    System.out.println("Sign In: " + signIn);
	    }

	}

}
