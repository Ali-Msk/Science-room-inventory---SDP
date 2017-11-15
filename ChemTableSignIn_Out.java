import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
public class ChemTableSignIn_Out extends JFrame {
  JTable tabe;
  static ArrayList<Item> itemList=new ArrayList<Item>();
  public ChemTableSignIn_Out() {
    
    
    //create columns
    String[] columns = new String[] { "Item Name", "Room Number", "Location",  "Number Available", "Teacher who sign out equipment", "number of equipment signed In/out"};
    
    
    //create data
    Object[][] data = new Object[itemList.size()][columns.length];
    
    for(int i=0;i<itemList.size();i++){
      data[i][0]=itemList.get(i).getEquipmentName();
      data[i][1]=itemList.get(i).getRoomNumber();
      data[i][2]=itemList.get(i).getLocation();
         data[i][3]=itemList.get(i).getTotalNumberOfItem()-itemList.get(i).getNumSignChange();
       data[i][4]=itemList.get(i).getSignOutName();
        data[i][5]=itemList.get(i).getNumSignInOrOut();
    }

    
    //create table with data
    JTable table = new JTable(data, columns);
    
    
    //add the table
    
    table.setModel(new MyTableModel(data, columns));
    table.setAutoCreateRowSorter(true);
    this.add(new JScrollPane(table));
    this.setTitle("ChemTable");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    this.setVisible(true);
  }
  
  
  
  //make a new table model
  public class MyTableModel extends DefaultTableModel {
    
    public MyTableModel(Object[][] tableData, Object[] colNames) {
      super(tableData, colNames);
    }
    
    public boolean isCellEditable(int row, int column) {
      return false;
    }
  }
  
  public static void main(String args[]){
    itemList.add(new Item("glass",2000,"b1",2));
    itemList.add(new Item("gls",2001,"b5",212));
    itemList.add(new Item("glss",2002,"b4",2222));
    itemList.add(new Item("ass",2003,"b2",1));
    itemList.add(new Item("lss",2004,"b3",23));
    ChemTableSignIn_Out testTable=new ChemTableSignIn_Out();
    testTable.setSize(600, 600);
    
  }
}