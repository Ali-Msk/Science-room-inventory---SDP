/**
 * chemGuiLauncher
 * just for testing how the gui looks
 * @author 335607057
 * @date November 15 2017
 * Version 1.0
 */
import java.util.ArrayList;
public class chemGuiLauncher {
 static ArrayList<Item> itemList=new ArrayList<Item>(); 
  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
   //vincents temp code
      itemList.add(new Item("glass",2000,"b1",2));
      itemList.add(new Item("gls",2001,"b5",212));
      itemList.add(new Item("glss",2002,"b4",2222));
      itemList.add(new Item("ass",2003,"b2",1));
      itemList.add(new Item("lss",2004,"b3",23));

    //launcher
    new ChemGui();
    //new TestGui();
  }
  
}
