import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.awt.*;

public class ChemGui extends JFrame {
	// ///////////////////NONE GUI STUFF//////////////////////////////
	ArrayList<Item> searched = ScienceLauncher.itemList;

	// /////////////////////////////////////////////////////////////////////

	// creating JTables
	private JTable searchTable;
	private JTable inventoryTable;

	// creating tabs
	private JTabbedPane programTab;

	// creating panels
	private JPanel mainPanel;
	// for search tab
	private JPanel infoPanel;
	private JPanel searchItemGrid;
	private JPanel searchPanel;
	// for inventory tab
	private JPanel inventoryPanel;

	/*
	 * //temp jpanel to be replaced with table private JPanel temp;
	 */

	// gridlayouts
	// for search tab
	private JPanel infoGrid;
	private JPanel searchButtonGrid;
	private JPanel searchTabGrid;// holds the enitre tab to be added to the
	// program to make it a tab
	private JPanel infoButtonGrid;

	// borderlayouts
	// for search tab
	private JPanel searchItemBorder;
	private JPanel searchBarBorder;
	private JPanel infoBorder;

	// creating buttons
	// buttons for search page
	private JButton searchButton;
	private JButton replenishButton;
	private JButton addButton;
	private JButton infoButton;
	private JButton saveButton;
	private JButton takeButton;

	// creating tabs
	// private JTabbedPane programTab;

	// creating textfields
	// textfields for search page
	JTextField searchTextField;
	private JTextField equipmentNameTF;
	private JTextField roomNumTF;
	private JTextField locationTF;
	private JTextField quantityTF;
	private JTextField numInStockTF;
	private JTextField teacherSignedOutTF;
	private JTextField numSignedOutTF;

	// creating labels
	// labels for search page
	private JLabel equipmentNameL;
	private JLabel roomNumL;
	private JLabel locationL;
	private JLabel quantityL;
	private JLabel numInStockL;
	private JLabel teacherSignedOutL;
	private JLabel numSignedOutL;
	private JLabel signedOutInfo;
	
	  //creating JComboBox
	  //for search page
	  private JComboBox teacherSearchCB;
	  String[] teacherSearch = {"A", "B", "C", "D", "E", "F" };// should be replaced with the list of teachers from the array

	ChemGui() throws Exception {
		JFrame myWindow = new JFrame("Contacts List");// creates a new window to
		// work with
		myWindow.setSize(1000, 555);// set size of window by 700 by 700 pixals
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the
		// program
		// to close
		// when the
		// window
		// closes

		// creating tabbed panes
		programTab = new JTabbedPane();

		// creating panels
		// for main program
		// mainPanel = new JPanel();
		// temp = new JPanel();//temporary

		// for search tab
		// for inventory tab
		inventoryPanel = new JPanel();
		
	    //creating JComboBoxes
	    teacherSearchCB = new JComboBox(teacherSearch);

		// creating grid layout
		mainPanel = new JPanel(new GridLayout(1, 1));
		// for search tab
		searchPanel = new JPanel(new GridLayout(1, 1));
		infoGrid = new JPanel(new GridLayout(7, 2));
		searchButtonGrid = new JPanel(new GridLayout(1, 3));
		searchTabGrid = new JPanel(new GridLayout(1, 2));
		searchItemGrid = new JPanel(new GridLayout(1, 1));
		infoPanel = new JPanel(new GridLayout(1, 1));
		infoButtonGrid = new JPanel(new GridLayout(1, 2));

		// creating buttons
		// for search tab
		searchButton = new JButton("Search");
		replenishButton = new JButton("Replenish");
		infoButton = new JButton("Information");
		addButton = new JButton("Add");
		saveButton = new JButton("Save Information");
		takeButton = new JButton("Sign Out/ Sign In");

		// creating action listeners
		// for search tab
		searchButton.addActionListener(new searchButtonListener());
		replenishButton.addActionListener(new replenishButtonListener());
		infoButton.addActionListener(new infoButtonListener());
		addButton.addActionListener(new addButtonListener());
		takeButton.addActionListener(new takeButtonListener());
		saveButton.addActionListener(new saveButtonListener());
		// creating textfields
		// for search tab
		searchTextField = new JTextField("Enter Search");
		equipmentNameTF = new JTextField();
		roomNumTF = new JTextField();
		locationTF = new JTextField();
		quantityTF = new JTextField();
		numInStockTF = new JTextField();
		teacherSignedOutTF = new JTextField();
		numSignedOutTF = new JTextField();

		// creating labels
		// for search tab
		equipmentNameL = new JLabel(" Equipment Name: ");
		roomNumL = new JLabel(" Room Number: ");
		locationL = new JLabel(" Location: ");
		quantityL = new JLabel(" Total Quantity: ");
		numInStockL = new JLabel(" Number in Stock: ");
		teacherSignedOutL = new JLabel(" Teacher's Signed Out: ");
		numSignedOutL = new JLabel(" Number Signed Out: ");
		signedOutInfo = new JLabel(" ");

		// creating border layout

		// for search tab
		searchItemBorder = new JPanel();
		searchBarBorder = new JPanel();
		infoBorder = new JPanel();

		// vincent's code: (adding the table in)
		// inventory part
		String[] inventoryColumns = new String[] { "Equipment Name", "Room Number", "Location", "Total Number",
				"Number Available", "Who Signed It Out", "# Signed Out" };
		// create data
		Object[][] inventoryData = new Object[ScienceLauncher.itemList.size()][inventoryColumns.length];

		for (int i = 0; i < ScienceLauncher.itemList.size(); i++) {
			inventoryData[i][0] = ScienceLauncher.itemList.get(i).getEquipmentName();
			inventoryData[i][1] = ScienceLauncher.itemList.get(i).getRoomNumber();
			inventoryData[i][2] = ScienceLauncher.itemList.get(i).getLocation();
			inventoryData[i][3] = ScienceLauncher.itemList.get(i).getTotalNumberOfItem();
			inventoryData[i][4] = ScienceLauncher.itemList.get(i).getNumLeft();
			inventoryData[i][5] = ScienceLauncher.itemList.get(i).getSignOutName();
			inventoryData[i][6] = ScienceLauncher.itemList.get(i).getTotalNumberOfItem()
					- ScienceLauncher.itemList.get(i).getNumLeft();

		}
		// search part
		// needed to change item placement
		String[] searchColumns = new String[] { "Equipment Name", "Room Number", "Location", "Total Number",
				"Number Available", "Who Signed It Out" };
		// create data
		Object[][] searchData = new Object[searched.size()][searchColumns.length];

		for (int i = 0; i < searched.size(); i++) {
			searchData[i][0] = searched.get(i).getEquipmentName();
			searchData[i][1] = searched.get(i).getRoomNumber();
			searchData[i][2] = searched.get(i).getLocation();
			searchData[i][3] = searched.get(i).getTotalNumberOfItem();
			searchData[i][4] = searched.get(i).getNumLeft();
			searchData[i][5] = searched.get(i).getSignOutName();
			// searchData[i][6]=ScienceLauncher.itemList.get(i).getTotalNumberOfItem()-ScienceLauncher.itemList.get(i).getNumLeft();

		}

		// create table with data
		searchTable = new JTable(searchData, searchColumns);
		// creating the inventory tab table
		inventoryTable = new JTable(inventoryData, inventoryColumns);

		// add the table
		// to search table
		searchTable.setModel(new MyTableModel(searchData, searchColumns));
		searchTable.setAutoCreateRowSorter(true);
		// searchTable.setSize(600,300);
		// for inventory tab table
		inventoryTable.setModel(new MyTableModel(inventoryData, inventoryColumns));
		inventoryTable.setAutoCreateRowSorter(true);

		// adding to grid layout
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
		infoGrid.add(teacherSearchCB);
		infoGrid.add(numSignedOutL);
		infoGrid.add(signedOutInfo);

		// search button grid
		searchButtonGrid.add(replenishButton);
		searchButtonGrid.add(infoButton);
		searchButtonGrid.add(takeButton);

		// info button grid
		infoButtonGrid.add(addButton);
		infoButtonGrid.add(saveButton);

		// adding to border layout
		// for inventory tab
		inventoryPanel.setLayout(new BorderLayout());
		inventoryPanel.add(new JScrollPane(inventoryTable), BorderLayout.CENTER);
		// for search tab
		// searchBarBorder
		searchBarBorder.setLayout(new BorderLayout());
		searchBarBorder.add(searchTextField, BorderLayout.CENTER);
		searchBarBorder.add(searchButton, BorderLayout.LINE_END);
		// search item border
		searchItemBorder.setLayout(new BorderLayout());
		searchItemBorder.add(searchBarBorder, BorderLayout.NORTH);
		searchItemBorder.add(new JScrollPane(searchTable), BorderLayout.CENTER);
		searchItemBorder.add(searchButtonGrid, BorderLayout.SOUTH);
		// for infoBorder
		infoBorder.setLayout(new BorderLayout());
		infoBorder.add(infoGrid, BorderLayout.CENTER);
		infoBorder.add(infoButtonGrid, BorderLayout.SOUTH);
		/*
		 * //setting for search panel searchPanel.setLayout(new BorderLayout());
		 */

		// Adding to panels
		// for inventory tab
		// inventoryPanel.add(inventoryTable);
		// for search tab
		// item panel
		infoPanel.add(infoBorder);

		// searchItemGrid
		searchItemGrid.add(searchItemBorder);
		// searchTabGrid
		searchTabGrid.add(searchItemGrid);
		searchTabGrid.add(infoPanel);
		// searchTabGrid.setSize(myWindow.getHeight(),myWindow.getWidth());
		searchPanel.add(searchTabGrid);

		// adding to tab
		programTab.addTab("Equipment Inventory", inventoryPanel);
		programTab.add("Search", searchPanel);

		// adding to mainPanel
		mainPanel.add(programTab);
		// adding to window
		myWindow.add(mainPanel);
		myWindow.setVisible(true);

	}

	// Vincents Code
	public class MyTableModel extends DefaultTableModel {

		public MyTableModel(Object[][] tableData, Object[] colNames) {
			super(tableData, colNames);
		}

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	/**
	 * searchButtonListener takes the text entered and searches for items with that
	 * name and updates
	 * 
	 * @author: Ali Meshkat
	 * 
	 * @date: Nov 20th
	 * 
	 * @instructor: MR.Mangat
	 */
	public class searchButtonListener implements ActionListener {

		//@Override
		public void actionPerformed(ActionEvent e) {
			String searchFor = searchTextField.getText(); // takes text
			searched = search(searchFor, ScienceLauncher.itemList); // runs the search method
			updateTables(); // updates the tables
		}

	}

	/**
	 * searchButtonListener updates the info for the selected item
	 * takks input from the other text fields to edit the info of the selected item from the list
	 * @author: Ali Meshkat
	 * @date: Nov 20th
	 * @instructor: MR.Mangat
	 */
	public class replenishButtonListener implements ActionListener {

		//@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(searchTable.getSelectedRow());
			if (!equipmentNameTF.getText().equals("")){
				ScienceLauncher.itemList.get(searchTable.getSelectedRow()).setEquipmentName(equipmentNameTF.getText());
			}
			if (!roomNumTF.getText().equals("")){
				ScienceLauncher.itemList.get(searchTable.getSelectedRow()).setRoomNum(roomNumTF.getText());
			}
			if (!locationTF.getText().equals("")){
				ScienceLauncher.itemList.get(searchTable.getSelectedRow()).setLocation(locationTF.getText());
			}
			if (!quantityTF.getText().equals("")){
				ScienceLauncher.itemList.get(searchTable.getSelectedRow()).setTotal(quantityTF.getText());
			}
		/*	equipmentNameTF.setText(ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getEquipmentName());
			roomNumTF.setText("" + ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getRoomNumber());
			locationTF.setText(ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getLocation());
			quantityTF.setText("" + ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getTotalNumberOfItem());
			numInStockTF.setText("" + ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getNumLeft());*/
			System.out.println("replenished");
			updateTables();

		}

	}

	/**
	 * searchButtonListener shows info for the selected item
	 * 
	 * @author: Ali Meshkat
	 * 
	 * @date: Nov 20th
	 * 
	 * @instructor: MR.Mangat
	 */
	public class infoButtonListener implements ActionListener {

		//@Override
		public void actionPerformed(ActionEvent e) {
			equipmentNameTF.setText(ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getEquipmentName());
			roomNumTF.setText("" + ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getRoomNumber());
			locationTF.setText(ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getLocation());
			quantityTF.setText("" + ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getTotalNumberOfItem());
			numInStockTF.setText("" + ScienceLauncher.itemList.get(searchTable.getSelectedRow()).getNumLeft());
		}

	}

	/**
	 * addButtonListener takes info from the textfields and uses them to create a
	 * new object
	 * @author: Ali Meshkat
	 * @date: Nov 20th
	 * @instructor: MR.Mangat
	 */
	public class addButtonListener implements ActionListener {

		//@Override
		public void actionPerformed(ActionEvent e) {

			// takes text from text fields
			String name = equipmentNameTF.getText();
			String roomNum = roomNumTF.getText();
			String location = locationTF.getText();
			String quantity = quantityTF.getText();

			ScienceLauncher.itemList.add(new Item(name, roomNum, location, quantity, quantity)); // adds to list
			updateTables(); // updates tables
			equipmentNameTF.setText("");
			roomNumTF.setText("");
			locationTF.setText("");
			quantityTF.setText("");
			numInStockTF.setText("");

	

		}

	}

	public class takeButtonListener implements ActionListener {
		  
		  
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
	
	/**
	 * saveButtonListener
	 * saves the added or changed items to the .txt file
	 * @author Israel Shpilman
	 * @date 11/22/2017
	 *
	 */
	public class saveButtonListener implements ActionListener {

		//@Override
		public void actionPerformed(ActionEvent e) {
			ScienceLauncher.saveToFile(ScienceLauncher.itemList);
		}

	}

	/*
	 * search searches for the piece of string inputed in items(names)
	 * 
	 * @param: a string to search for and the arrayList of the items
	 * 
	 * @return: returns a new arraylist containing all the items with the str as
	 * part of their name(not case sensitive)
	 * 
	 * @author: Ali Meshkat
	 */
	public static ArrayList<Item> search(String str, ArrayList<Item> items) {
		ArrayList<Item> found = new ArrayList<Item>(); // new arrayList to return
		
		for (int i = 0; i <= items.size() - 1; i++) { // runs through items
			if (items.get(i).getEquipmentName().toLowerCase().indexOf(str.toLowerCase()) != -1) { // if name contains
																									// str(not case
																									// sensitive)
				found.add(items.get(i)); // add
			}
		}
		return found;
	}

	/**
	 * updateTables
	 * updates the tables with their new values
	 * @return: void
	 * @param: none
	 */
	public void updateTables() {
		// updates search table
		String[] searchColumns = new String[] { "Item Name", "Room Number", "Location", "Total Number",
				"Number Available", "Who Signed It Out" };
		Object[][] searchData = new Object[searched.size()][searchColumns.length];

		for (int i = 0; i < searched.size(); i++) {
			searchData[i][0] = searched.get(i).getEquipmentName();
			searchData[i][1] = searched.get(i).getRoomNumber();
			searchData[i][2] = searched.get(i).getLocation();
			searchData[i][3] = searched.get(i).getTotalNumberOfItem();
			searchData[i][4] = searched.get(i).getNumLeft();
			searchData[i][5] = searched.get(i).getSignOutName();
		}
		
		searchTable.setModel(new MyTableModel(searchData, searchColumns));

		// updates main table
		String[] inventoryColumns = new String[] { "Item Name", "Room Number", "Location", "Total Number",
				"Number Available", "Who Signed It Out", "# Signed Out" };
		// create data
		Object[][] inventoryData = new Object[ScienceLauncher.itemList.size()][inventoryColumns.length];

		for (int i = 0; i < ScienceLauncher.itemList.size(); i++) {
			inventoryData[i][0] = ScienceLauncher.itemList.get(i).getEquipmentName();
			inventoryData[i][1] = ScienceLauncher.itemList.get(i).getRoomNumber();
			inventoryData[i][2] = ScienceLauncher.itemList.get(i).getLocation();
			inventoryData[i][3] = ScienceLauncher.itemList.get(i).getTotalNumberOfItem();
			inventoryData[i][4] = ScienceLauncher.itemList.get(i).getNumLeft();
			inventoryData[i][5] = ScienceLauncher.itemList.get(i).getSignOutName();
			inventoryData[i][6] = ScienceLauncher.itemList.get(i).getTotalNumberOfItem()
					- ScienceLauncher.itemList.get(i).getNumLeft();

		}
		inventoryTable.setModel(new MyTableModel(inventoryData, inventoryColumns));

	}

}