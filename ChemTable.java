

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
class ChemTable extends JFrame {
  JTable tabe;
  public ChemTable() {
    
    
    //create columns
    String[] columns = new String[] { "Item Name", "Room Number", "Locker Number", "Number of Item"};
    
    
    //create data
    Object[][] data = new Object[ScienceLauncher.itemList.size()][4];
    
    for(int i=0;i<ScienceLauncher.itemList.size();i++){
      data[i][0]=ScienceLauncher.itemList.get(i).getEquipmentName();
      data[i][1]=ScienceLauncher.itemList.get(i).getRoomNumber();
      data[i][2]=ScienceLauncher.itemList.get(i).getLocation();
      data[i][3]=ScienceLauncher.itemList.get(i).getTotalNumberOfItem();
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
}

