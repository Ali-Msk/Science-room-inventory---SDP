import javax.swing.*;
import java.awt.event.*;

class GUIIO{
  
  static JTextField nameField;
  static JLabel messageLabel;
  static JButton clickButton;
  
  public static void main(String[]args){
    JFrame myWindow = new JFrame("");  //creates a new window with a title
    myWindow.setSize(100,100); //set the size of my window to 400 by 400 pixels
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //sets the program to close when the window closes
    
    
    
    JPanel mainPanel = new JPanel();
    nameField = new JTextField("TextField 1");
    messageLabel = new JLabel("Label 1"); 
    //adds a button
    clickButton = new JButton("click me"); 
    
    // add a listener to the button (makes the button active)
    clickButton.addActionListener(new clickButtonListener()); 
    mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
    mainPanel.add(nameField);
    mainPanel.add(messageLabel);
    
    mainPanel.add(clickButton);
    myWindow.add(mainPanel);
    myWindow.setVisible(true);
    
  }
  
  static class clickButtonListener implements ActionListener {
    public  void actionPerformed(ActionEvent event) { 
      
      String userName;
      
      userName = nameField.getText(); //gets data from a field
      
      messageLabel.setText("Hello " + userName); // set a text of a label
      
    }
  }
}
