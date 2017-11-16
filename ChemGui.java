/**
 * ChemGui
 * runs all of the necessary gui for the chem inventory
 * @author 335607057
 * @date November 15 2017
 * Version 1.0
 */
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

class ChemGui extends JFrame { 
	//creating panels
	private JPanel mainPanel;
	
	//panel for searchtab
	private JPanel searchPanel;
	
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
	private JTabbedPane searchTab;
	private JTabbedPane equipmentTab;
	private JTabbedPane signoutTab;
	private JTabbedPane helpTab;
	
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
	    
	    //creating panels
	    mainPanel = new JPanel();
	    //panel for search
	    searchPanel = new JPanel();
	    
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
		searchGridLayout.add(searchPanel);
		searchGridLayout.add(buttonGridLayout);
		
		//adding to searchpage layout
		searchPageGridLayout.add(searchGridLayout);
		searchPageGridLayout.add(infoGridLayout);
		
		//adding tabs
		//add in future
		
		//adding to main panel
		mainPanel.add(searchPageGridLayout);
		
	    //adding to window
	    myWindow.add(mainPanel);
	    myWindow.setVisible(true);
		

	}
	
  
  
}
