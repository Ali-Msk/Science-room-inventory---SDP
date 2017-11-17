
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TestGui extends JFrame{
	//creating tabs
	  private JTabbedPane programTab;

	//creating panels
	private JPanel mainPanel;
	//for search tab
	private JPanel infoPanel;
	private JPanel searchItemPanel;
	private JPanel searchTabPanel;
	
	//temp jpanel to be replaced with table
	private JPanel temp;

	
	//gridlayouts
	//for search tab
	private JPanel infoGrid;
	private JPanel searchButtonGrid;
	
	//borderlayouts
	//for search tab
	private JPanel searchItemBorder;
	private JPanel searchBarBorder;
	
	//creating buttons
	  //buttons for search page
	  private JButton searchButton;
	  private JButton replenishButton;
	  private JButton addButton;
	  private JButton infoButton;
	  
	  
	  //creating tabs
	 // private JTabbedPane programTab;
	  
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
	  
	  TestGui () throws Exception{
		    
		    JFrame myWindow = new JFrame("Contacts List");//creates a new window to work with
		    myWindow.setSize(700,700);//set size of window by 700 by 700 pixals
		    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //sets the program to close when the window closes
		    
		    //creating tabbed panes
		    programTab = new JTabbedPane();
		    
		    //creating panels
		    mainPanel = new JPanel();
		    temp = new JPanel();//temporary
		    
		    //for search tab
		    infoPanel = new JPanel();
		    searchItemPanel = new JPanel();
		    
		    
		    //creating grid layout
		    
		    //for search tab
		    infoGrid = new JPanel(new GridLayout(7, 2));
		    searchButtonGrid = new JPanel(new GridLayout(1, 3));
		    searchTabPanel = new JPanel(new GridLayout(1, 2));
		    //creating buttons
		    //for search tab
		    searchButton = new JButton("Search");
		    replenishButton = new JButton("Replenish");
		    infoButton = new JButton("Information");
		    addButton = new JButton("Add");
		    
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
		    equipmentNameL = new JLabel("Equipment Name: ");
		    roomNumL = new JLabel("Room Number: ");
		    locationL = new JLabel("Location: ");
		    quantityL = new JLabel("Quantity: ");
		    numInStockL = new JLabel("Number in Stock: ");
		    teacherSignedOutL = new JLabel("Teacher's Signed Out: ");
		    numSignedOutL = new JLabel("Number Signed Out: ");
		    
		    //creating border layout
		    
		    //for search tab
		    searchItemBorder = new JPanel();
		    searchBarBorder = new JPanel();
		    
		    //adding to grid layout
		    // for search tab
		    // info grid layout
		    infoGrid.add(equipmentNameL);
		    infoGrid.add(equipmentNameTF);
		    infoGrid.add(roomNumL);
		    infoGrid.add(roomNumTF);
		    infoGrid.add(locationL);
		    infoGrid.add(locationTF);
		    infoGrid.add(quantityL);
		    infoGrid.add(quantityTF);
		    infoGrid.add(numInStockL);
		    infoGrid.add(numInStockTF);
		    infoGrid.add(teacherSignedOutL);
		    infoGrid.add(teacherSignedOutTF);
		    infoGrid.add(numSignedOutL);
		    infoGrid.add(numSignedOutTF);
		    
		    //search button grid
		    searchButtonGrid.add(replenishButton);
		    searchButtonGrid.add(infoButton);
		    searchButtonGrid.add(addButton);
		    
		    //adding to border layout
		    //for search tab
		    //searchBarBorder
		    searchBarBorder.setLayout(new BorderLayout());
		    searchBarBorder.add(searchTextField,BorderLayout.CENTER);
		    searchBarBorder.add(searchButton, BorderLayout.LINE_END);
		    //search item border
		    searchItemBorder.setLayout(new BorderLayout());
		    searchItemBorder.add(searchBarBorder, BorderLayout.NORTH);
		    searchItemBorder.add(temp, BorderLayout.CENTER);
		    searchItemBorder.add(searchButtonGrid, BorderLayout.SOUTH);
		    //setting for main panel
		    mainPanel.setLayout(new BorderLayout());
		    
		    //Adding to panels
		    //for search tab
		    // item panel
		    infoPanel.add(infoGrid);
		    
		    //searchItemPanel
		    searchItemPanel.add(searchItemBorder);
		    //searchTabPanel
		    searchTabPanel.add(searchItemPanel);
		    searchTabPanel.add(infoPanel);
		    //searchTabPanel.setSize(myWindow.getHeight(),myWindow.getWidth());
		    
		    // adding to tab
		    programTab.add("Search", searchTabPanel);
		    
		    //adding to window
		    myWindow.add(programTab);
		    myWindow.setVisible(true);
	  }
	
}
