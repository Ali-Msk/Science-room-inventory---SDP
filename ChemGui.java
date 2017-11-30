import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
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
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;


public class ChemGui extends JFrame {
  // ///////////////////NONE GUI STUFF//////////////////////////////
  ArrayList<Item> searched = ScienceLauncher.itemList;
  
  // vincent
  public static void setUIFont(javax.swing.plaf.FontUIResource f) {
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put(key, f);
    }
  }
  
  private JPanel teacherPanel;
  // /////////////////////////////////////////////////////////////////////
  
  private JLabel signedOutInfo;
  
  // creating JComboBox
  // for search page
  private JComboBox teacherSearchCB;
  String[] teacherSearch = { };// should be replaced with the list of teachers from the
  // array
  // creating a jscrollpane for the instructions tab
  private JScrollPane scrollInstructions;
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
  //for instructions
  private JPanel instructionsBorder;
  private JPanel instructionsPanel;
  
  // creating buttons
  // buttons for search page
  private JButton searchButton;
  private JButton replenishButton;
  private JButton addButton;
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
  //for instructions page
  private JLabel instructionsLabel;
  
  // vincent
  // teacher tab
  private JTable tableAllTeacher;
  private JButton signInButton;
  private JButton signOutButton;
  private JPanel teacherPageGridLayout;
  private JPanel teacherGridLayout;
  private JTextField teacherTextField;
  private JTable table;
  private JTable tableTeacher;
  
  ChemGui() throws Exception {
    //teacherSearchCB.addMouseListener(new MyMouseListener3());
    JFrame myWindow = new JFrame("Equipment Inventory");// creates a new window to
    // work with
    myWindow.setSize(1000, 555);// set size of window by 700 by 700 pixals
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the
    // program
    // to close
    // when the
    // window
    // closes
    
    // vincent 2 end
    
    // creating JComboBoxes
    teacherSearchCB = new JComboBox(teacherSearch);
    teacherSearchCB.addActionListener(new DropDownListener());
    // creating tabbed panes
    programTab = new JTabbedPane();
    
    
    
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
    replenishButton = new JButton("Edit");
    addButton = new JButton("Add");
    saveButton = new JButton("Delete");
    takeButton = new JButton("Take/Return Equipment");
    
    
    
    
    // creating action listeners
    // for search tab
    searchButton.addActionListener(new searchButtonListener());
    replenishButton.addActionListener(new replenishButtonListener());
    addButton.addActionListener(new addButtonListener());
    takeButton.addActionListener(new takeButtonListener());
    saveButton.addActionListener(new DeleteButtonListener());
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
    signedOutInfo = new JLabel();
    
    /**
     * instructionsLabel
     * has all of the instructions in the label
     * @author Israel Shpilman
     * @date 11/29/2017
     */
    //have to fix this and make it work
    instructionsLabel = new JLabel("<HTML>***************************************INSTRUCTIONS********************************************* <BR> Welcome to our program, SCIENCE INVENTORY. This program will aid you with the sorting and <BR>organization of your Science Departments inventory. These instructions are to make sure that <BR>your use of our program goes as smoothly as possible. These following sections will explain each <BR>tab and how to use it properly. <BR><BR><BR>**********Equipment Inventory*********** <BR>This tab is to display all of the equipment in your inventory. <BR>The table in the tab displays the Equipment Name (the name of your <BR>equipment), Room Number (the room where that equipment is stored), Location <BR>(the location within the room where the equipment is stored), Total Number  <BR>(the total amount of that equipment in the department), Number Available <BR>(this displays the number equipment that is available for use),  <BR>Who Signed It Out (displays the teachers who signed out that particular piece <BR>of equipment), # Signed Out (displays the amount of equipment that has been signed <BR>out is not available for use).<BR><BR>*******************Search*********************** <BR>This tab does multiple functions including the searching of the whole list of equipment. <BR>The first function on the upper left corner is to search for the equipment, it will display <BR>all of the equipment with the name that corresponds to the item that was searched. The display <BR>below the search bar contains the equipment that was searched. The table displays the Equipment <BR>Name, Room Number, Total Number, Number Available, and the teacher(s) who signed out that piece of equipment. <BR>The buttons on the bottom have the following functions. <BR><BR>/////Searching for Equipment/////  <BR>To search for equipment, type in the name of the equipment you are searching for <BR><BR>/////Edit Button///// <BR>Edit: This button saves the changed information of the equipment that was selected from the table. <BR><BR>/////Sign Out/ Sign In Button//// <BR>Sign Out/ Sign In: If you want to borrow some equipment, select that equipment on the table from the left hand side <BR>of the screen, then select the button. When the smaller window pops up click on the borrow button, fill in the amount <BR>you wish to borrow, and select your name from the drop down menu. If you are returning some equipment, select the return <BR>button, but be aware that if you select our name and click return then it will return all of the items that you have borrowed. <BR><BR><BR>Now on the right hand side of the screen there is a display that displays the information of the selected equipment. <BR>On the right of Teacher's Signed out there is a drop down menu with all of the teachers that have borrowed that specific <BR>piece of equipment, selecting a different name will display below it the number of equipment that the specific<BR>teacher had borrowed.<BR><BR>/////Add Button/////<BR>Add: This button allows the user to type in all of the information of a new piece of equipment and fill out its <BR>information, if the user is adding new equipment then the user should only fill in the Equipment Name, Room Number, <BR>Location, and Total Quantity.<BR><BR>////Delete Button////<BR>Delete: This button deletes the equipment that was selected.<BR><BR>******************Add/Delete Teacher***********************<BR>On the right hand side of the tab, the list of all of the teachers in the school are there.<BR><BR>To add a teacher to the school list, type in the name of the teacher then click add teacher.<BR>To delete a teacher from the list of teachers at school, select that name and then click delete teacher.<BR>To add a teacher to the department list, select the teacher's name from the school list and click add teacher.<BR>To delete a teacher from the department list, select the teacher's name from the department list and click delete teacher.<BR><BR>Created by Israel Shpilman, Seyedali Meshkatosadat, and Vincent Zhang<BR>11/29/2017<BR>@SCIENCE INVENTORY INc.</HTML>");
    instructionsLabel.setOpaque(true);
    instructionsLabel.setBackground(new Color(255,255,208));
    scrollInstructions = new JScrollPane(instructionsLabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollInstructions.setPreferredSize(new Dimension(800,500));
    // creating border layout
    
    //for the instructions tab
    // for instructions tab
    instructionsPanel = new JPanel();
    instructionsPanel.add(scrollInstructions);
    instructionsPanel.setBackground(new Color(208, 255, 255));
    instructionsBorder = new JPanel();
    instructionsBorder.setLayout(new BorderLayout());
    instructionsBorder.add(instructionsPanel, BorderLayout.CENTER);
    
    
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
      
      
    }
    
    // create table with data
    searchTable = new JTable(searchData, searchColumns);
    searchTable.addMouseListener(new MyMouseListener2()); //adds a mouse listerner to search table
    searchTable.setFont(new Font ("Dialog", Font.BOLD, 15));
    
    
    
    // creating the inventory tab table
    inventoryTable = new JTable(inventoryData, inventoryColumns);
    
    // add the table
    // to search table
    searchTable.setModel(new MyTableModel(searchData, searchColumns));
    searchTable.setAutoCreateRowSorter(true);
    searchTable.setOpaque(true);/////%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%make sure this works
    searchTable.setFillsViewportHeight(true);//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%^
    searchTable.setBackground(new Color(255, 255, 208)); //colour
    
    // is used to set sizes for each column
    TableColumnModel columModel = searchTable.getColumnModel();
    columModel.getColumn(0).setPreferredWidth(175);     
    columModel.getColumn(1).setPreferredWidth(12);    
    columModel.getColumn(2).setPreferredWidth(12);    
    columModel.getColumn(3).setPreferredWidth(12);
    columModel.getColumn(4).setPreferredWidth(12);
    
    
    
    
    
    // for inventory tab table
    inventoryTable.setModel(new MyTableModel(inventoryData, inventoryColumns));
    inventoryTable.setAutoCreateRowSorter(true);
    
    inventoryTable.setFont(new Font ("Dialog", Font.BOLD, 12));
    
    // colour
    inventoryTable.setOpaque(true);//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%55
    inventoryTable.setFillsViewportHeight(true);
    inventoryTable.setBackground(new Color(255, 255, 208));
    
    TableColumnModel columModel2 = inventoryTable.getColumnModel(); //sets sizes for columns 
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
    infoGrid.setBackground(new Color(208, 255, 255));//colour
    
    
    // search button grid
    searchButtonGrid.add(replenishButton);
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
    searchPanel.add(searchTabGrid);
    
    // adding to tab
    
    programTab.add("Search", searchPanel);
    programTab.addTab("Equipment Inventory", inventoryPanel);
    programTab.addTab("Instructions", instructionsBorder);
    
    signInButton = new JButton("Add Teacher");
    signOutButton = new JButton("Delete Teacher");
    
    teacherTextField = new JTextField();
    signInButton.addActionListener(new addTeacherButtonListener(teacherTextField));
    signOutButton.addActionListener(new addTeacherButtonListener2(teacherTextField));
    teacherPageGridLayout = new JPanel(new GridLayout(1, 2));
    teacherGridLayout = new JPanel(new GridLayout(4, 1));
    
    String[] columnsTeacher = new String[] { "Teacher Selected" };
    String[] columnsAllTeacher = new String[] { "All the Teacher In School" };
    Object[][] dataTeacher = new Object[Item.getScienceTeachers().size()][columnsTeacher.length];
    Object[][] dataAllTeacher = new Object[Item.getAllTeachers().size()][columnsTeacher.length];
    for (int i = 0; i < Item.getScienceTeachers().size(); i++) {
      dataTeacher[i][0] = Item.getScienceTeachers().get(i);
    }
    for (int i = 0; i < Item.getAllTeachers().size(); i++) {
      dataAllTeacher[i][0] = Item.getAllTeachers().get(i);
    }
    
    // create table with data
    tableTeacher = new JTable(dataTeacher, columnsTeacher);
    tableAllTeacher = new JTable(dataAllTeacher, columnsAllTeacher);
    tableTeacher.addMouseListener(new MyMouseListener());
    tableTeacher.setModel(new MyTableModel(dataTeacher, columnsTeacher));
    tableAllTeacher.addMouseListener(new MyMouseListener());
    tableAllTeacher.setModel(new MyTableModel(dataAllTeacher, columnsAllTeacher));
    
    // adding to buttonGridLayout
    teacherGridLayout.add(teacherTextField);
    
    teacherGridLayout.add(signInButton);
    
    teacherGridLayout.add(signOutButton);
    
    teacherPageGridLayout.add(teacherGridLayout);
    //
    ////////////////////////////////////////////
    teacherPanel.add(new JScrollPane(tableAllTeacher));
    ////////////////////////////////////////////
    teacherPanel.add(teacherPageGridLayout);
    teacherPanel.add(new JScrollPane(tableTeacher));
    
    searchTextField.getDocument().addDocumentListener(new MyDocumentListener());
    
    programTab.addTab("Add/Delete Teacher", teacherPanel);
    programTab.setBackground(new Color(208, 255, 255));//colour light blue
    
    // adding to mainPanel
    mainPanel.add(programTab);
    // adding to window
    myWindow.add(mainPanel);
    myWindow.setBackground(new Color(208, 255, 255));//colour
    
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
   * @author: Ali Meshkat
   * @date: Nov 20th
   * @instructor: MR.Mangat
   */
  public class searchButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      String searchFor = searchTextField.getText(); // takes text
      searched = search(searchFor, ScienceLauncher.itemList); // runs the search method
      updateTables(); // updates the tables
    }
    
  }
  
  /**
   * searchButtonListener updates the info for the selected item takks input from
   * the other text fields to edit the info of the selected item from the list
   * @author: Ali Meshkat
   * @date: Nov 20th
   * @instructor: MR.Mangat
   */
  public class replenishButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
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
      updateTables(); // updates tables
      saveToFile(ScienceLauncher.itemList);// saves changes to file
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
    @Override
    public void actionPerformed(ActionEvent e) {
      // takes text from text fields
      String name = equipmentNameTF.getText();
      String roomNum = roomNumTF.getText();
      String location = locationTF.getText();
      String quantity = quantityTF.getText();
      
      ScienceLauncher.itemList.add(new Item(name, roomNum, location, quantity, quantity)); // adds to list
      updateTables(); // updates tables
      // clears txt fields
      equipmentNameTF.setText("");
      roomNumTF.setText("");
      locationTF.setText("");
      quantityTF.setText("");
      numInStockTF.setText("");
      saveToFile(ScienceLauncher.itemList);// saves changes to file
    }
  }
  
  /**
   * takeButtonListener
   * allows the user to borrow and return equipment
   * @author Izzy
   * @date 11/29/2017
   */
  public class takeButtonListener implements ActionListener {
    
    public void actionPerformed(ActionEvent arg0) {
      //opens a pop-up window for borrowing or returning
      // should only activate if an item is selected and the take button is clicked
      Object[] options = { "Borrowing", "Returning" };
      int selection = JOptionPane.showOptionDialog(null, "Are you Borrowing Equipment or Returing It?",
                                                   "Equipment Inventory", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                                                   options[0]);
      
      //returns all of the equipment that, that teacher had signed out
      if (selection == 1) {
        
        Object[] signIn = searched.get(searchTable.getSelectedRow()).getSignOutName().toArray();
        Object input = JOptionPane.showInputDialog(null,
                                                   "Select your name and it will Return all of your equipment.", "Equipment Inventory",
                                                   JOptionPane.INFORMATION_MESSAGE, null, signIn, signIn);
        if (input != null) {
          int index = -1;
          for (int i = 0; i < signIn.length; i++) {
            if (signIn[i].equals(input)) {
              index = i;
              break;
            }
          }
          searched.get(searchTable.getSelectedRow()).signBack(""+signIn[index]);
          
        }
        
        
        //lets them borrow equipment 
      } else if (selection == 0) {
        Object[] signOut = Item.getScienceTeachers().toArray(); // the array
        JComboBox teacherNames = new JComboBox(signOut);
        JTextField amount = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Amount: "));
        myPanel.add(amount);
        amount.setText("" + searched.get(searchTable.getSelectedRow()).getNumLeft());
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Name: "));
        myPanel.add(teacherNames);
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Sign Out", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
          searched.get(searchTable.getSelectedRow()).signOut(
                                                             ((String) signOut[teacherNames.getSelectedIndex()]), (Integer.parseInt(amount.getText())));
        }
      }
    }
    
  }
  
  /**
   * DeleteButtonListener 
   * deletes the selected item from the list of equipments
   * @author: Ali Meshkat
   * @date: Nov 20th
   * @instructor: MR.Mangat
   */
  public class DeleteButtonListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(searchTextField.getText().equals("")){ //if search is empty 
        ScienceLauncher.itemList.remove(searchTable.getSelectedRow()); //remove that index
      }else{ //if something is search(original table isnt not being displayed) (affecs selected row)
        String name= "";
        name = searchTextField.getText();
        for (int i = 0; i <= ScienceLauncher.itemList.size()-1; i ++){ //runs through arrayLIst 
          if(ScienceLauncher.itemList.get(i).getEquipmentName().equals(name)){ //looks for the name 
            ScienceLauncher.itemList.remove(i); //removes 
          }
        }
      }
      updateTables(); //refreshes
      saveToFile(ScienceLauncher.itemList);//saves to file
    }
  }
  
  /**
   * search searches for the piece of string inputed in items(names)
   * @param: a string to search for and the arrayList of the items
   * @return: returns a new arraylist containing all the items with the str as
   * part of their name(not case sensitive)
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
   * updateTables updates the tables with their new values
   * @return: void
   * @param: none
   * @author: Ali Meshkat
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
    //is used to set sizes for each column 
    TableColumnModel columModel = searchTable.getColumnModel();
    columModel.getColumn(0).setPreferredWidth(175);     
    columModel.getColumn(1).setPreferredWidth(12);    
    columModel.getColumn(2).setPreferredWidth(12);    
    columModel.getColumn(3).setPreferredWidth(12);
    columModel.getColumn(4).setPreferredWidth(12);
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
    
    inventoryTable = new JTable(inventoryData, inventoryColumns);
    
    
    
  }
  
  /**
   * saveToFile is run at the end of the program to save the3 modified itemList to
   * the file for future use 
   * @param: arraylist of items
   * @return: void
   * @author: Ali Meshkat
   */
  public static void saveToFile(ArrayList<Item> itemList) {
    //saves itemList
    try {
      PrintWriter output = new PrintWriter(new File("Equipment.txt"));
      for (int i = 0; i <= ScienceLauncher.itemList.size() - 1; i++) {
        output.print(ScienceLauncher.itemList.get(i).getEquipmentName() + "#");
        output.print(ScienceLauncher.itemList.get(i).getRoomNumber() + "#");
        output.print(ScienceLauncher.itemList.get(i).getLocation() + "#");
        output.print(ScienceLauncher.itemList.get(i).getTotalNumberOfItem() + "#");
        output.println(ScienceLauncher.itemList.get(i).getNumLeft() + "##");
        
      }
      output.close();
    } catch (IOException error) {
      System.out.println("Equipment output IO error");
    } catch (Exception E) {
      System.out.println("ERROR");
    }
    
    //saves AllTeachers
    try {
      PrintWriter output = new PrintWriter(new File("AllTeachers.txt"));
      for (int i = 0; i <= Item.getAllTeachers().size() - 1; i++) {
        output.println(Item.getAllTeachers().get(i));
      }
      output.close();
    } catch (IOException error) {
      System.out.println("AllTeachers output IO error");
    } catch (Exception E) {
      System.out.println("ERROR");
    }
    
    //saves sciecneTeachers
    try {
      PrintWriter output = new PrintWriter(new File("ScienceTeachers.txt"));
      for (int i = 0; i <= Item.getScienceTeachers().size() - 1; i++) {
        output.println(Item.getScienceTeachers().get(i));
      }
      output.close();
    } catch (IOException error) {
      System.out.println("ScienceTeachers output IO error");
    } catch (Exception E) {
      System.out.println("ERROR");
    }
    
    //saves what teachers each item was signed out by 
    try {
      PrintWriter output = new PrintWriter(new File("SignOutTeacherNames.txt"));
      for (int i = 0; i <= ScienceLauncher.itemList.size() - 1; i++) { //runs through items
        for (int j = 0; j <= ScienceLauncher.itemList.get(i).getSignOutName().size();j++) { //runs through number teachers who signed it out
          output.print(ScienceLauncher.itemList.get(i).getSignOutName().get(j) + "#"); //puts name + # 
        }
        output.println("##");//closes off line
      }
      output.close();
    } catch (IOException error) {
      System.out.println("Equipment output IO error");
    } catch (Exception E) {
      System.out.println("ERROR");
    }
    
    //saves how many each teacher signed out 
    try {
      PrintWriter output = new PrintWriter(new File("SignOutValues.txt"));
      for (int i = 0; i <= ScienceLauncher.itemList.size() - 1; i++) { //runs through items
        for (int j = 0; j <= ScienceLauncher.itemList.get(i).getSignOutName().size();j++) { //runs through number teachers who signed it out
          output.print(ScienceLauncher.itemList.get(i).getSignOutName().get(j) + "#"); //puts name + # 
        }
        output.println("##");//closes off line
      }
      output.close();
    } catch (IOException error) {
      System.out.println("Equipment output IO error");
    } catch (Exception E) {
      System.out.println("ERROR");
    }
  }
  
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
      searched = search(searchFor, ScienceLauncher.itemList); // runs the search method
      updateTables(); // updates the tables
    }
  };
  
  // vincent 100 start
  public class MyMouseListener extends MouseAdapter {
    public void mouseClicked(final MouseEvent e) {
      if (e.getClickCount() == 1) {
        JTable sourceTable = (JTable) e.getSource();
        int rowTeacher = sourceTable.getSelectedRow();
        int columnTeacher = sourceTable.getSelectedColumn();
        teacherTextField.setText(""+ sourceTable.getValueAt(rowTeacher, columnTeacher));
      }
    }
  }
  
  public class MyMouseListener2 extends MouseAdapter {
    public void mouseClicked(final MouseEvent e) {
      if (e.getClickCount() == 1) {
        JTable sourceTable = (JTable) e.getSource();
        equipmentNameTF.setText(searched.get(searchTable.getSelectedRow()).getEquipmentName());
        roomNumTF.setText("" + searched.get(searchTable.getSelectedRow()).getRoomNumber());
        locationTF.setText(searched.get(searchTable.getSelectedRow()).getLocation());
        quantityTF.setText("" + searched.get(searchTable.getSelectedRow()).getTotalNumberOfItem());
        numInStockTF.setText("" + searched.get(searchTable.getSelectedRow()).getNumLeft());
        
        /**
         * Izzy
         * this is for the JComboBox so that it will update what teachers are within that equipment item
         */
        // this is for the JComboBox that displays the teachers that have signed out
        // that item
        Object[] teachers = searched.get(searchTable.getSelectedRow()).getSignOutName().toArray();
        DefaultComboBoxModel model = (DefaultComboBoxModel) teacherSearchCB.getModel();
        // removing old data
        model.removeAllElements();
        for (int i = 0; i < teachers.length; i++) {
          model.addElement(teachers[i]);
        }
        teacherSearchCB.setModel(model);
        int numberOut = 0;
        numberOut = searched.get(searchTable.getSelectedRow()).getTeacherAmount((String) teachers[teacherSearchCB.getSelectedIndex()]);
        numberOut = searched.get(searchTable.getSelectedRow()).getTeacherAmount(searched.get(searchTable.getSelectedRow()).getSignOutName().get(teacherSearchCB.getSelectedIndex()));
        
        signedOutInfo.setText("" + numberOut);
        
      }
    }
  }
  
  public class addTeacherButtonListener2 implements ActionListener {
    JTextField textField;
    
    public addTeacherButtonListener2(JTextField textField) {
      super();
      this.textField = textField;
    }
    
    public void actionPerformed(ActionEvent e) {
      if (Item.getAllTeachers().contains(textField.getText())) {
        Item.getAllTeachers().remove(Item.getAllTeachers().indexOf(textField.getText()));
        setUpTable();
        teacherTextField.setText(" ");
      }
      
    }
    
  }
  /**
   * DropDownListener
   * when the teacher is selected the label will be updated
   * @author Izzy
   * @date 11/29/2017
   */
  public class DropDownListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
      Object sourceTable = e.getSource();
      
      if (searched.get(searchTable.getSelectedRow()).getSignOutName().size() > 0) {
        // try{
        Object[] teachers = searched.get(searchTable.getSelectedRow()).getSignOutName().toArray();
        int numberOut = 0;
        numberOut = searched.get(searchTable.getSelectedRow()).getTeacherAmount((String) teachers[teacherSearchCB.getSelectedIndex()]);
        numberOut = searched.get(searchTable.getSelectedRow()).getTeacherAmount(searched.get(searchTable.getSelectedRow()).getSignOutName().get(teacherSearchCB.getSelectedIndex()));
        
        signedOutInfo.setText("" + numberOut);
      }
    }
  }
  
  
  
  public void setUpTable() {
    String[] columns = new String[] { "Teacher Name" };
    // create data
    Object[][] data = new Object[Item.getAllTeachers().size()][columns.length];
    
    for (int i = 0; i < Item.getAllTeachers().size(); i++) {
      data[i][0] = Item.getAllTeachers().get(i);
    }
    
    tableTeacher.setModel(new MyTableModel(data, columns));
    tableTeacher.setAutoCreateRowSorter(true);
  }
  
  public class addTeacherButtonListener implements ActionListener {
    JTextField textField;
    
    public addTeacherButtonListener(JTextField textField) {
      super();
      
      this.textField = textField;
      
    }
    
    public void actionPerformed(ActionEvent e) {
      if (!Item.getAllTeachers().contains(textField.getText())) {
        Item.getAllTeachers().add(textField.getText());
        setUpTable();
      }
    }
    
  }
  // vincent 100 end
  
}