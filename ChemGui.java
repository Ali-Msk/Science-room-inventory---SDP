/**
 * ChemGui
 * runs all of the necessary gui for the chem inventory
 * @author 335607057
 * @date November 15 2017
 * Version 2.0
 */
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class ChemGui extends JFrame { 
  //arraylist of items
  private static ArrayList<Item> itemList=new ArrayList<Item>();
  
  //creating panels
  private JPanel mainPanel;
  private JPanel searchPane;
  private JPanel equipmentPane;
  private JPanel signOutPane;
  private JPanel helpPane;
  
  //to be replaced with a table
  private JPanel listPanel;
  
  //creating buttons
  //buttons for search page
  private JButton searchButton;
  private JButton replenishButton;
  private JButton addButton;
  private JButton infoButton;
  
  //Adding panels Gridlayout
  //for search page
  private JPanel searchPageGridLayout;// for search tab
  private JPanel infoGridLayout; // for the info side
  private JPanel searchGridLayout; // for when searching
  private JPanel searchBarGridLayout;
  private JPanel buttonGridLayout;
  
  //creating tabs
  private JTabbedPane programTab;
  
  //creating textfields
  //textfields for search page
  private JTextField searchTextField;
  private JTextField equipmentNameTF;
  private JTextField roomNumTF;
  private JTextField locationTF;
  private JTextField quantityTF;
  private JTextField numInStockTF;
  private JTextField teacherSignedOutTF;
  private JTextField numSignedOutTF;
  
  //creating labels
  //labels for search page
  private JLabel equipmentNameL;
  private JLabel roomNumL;
  private JLabel locationL;
  private JLabel quantityL;
  private JLabel numInStockL;
  private JLabel teacherSignedOutL;
  private JLabel numSignedOutL;
  
  
  ChemGui () throws Exception{
    
    JFrame myWindow = new JFrame("Contacts List");//creates a new window to work with
    myWindow.setSize(700,700);//set size of window by 700 by 700 pixals
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //sets the program to close when the window closes
    
    //table stuff
    //create columns
    String[] columns = new String[] { "Item Name", "Room Number", "Location", "Total Number"};
    
    
    //create data
    Object[][] data = new Object[itemList.size()][columns.length];
    
    for(int i=0;i<itemList.size();i++){
      data[i][0]=itemList.get(i).getEquipmentName();
      data[i][1]=itemList.get(i).getRoomNumber();
      data[i][2]=itemList.get(i).getLocation();
      data[i][3]=itemList.get(i).getTotalNumberOfItem();
      
    }
    
    
    //create table with data
    JTable table = new JTable(data, columns);// need to make private
    
    
    //add the table
    table.setModel(new MyTableModel(data, columns));
    table.setAutoCreateRowSorter(true);
    
    //creating panels
    mainPanel = new JPanel();
    equipmentPane = new JPanel();
    searchPane = new JPanel();
    signOutPane = new JPanel();
    helpPane = new JPanel();
    
    //panel for list(temporary)
    listPanel = new JPanel();
    
    //buttons
    //buttons for search page
    searchButton = new JButton("Search");
    replenishButton = new JButton("Replenish");
    addButton = new JButton("Add");
    infoButton = new JButton("Info");
    
    //Creating an action listener for buttons
    //action listeners for search
    searchButton.addActionListener(new searchButtonListener());
    replenishButton.addActionListener(new replenishButtonListener());
    addButton.addActionListener(new addButtonListener());
    infoButton.addActionListener(new infoButtonListener());
    
    //creating panels
    //panels for search tab
    //gridlayout panels
    searchPageGridLayout = new JPanel(new GridLayout(1,2));// for search tab
    infoGridLayout = new JPanel(new GridLayout(7,2)); // for the info side
    searchGridLayout = new JPanel(new GridLayout(3,1)); // for when searching
    searchBarGridLayout = new JPanel(new GridLayout(1, 2));//for the search bar
    buttonGridLayout = new JPanel(new GridLayout(1,3));
    
    //creating textfields
    //for search tab
    searchTextField = new JTextField();
    equipmentNameTF = new JTextField();
    roomNumTF = new JTextField();
    locationTF = new JTextField();
    quantityTF = new JTextField();
    numInStockTF = new JTextField();
    teacherSignedOutTF = new JTextField();
    numSignedOutTF = new JTextField();
    
    //creating labels
    //for search tab
    equipmentNameL = new JLabel("Equipment Name");
    roomNumL = new JLabel("Room Number");
    locationL = new JLabel("Location");
    quantityL = new JLabel("Quantity");
    numInStockL = new JLabel("Number in Stock");
    teacherSignedOutL = new JLabel("Teacher's Signed Out");
    numSignedOutL = new JLabel("Number Signed Out");
    
    //creating tabbed panes
    programTab = new JTabbedPane();
    
    //adding to buttonGridLayout
    buttonGridLayout.add(replenishButton);
    buttonGridLayout.add(infoButton);
    buttonGridLayout.add(addButton);
    
    //search bar layout
    searchBarGridLayout.add(searchTextField);
    searchBarGridLayout.add(searchButton);
    
    //info side layout
    infoGridLayout.add(equipmentNameL);
    infoGridLayout.add(equipmentNameTF);
    infoGridLayout.add(roomNumL);
    infoGridLayout.add(roomNumTF);
    infoGridLayout.add(locationL);
    infoGridLayout.add(locationTF);
    infoGridLayout.add(quantityL);
    infoGridLayout.add(quantityTF);
    infoGridLayout.add(numInStockL);
    infoGridLayout.add(numInStockTF);
    infoGridLayout.add(teacherSignedOutL);
    infoGridLayout.add(teacherSignedOutTF);
    infoGridLayout.add(numSignedOutL);
    infoGridLayout.add(numSignedOutTF);
    
    //searchGridLayout 
    searchGridLayout.add(searchBarGridLayout);
    searchGridLayout.add(table);
    searchGridLayout.add(buttonGridLayout);
    
    //adding to searchpage layout
    searchPageGridLayout.add(searchGridLayout);
    searchPageGridLayout.add(infoGridLayout);
    
    //adding to searchPane
    searchPane.add(searchPageGridLayout);
    
    //adding to equipmentPane
    
    //adding tabs
    programTab.add("Equipment List", equipmentPane);
    programTab.add("Search", searchPane);
    programTab.add("Sign Out", signOutPane);
    programTab.add("Help", helpPane);
    
    //adding to main panel
    mainPanel.add(programTab);
    mainPanel.add(programTab);
    mainPanel.add(programTab);
    mainPanel.add(programTab);
    //adding to window
    myWindow.add(mainPanel);
    myWindow.setVisible(true);
    
    
  }
  //make a new table model SUPER TEMPORARY LOCATION
  public class MyTableModel extends DefaultTableModel {
    
    public MyTableModel(Object[][] tableData, Object[] colNames) {
      super(tableData, colNames);
    }
    
    public boolean isCellEditable(int row, int column) {
      return false;
    }
  }
  
  
  
}
