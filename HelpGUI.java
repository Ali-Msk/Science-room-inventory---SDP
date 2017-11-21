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
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
class HelpGUI extends JFrame {
  
  private JPanel mainPanel;
  private JPanel searchPanel;
  private JButton signInButton;
  private JButton signOutButton;
  private JPanel teacherPageGridLayout;
  private JPanel teacherGridLayout;
  private JTextField teacherTextField;
  private  JTable table ;
  
  
  
  
  HelpGUI () throws Exception{
    
    JFrame myWindow = new JFrame("Teacher");//creates a new window to work with
    myWindow.setSize(1000,555);//set size of window by 700 by 500 pixals
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //sets the program to close when the window closes
    
    mainPanel = new JPanel();
    
    
    
    signInButton = new JButton("Add Teacher");
    signOutButton = new JButton("Delete Teacher");
    
    teacherTextField = new JTextField();
    signInButton.addActionListener(new addTeacherButtonListener(teacherTextField));
    signOutButton.addActionListener(new addTeacherButtonListener2(teacherTextField));
    teacherPageGridLayout = new JPanel(new GridLayout(1,2));
    teacherGridLayout = new JPanel(new GridLayout(3,1)); 
    
    
    String[] columns = new String[] { "Teacher Name"};
    Object[][] data = new Object[HelpGUILauncher.teacherName.size()][columns.length];
    for(int i=0;i<HelpGUILauncher.teacherName.size();i++){
      data[i][0]=HelpGUILauncher.teacherName.get(i);
    }
    
    
    //create table with data
    table = new JTable(data, columns);
    table.addMouseListener(new MyMouseListener());
    table.setModel(new MyTableModel(data,columns));
    
    
    
    
    //adding to buttonGridLayout
    teacherGridLayout.add(teacherTextField);
    teacherGridLayout.add(signInButton);
    teacherGridLayout.add(signOutButton);

    
    teacherPageGridLayout.add(teacherGridLayout);
    
    
    mainPanel.add(teacherPageGridLayout);
    mainPanel.add(new JScrollPane(table));
    
    //adding to window
    myWindow.add(mainPanel);
    myWindow.setVisible(true);
    
  }
  
  
  
  public class MyMouseListener extends MouseAdapter{
    public void mouseClicked(final MouseEvent e) {
      if (e.getClickCount() == 1) {
        final JTable jTable= (JTable)e.getSource();
        final int row = jTable.getSelectedRow();
        final int column = jTable.getSelectedColumn();
        final String valueInCell = (String)jTable.getValueAt(row, column);
        teacherTextField.setText(valueInCell);
      }
    }
  }
  
  
  
  public class MyTableModel extends DefaultTableModel {
    
    public MyTableModel(Object[][] tableData, Object[] colNames) {
      super(tableData, colNames);
    }
    
    public boolean isCellEditable(int row, int column) {
      return false;
    }
  }
  
  
  
  public class addTeacherButtonListener2 implements ActionListener {
    JTextField textField;
    public addTeacherButtonListener2(JTextField textField){
      super();
      this.textField=textField;
    }
    
    public void actionPerformed(ActionEvent e) {
      if( HelpGUILauncher.teacherName.contains(textField.getText())){
        HelpGUILauncher.teacherName.remove(HelpGUILauncher.teacherName.indexOf(textField.getText()));
        setUpTable();
        teacherTextField.setText("");
      }
      
    }
    
  }
  
  
  
  public void setUpTable(){
    String[] columns = new String[] { "Teacher Name"};    
    
    
    
    //create data
    Object[][] data = new Object[HelpGUILauncher.teacherName.size()][columns.length];
    
    for(int i=0;i<HelpGUILauncher.teacherName.size();i++){
      data[i][0]=HelpGUILauncher.teacherName.get(i);
    }
    
    
    table.setModel(new MyTableModel(data,columns));
    table.setAutoCreateRowSorter(true);
  }
  
  
  
  
  public class addTeacherButtonListener implements ActionListener {
    JTextField textField;
    public addTeacherButtonListener(JTextField textField){
      super();
      this.textField=textField;
    }
    
    
    public void actionPerformed(ActionEvent e) {
      HelpGUILauncher.teacherName.add(textField.getText());
      setUpTable();
    }
    
  }
}