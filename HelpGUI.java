/* *
 * By Vincent Zhang
 * A Help tap that can add teacher Name
 * */
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
class HelpGUI extends JFrame {
  
  
  private JPanel mainPanel;
  
  //panel for searchtab
  private JPanel searchPanel;
  
  
  
  private JButton teacherButton;
  
  //Adding panels Gridlayout
  //for search page
  private JPanel teacherPageGridLayout;// for search tab
  private JPanel buttonGridLayout; // for the info side
  private JPanel teacherGridLayout; // for when searching
  private JPanel searchBarGridLayout;
  //creating tabs
  private JTabbedPane searchTab;
  
  //creating textfields
  //textfields for search page
  private JTextField teacherTextField;
  
  
  
  private JLabel equipmentNameL;
  
  
  HelpGUI () throws Exception{
    
    JFrame myWindow = new JFrame("Contacts List");//creates a new window to work with
    myWindow.setSize(700,700);//set size of window by 700 by 700 pixals
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //sets the program to close when the window closes
    
    mainPanel = new JPanel();

    
    
    teacherButton = new JButton("Enter");
    
    
     teacherTextField = new JTextField();
    teacherButton.addActionListener(new addButtonListener(teacherTextField));
    
    //creating panels
    //panels for search tab
    //gridlayout panels
    teacherPageGridLayout = new JPanel(new GridLayout(1,2));// for search tab
    buttonGridLayout = new JPanel(new GridLayout(7,2)); // for the info side
    teacherGridLayout = new JPanel(new GridLayout(3,1)); // for when searching
    searchBarGridLayout = new JPanel(new GridLayout(1, 2));//for the search bar
    buttonGridLayout = new JPanel(new GridLayout(1,3));
    
    //creating textfields
    //for search tab
   
    
    
    
    //adding to buttonGridLayout
      teacherGridLayout.add(teacherTextField);
    teacherGridLayout.add(teacherButton);
    
    //search bar layout
 
    
    teacherGridLayout.add(searchBarGridLayout);
    teacherGridLayout.add(buttonGridLayout);
    
    //adding to searchpage layout
    teacherPageGridLayout.add(teacherGridLayout);
    teacherPageGridLayout.add(buttonGridLayout);
    
    
    
    
    mainPanel.add(teacherPageGridLayout);
    
    //adding to window
    myWindow.add(mainPanel);
    myWindow.setVisible(true);
    
    
  }
  
  
}