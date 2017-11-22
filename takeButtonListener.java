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

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class takeButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//should only activate if an item is selected and the take button is clicked
		Object[] options = { "Sign In", "Sign Out" };
	    int selection = JOptionPane.showOptionDialog(null, "Are you signing some equipment in or out", "Equipment Inventory",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
	    System.out.println("Selection: " + selection);
	    if (selection == 0) {
	    	 String[] signIn = { "A", "B", "C", "D", "E", "F" };
	    	    String input = (String) JOptionPane.showInputDialog(null, "Select your name and it will sign in all of your equipment.", "Equipment Inventory", JOptionPane.INFORMATION_MESSAGE, null, signIn, signIn[1]);
	    	    System.out.println(input);
	    }else if(selection == 1){
	    	String[] signOut = {"A", "B", "C", "D", "E", "F" };// should be replaced with the list of teachers from the array
	    	JComboBox teacherNames = new JComboBox(signOut);
	    	JTextField amount = new JTextField(5);
	    	 JPanel myPanel = new JPanel();
	         myPanel.add(new JLabel("Amount: "));
	         myPanel.add(amount);
	         myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	         myPanel.add(new JLabel("Name: "));
	         myPanel.add(teacherNames);
	         int result = JOptionPane.showConfirmDialog(null, myPanel, "Sign Out", JOptionPane.OK_CANCEL_OPTION);
	         if (result == JOptionPane.OK_OPTION) {
	             System.out.println("Teacher Name: " +signOut[teacherNames.getSelectedIndex()] );//+ petList.setSelectedIndex(result));
	             System.out.println("Amount Value: " + amount.getText());
	          }

	    	//Create the combo box, select item at index 4.
	    	//Indices start at 0, so 4 specifies the pig.
	    	//JComboBox petList = new JComboBox(signOut);
	    	//petList.setSelectedIndex(4);
	    	//petList.addActionListener(this);
	    }
	    

	}

}
