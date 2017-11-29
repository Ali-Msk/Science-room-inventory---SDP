import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;
import java.awt.*;

public class ChemGui extends JFrame {
  private ArrayList<Item> searched;
  private JPanel teacherPanel;
  private JLabel signedOutInfo;
  private JComboBox teacherSearchCB;    // creating JComboBox  for search page
 private  String[] teacherSearch = { "A", "B", "C", "D", "E", "F" };// should be replaced with the list of teachers from the array
 
  private JTable searchTable;  //creating JTables
  private JTable inventoryTable;  //creating JTables
  
  private JTabbedPane programTab;  // creating tabs
  

  private JPanel mainPanel;    // creating panels
  
  private JPanel infoPanel;  // for search tab
  private JPanel searchItemGrid;  // for search tab
  private JPanel searchPanel;  // for search tab

  private JPanel inventoryPanel;  // for inventory tab
  
  // gridlayouts
  // for search tab
  private JPanel infoGrid;
  private JPanel searchButtonGrid;
  private JPanel searchTabGrid;// holds the enitre tab to be added to the program to make it a tab
  private JPanel infoButtonGrid;
  private int  selected=0;
  
  
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
  
  
  // creating textfields
  // textfields for search page
  private  JTextField searchTextField;
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
  
  // teacher tab
  private JTable tableAllTeacher;
  private JButton newTeacherToDepartmentButton;
  private JButton deleteTeacherToDepartmentButton;
  private JPanel teacherPageGridLayout;
  private JPanel teacherLayout;
  private JTextField teacherTextField;
  private JTable table;
  private JTable tableTeacher;
  private ScienceLauncher superFrame;
  
  
  ChemGui( ScienceLauncher superFrame) throws Exception {
    this.superFrame=superFrame;
    JFrame myWindow = new JFrame("Contacts List");// creates a new window to
    // work with
    myWindow.setSize(1000, 555);// set size of window by 700 by 700 pixals
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the
    // program
    // to close
    // when the
    // window
    // closes
    searched =superFrame.getItemList();
    // vincent 2 end
    
    // creating JComboBoxes
    teacherSearchCB = new JComboBox(teacherSearch);
    
    // creating tabbed panes
    programTab = new JTabbedPane();
    
    // creating panels
    // for main program
    // mainPanel = new JPanel();
    
    // for search tab
    // for inventory tab
    inventoryPanel = new JPanel();
    tableAllTeacher = new JTable();
    teacherPanel = new JPanel(new GridLayout(1, 1));
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
    searchTextField = new JTextField("");
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
    numInStockL = new JLabel(" Number Available: ");
    teacherSignedOutL = new JLabel(" Teacher's Signed Out: ");
    numSignedOutL = new JLabel(" Number Signed Out: ");
    signedOutInfo = new JLabel("testingggg");
    
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
    Object[][] inventoryData = new Object[superFrame.getItemList().size()][inventoryColumns.length];
    
    for (int i = 0; i <superFrame.getItemList().size(); i++) {
      inventoryData[i][0] =superFrame.getItemList().get(i).getEquipmentName();
      inventoryData[i][1] =superFrame.getItemList().get(i).getRoomNumber();
      inventoryData[i][2] =superFrame.getItemList().get(i).getLocation();
      inventoryData[i][3] =superFrame.getItemList().get(i).getTotalNumberOfItem();
      inventoryData[i][4] =superFrame.getItemList().get(i).getNumLeft();
      inventoryData[i][5] =superFrame.getItemList().get(i).getSignOutName();
      inventoryData[i][6] =superFrame.getItemList().get(i).getTotalNumberOfItem()
        -superFrame.getItemList().get(i).getNumLeft();
      
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
      // searchData[i][6]=superFrame.getItemList().get(i).getTotalNumberOfItem()-superFrame.getItemList().get(i).getNumLeft();
      
    }
    
    // create table with data
    searchTable = new JTable(searchData, searchColumns);
    searchTable.addMouseListener(new MyMouseListener2()); //adds a mouse listerner to search table
    searchTable.setFont(new Font ("Dialog", Font.BOLD, 15));
    searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    //searchTable.getColumn(1).setPreferredWidth(100);    
    
    // creating the inventory tab table
    inventoryTable = new JTable(inventoryData, inventoryColumns);
    
    // add the table
    // to search table
    searchTable.setModel(new MyTableModel(searchData, searchColumns));
    searchTable.setAutoCreateRowSorter(true);
    
    
    //is used to set sizes for each column 
    TableColumnModel columModel = searchTable.getColumnModel();
    columModel.getColumn(0).setPreferredWidth(175);     
    columModel.getColumn(1).setPreferredWidth(12);    
    columModel.getColumn(2).setPreferredWidth(12);    
    columModel.getColumn(3).setPreferredWidth(12);
    columModel.getColumn(4).setPreferredWidth(12);
    
    
    
    
    
    // searchTable.setSize(600,300);
    // for inventory tab table
    inventoryTable.setModel(new MyTableModel(inventoryData, inventoryColumns));
    inventoryTable.setAutoCreateRowSorter(true);
    
    TableColumnModel columModel2 = inventoryTable.getColumnModel(); //sets size 
    columModel2.getColumn(0).setPreferredWidth(225); 
    columModel2.getColumn(5).setPreferredWidth(225);     
    
    
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
    
    
    
    newTeacherToDepartmentButton = new JButton("Add Teacher ");
    deleteTeacherToDepartmentButton = new JButton("Delete Teacher");
    
    
    teacherTextField = new JTextField();
    
    newTeacherToDepartmentButton.addActionListener(new addTeacherButtonListener(teacherTextField));
    deleteTeacherToDepartmentButton.addActionListener(new deleteTeacherButtonListener(teacherTextField));
    
    
    
    teacherPageGridLayout = new JPanel(new GridLayout(1, 2));
    teacherLayout = new JPanel(new GridLayout(4, 1));
    
    String[] columnsTeacher = new String[] { "Teacher Selected" };
    String[] columnsAllTeacher = new String[] { "All the Teacher In School" };
    Object[][] dataTeacher = new Object[superFrame.getTeacherName().size()][columnsTeacher.length];
    Object[][] dataAllTeacher = new Object[superFrame.getAllTeacherInSchool().size()][columnsTeacher.length];
    for (int i = 0; i < superFrame.getTeacherName().size(); i++) {
      dataTeacher[i][0] = superFrame.getTeacherName().get(i);
    }
    for (int i = 0; i < superFrame.getAllTeacherInSchool().size(); i++) {
      dataAllTeacher[i][0] = superFrame.getAllTeacherInSchool().get(i);
    }
    
    // create table with data
    tableTeacher = new JTable(dataTeacher, columnsTeacher);
    tableAllTeacher = new JTable(dataAllTeacher, columnsAllTeacher);
    tableTeacher.addMouseListener(new MyMouseListener());
    tableTeacher.setModel(new MyTableModel(dataTeacher, columnsTeacher));
    tableAllTeacher.addMouseListener(new MyMouseListener());
    tableAllTeacher.setModel(new MyTableModel(dataAllTeacher, columnsAllTeacher));
    
    teacherLayout.add(teacherTextField);
    
    teacherLayout.add(newTeacherToDepartmentButton);
    
    teacherLayout.add(deleteTeacherToDepartmentButton);
    teacherLayout.add(Box.createRigidArea(new Dimension(5, 0)));
    
    teacherPageGridLayout.add(teacherLayout);
    //
    ////////////////////////////////////////////
    teacherPanel.add(new JScrollPane(tableAllTeacher));
    ////////////////////////////////////////////
    teacherPanel.add(teacherPageGridLayout);
    teacherPanel.add(new JScrollPane(tableTeacher));
    
    searchTextField.getDocument().addDocumentListener(new MyDocumentListener());
    
    programTab.addTab("Add/Delete Teacher", teacherPanel);
    // adding to mainPanel
    mainPanel.add(programTab);
    // adding to window
    myWindow.add(mainPanel);
    myWindow.setVisible(true);
    
  }
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  
  
  
  
  // Vincents Code
  
  /**
   * MyTableModel class
   *a class  extends DefaultTableModel
   * to make the data in the cells of jtable uneditable
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public class MyTableModel extends DefaultTableModel {
    
    
    //constructor
    public MyTableModel(Object[][] tableData, Object[] colNames) {
      super(tableData, colNames);
    }
    
    
    //tell the jtable that cell isn't editable
    public boolean isCellEditable(int row, int column) {
      return false;
    }
  }
  
  /*
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
      String searchFor = searchTextField.getText(); // takes text
      searched = search(searchFor,superFrame.getItemList()); // runs the search method
      updateTables(); // updates the tables
    }
    
  }
  
  /*
   * searchButtonListener updates the info for the selected item takks input from
   * the other text fields to edit the info of the selected item from the list
   * 
   * @author: Ali Meshkat
   * 
   * @date: Nov 20th
   * 
   * @instructor: MR.Mangat
   */
  public class replenishButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println(searchTable.getSelectedRow());
      // sets the selected attributes to the txt fields if not empty
      if (!equipmentNameTF.getText().equals("")) {
        searched.get(searchTable.getSelectedRow()).setEquipmentName(equipmentNameTF.getText());
      }
      if (!roomNumTF.getText().equals("")) {
        searched.get(searchTable.getSelectedRow()).setRoomNum(roomNumTF.getText());
      }
      if (!locationTF.getText().equals("")) {
        searched.get(searchTable.getSelectedRow()).setLocation(locationTF.getText());
      }
      if (!quantityTF.getText().equals("")) {
        searched.get(searchTable.getSelectedRow()).setTotal(quantityTF.getText());
      }
      // resets text fields
      equipmentNameTF.setText("");
      roomNumTF.setText("");
      locationTF.setText("");
      quantityTF.setText("");
      numInStockTF.setText("");
      
      /*
       * (2(2(2(2(2(2(2(2(2(2(2(2(2(2)2)2)2)2)2)2)2)2)2)2)2)2)2)
       * equipmentNameTF.setText(superFrame.getItemList().get(searchTable.
       * getSelectedRow()).getEquipmentName()); roomNumTF.setText("" +
       *superFrame.getItemList().get(searchTable.getSelectedRow()).getRoomNumber());
       * locationTF.setText(superFrame.getItemList().get(searchTable.getSelectedRow())
       * .getLocation()); quantityTF.setText("" +
       *superFrame.getItemList().get(searchTable.getSelectedRow()).
       * getTotalNumberOfItem()); numInStockTF.setText("" +
       *superFrame.getItemList().get(searchTable.getSelectedRow()).getNumLeft());
       */
      System.out.println("replenished");
      updateTables(); // updates tables
      saveToFile(superFrame.getItemList());// saves changes to file
    }
    
  }
  
  /*
   * searchButtonListener shows info for the selected item
   * 
   * @author: Ali Meshkat
   * 
   * @date: Nov 20th
   * 
   * @instructor: MR.Mangat
   */
  public class infoButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      equipmentNameTF.setText(searched.get(searchTable.getSelectedRow()).getEquipmentName());
      roomNumTF.setText("" + searched.get(searchTable.getSelectedRow()).getRoomNumber());
      locationTF.setText(searched.get(searchTable.getSelectedRow()).getLocation());
      quantityTF.setText("" + searched.get(searchTable.getSelectedRow()).getTotalNumberOfItem());
      numInStockTF.setText("" + searched.get(searchTable.getSelectedRow()).getNumLeft());
    }
  }
  
  /*
   * addButtonListener takes info from the textfields and uses them to create a
   * new object
   * 
   * @author: Ali Meshkat
   * 
   * @date: Nov 20th
   * 
   * @instructor: MR.Mangat
   */
  public class addButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // takes text from text fields
      String name = equipmentNameTF.getText();
      String roomNum = roomNumTF.getText();
      String location = locationTF.getText();
      String quantity = quantityTF.getText();
      
     superFrame.getItemList().add(new Item(name, roomNum, location, quantity, quantity)); // adds to list
      updateTables(); // updates tables
      // clears txt fields
      equipmentNameTF.setText("");
      roomNumTF.setText("");
      locationTF.setText("");
      quantityTF.setText("");
      numInStockTF.setText("");
      saveToFile(superFrame.getItemList());// saves changes to file
    }
  }
  
  public class takeButtonListener implements ActionListener {
    
    public void actionPerformed(ActionEvent arg0) {
      // should only activate if an item is selected and the take button is clicked
      Object[] options = { "Sign In", "Sign Out" };
      int selection = JOptionPane.showOptionDialog(null, "Are you signing some equipment in or out",
                                                   "Equipment Inventory", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                                                   options[0]);
      System.out.println("Selection: " + selection);
      if (selection == 0) {
        String[] signIn = { "A", "B", "C", "D", "E", "F" };
        String input = (String) JOptionPane.showInputDialog(null,
                                                            "Select your name and it will sign in all of your equipment.", "Equipment Inventory",
                                                            JOptionPane.INFORMATION_MESSAGE, null, signIn, signIn[1]);
        System.out.println(input);
      } else if (selection == 1) {
        String[] signOut = { "A", "B", "C", "D", "E", "F" };// should be replaced with the list of teachers from
        // the array
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
          System.out.println("Teacher Name: " + signOut[teacherNames.getSelectedIndex()]);// +
          // petList.setSelectedIndex(result));
          System.out.println("Amount Value: " + amount.getText());
        }
        
        // Create the combo box, select item at index 4.
        // Indices start at 0, so 4 specifies the pig.
        // JComboBox petList = new JComboBox(signOut);
        // petList.setSelectedIndex(4);
        // petList.addActionListener(this);
      }
      
    }
    
  }
  
  public class saveButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
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
  
  /*
   * updateTables: updates the tables search and inventory table's data with their new values
   * 
   * return void
   * 
   * param: none
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
    Object[][] inventoryData = new Object[superFrame.getItemList().size()][inventoryColumns.length];
    
    for (int i = 0; i <superFrame.getItemList().size(); i++) {
      inventoryData[i][0] =superFrame.getItemList().get(i).getEquipmentName();
      inventoryData[i][1] =superFrame.getItemList().get(i).getRoomNumber();
      inventoryData[i][2] =superFrame.getItemList().get(i).getLocation();
      inventoryData[i][3] =superFrame.getItemList().get(i).getTotalNumberOfItem();
      inventoryData[i][4] =superFrame.getItemList().get(i).getNumLeft();
      inventoryData[i][5] =superFrame.getItemList().get(i).getSignOutName();
      inventoryData[i][6] =superFrame.getItemList().get(i).getTotalNumberOfItem()
        -superFrame.getItemList().get(i).getNumLeft();
      
    }
    inventoryTable = new JTable(inventoryData, inventoryColumns);
    
    //searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    
  }
    /**setUpTable
    * return: void
   * to frash two teachers table with their new values
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public void setUpTable() {
    String[] columns = new String[] { "Teacher Name" };
    // create data
    Object[][] data = new Object[superFrame.getTeacherName().size()][columns.length];
    
    for (int i = 0; i < superFrame.getTeacherName().size(); i++) {
      data[i][0] = superFrame.getTeacherName().get(i);
    }
    
    tableTeacher.setModel(new MyTableModel(data, columns));
    tableTeacher.setAutoCreateRowSorter(true);
    
    
    Object[][] data2 = new Object[superFrame.getAllTeacherInSchool().size()][columns.length];
    
    for (int i = 0; i < superFrame.getAllTeacherInSchool().size(); i++) {
      data2[i][0] = superFrame.getAllTeacherInSchool().get(i);
    }
    
    tableAllTeacher.setModel(new MyTableModel(data2, columns));
    tableAllTeacher.setAutoCreateRowSorter(true);
    
  }
  /*
   * saveToFile is run at the end of the program to save the3 modified itemList to
   * the file for future use
   * 
   * @param: arraylist of items
   * 
   * @return: void
   * 
   * @author: Ali Meshkat
   */
  public void saveToFile(ArrayList<Item> itemList) {
    try {
      PrintWriter output = new PrintWriter(new File("Equipment.txt"));
      for (int i = 0; i <=superFrame.getItemList().size() - 1; i++) {
        output.print(superFrame.getItemList().get(i).getEquipmentName() + "#");
        output.print(superFrame.getItemList().get(i).getRoomNumber() + "#");
        output.print(superFrame.getItemList().get(i).getLocation() + "#");
        output.print(superFrame.getItemList().get(i).getTotalNumberOfItem() + "#");
        output.println(superFrame.getItemList().get(i).getNumLeft() + "##");
        
      }
      output.close();
      System.out.println("updatedddddddd");
    } catch (IOException error) {
      System.out.println("output IO error");
    } catch (Exception E) {
      System.out.println("ERROR");
    }
  }
  
  
    /**
   * MyDocumentListener class
   *a class  extends DocumentListener
   * to listen the change of search text field
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public class MyDocumentListener implements DocumentListener {
    
    @Override
    public void insertUpdate(DocumentEvent e) {
      
      changedUpdate(e);
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
      changedUpdate(e);
      
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
      
      String searchFor = searchTextField.getText(); // takes text
      searched = search(searchFor,superFrame.getItemList()); // runs the search method
      updateTables(); // updates the tables
    }
  }
  
      /**
   * MyMouseListener class
   *a class  extends  MouseAdapter 
   * to put the text the selected cells of jtable to textfield (for search tap)
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public class MyMouseListener extends MouseAdapter {
    public void mouseClicked(final MouseEvent e) {
      if (e.getClickCount() == 1) {
        JTable sourceTable = (JTable) e.getSource();
        
        if(sourceTable.equals(tableAllTeacher)){
          
          selected=1;
        }else{
          selected=0;
        }
        int rowTeacher = sourceTable.getSelectedRow();
        int columnTeacher = sourceTable.getSelectedColumn();
        teacherTextField.setText(""+ sourceTable.getValueAt(rowTeacher, columnTeacher));
        
      }
    }
  }
  
  
  
    /**
   * MyMouseListener class
   *a class  extends  MouseAdapter 
   * to put the text the selected cells of jtable to textfield (for teacher tap)
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public class MyMouseListener2 extends MouseAdapter {
    public void mouseClicked(final MouseEvent e) {
      if (e.getClickCount() == 1) {
        JTable sourceTable = (JTable) e.getSource();

        
        equipmentNameTF.setText(searched.get(searchTable.getSelectedRow()).getEquipmentName());
        roomNumTF.setText("" + searched.get(searchTable.getSelectedRow()).getRoomNumber());
        locationTF.setText(searched.get(searchTable.getSelectedRow()).getLocation());
        quantityTF.setText("" + searched.get(searchTable.getSelectedRow()).getTotalNumberOfItem());
        numInStockTF.setText("" + searched.get(searchTable.getSelectedRow()).getNumLeft());
      }
    }
  }
  
    /**
   * deleteTeacherButtonListener class
   * to delete the name of teacher who had been selected when click on delete button
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public class deleteTeacherButtonListener implements ActionListener {
    JTextField textField;
    
    public deleteTeacherButtonListener(JTextField textField) {
      super();
      this.textField = textField;
    }
    
    public void actionPerformed(ActionEvent e) {
      if(selected==1){
        if (superFrame.getAllTeacherInSchool().contains(textField.getText())) {
          superFrame.getAllTeacherInSchool().remove(superFrame.getAllTeacherInSchool().indexOf(textField.getText()));
          if(  superFrame.getTeacherName().contains(textField.getText())){
          superFrame.getTeacherName().remove(superFrame.getTeacherName().indexOf(textField.getText()));
          }
          setUpTable();
          teacherTextField.setText(" ");
        }
      }else{
        if (superFrame.getTeacherName().contains(textField.getText())) {
          superFrame.getTeacherName().remove(superFrame.getTeacherName().indexOf(textField.getText()));
          setUpTable();
          teacherTextField.setText(" ");
        }
      }
      
    }
    
  }

    /**
   * addTeacherButtonListener class
   * to add the name of teacher which is in the textfield to all teacher in school, and if it is already in, then add it to the department
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public class addTeacherButtonListener implements ActionListener {
    JTextField textField;
    
    public addTeacherButtonListener(JTextField textField) {
      super();
      
      this.textField = textField;
      
    }
    
    public void actionPerformed(ActionEvent e) {
      if(!textField.getText().isEmpty()){
        if (superFrame.getAllTeacherInSchool().contains(textField.getText())) {
          if(!superFrame.getTeacherName().contains(textField.getText())) {
            superFrame.getTeacherName().add(textField.getText());
          }
        }else {
          superFrame.getAllTeacherInSchool().add(textField.getText());
        }
        setUpTable();
        textField.setText("");
      }
    }
    
  }
     /**
   * setUIFont
   * to change the Font
   * By Vincent Zhang
   * Teacher: MR.Mangat
   */
  public static void setUIFont(javax.swing.plaf.FontUIResource f) {
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put(key, f);
    }
  }
  
}