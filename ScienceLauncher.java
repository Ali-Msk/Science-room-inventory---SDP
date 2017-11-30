
/**
 * [ScienceLauncher.java]
 * sciecneLauncher sets up everything needed for the gui to run 
 * this includes some variables + file Inputs 
 * @author Ali Meshkat 
 * @Date: Nov 29, 2017
 * @version: 8
 * @instructor: Mr. Mangat
 */

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class ScienceLauncher {
ArrayList<Item> itemList ;


ScienceLauncher() {
  // System.out.println(Integer.parseInt("null"));
  itemList = new ArrayList<Item>();
  getItems(itemList);

  getTeachers();
  getAllTeachersFile();
  getScienceTeachersFile();

  try {
   new ChemGui(this);
  } catch (Exception E) {
   System.out.println("ERRRORRRrR");

  }
  System.out.println("savingggggggggg!!!!");
  saveToFile(itemList);// saves to file after the program is done
 }

 /**
  * saveToFile is run at the end of the program to save the3 modified itemList to
  * the file for future use
  * 
  * @param: arraylist
  *             of items
  * @return: void
  * @author: Ali Meshkat
  */
 public static void saveToFile(ArrayList<Item> itemList) {
  try {
   PrintWriter output = new PrintWriter(new File("Equipment.txt"));
   for (int i = 0; i <= itemList.size() - 1; i++) {
    output.print(itemList.get(i).getEquipmentName() + "#");
    output.print(itemList.get(i).getRoomNumber() + "#");
    output.print(itemList.get(i).getLocation() + "#");
    output.print(itemList.get(i).getTotalNumberOfItem() + "#");
    output.println(itemList.get(i).getNumLeft() + "##");

   }
   output.close();

  } catch (IOException error) {
   System.out.println("output IO error");
  }
 }

 /**
  * getItems 
  * gets all the info for the items from the text file
  * @param: arrylist of items which is where everything will saved to
  * @return: void
  * @author: Ali Meshkat
  */
 public static void getItems(ArrayList<Item> itemList) {
  try {
   Scanner input = new Scanner(new File("Equipment.txt"));
   while (input.hasNext()) { // reads upto the end of the line
    String item = input.nextLine(); // saves line
    int i = 0; // keeps track of hte index of the line
    String name = "";
    String roomNum = "";
    String location = "";
    String quantity = "";
    String numLeft = "";
    boolean terminated = false; // if reached "##" which means the line has ended
    while (!item.substring(i, i + 1).equals("#")) { // everything before #
     name += item.substring(i, i + 1); // add to name
     i++; // next index of line
    }
    i++; // next index
    while (!item.substring(i, i + 1).equals("#")) {// everything before 2nd #
     roomNum += item.substring(i, i + 1);
     i++;
    }
    i++;
    if (item.substring(i, i + 1).equals("#")) {// after the second # the line could terminate at any time(no
               // more info available)
     terminated = true;

    }
    if (!terminated) { // if not ended
     while (!item.substring(i, i + 1).equals("#")) {
      location += item.substring(i, i + 1);
      i++;
     }
     i++;

     if (item.substring(i, i + 1).equals("#")) {// check for end
      terminated = true;
     }
     if (!terminated) {// if not ended
      while (!item.substring(i, i + 1).equals("#")) {
       quantity += item.substring(i, i + 1);
       i++;
      }
      i++;

      if (item.substring(i, i + 1).equals("#")) {
       terminated = true;
      }
      if (!terminated) {
       while (!item.substring(i, i + 1).equals("#")) {
        numLeft += item.substring(i, i + 1);
        i++;
       }
       i++;

      }
     }
    }
    itemList.add(new Item(name, roomNum, location, quantity, numLeft)); //adds item to arraylist
   }
   input.close(); //closes scanner 
  } catch (IOException FileNotFoundException) { // checks for io exception
   System.out.println("ERROR: items input file not found");// messages
   FileNotFoundException.printStackTrace(); // prints error details to
   // the console
  }

 }

 /**
  * getTeachers 
  * reads two files to find the teachers that have signed out each
  * equipment and to find how many each teacher has signed ouut
  * each line corresponds to the n'th index of itemList where n is the lineNum
  * @param: none
  * @return: void
  * @author: Ali Meshkat
  */
 public void getTeachers() {

  // finds the names of the teachers that have signed out each equiment
  // the line number is the item
  try {
   Scanner input = new Scanner(new File("SignOutTeacherNames.txt"));
   int lineNum = -1;
   while (input.hasNext()) {
    lineNum++; // keeps track of line num
    String item = input.nextLine(); // gets next line
    int i = 0; // index of line
    String name = ""; // the current name found
    boolean terminated = false; // end of line or not
    while (!terminated) {

     while (!(item.substring(i, i + 1).equals("#"))) {
      name += item.substring(i, i + 1);
      i++;
     }

     System.out.println("line Num:" + lineNum);
     itemList.get(lineNum).getSignOutName().add(name); // adds the teacher to item

     name = "";
     i++;
     if (item.substring(i, i + 1).equals("#")) { // if end of line
      terminated = true;
      System.out.println("termninated");
     }
    }
   }
   input.close(); //closes scanner
  } catch (IOException FileNotFoundException) { // catches io exception
   System.out.println("ERROR: teachers input file not found");// messages
   FileNotFoundException.printStackTrace(); // prints error details to concole
  }

  // finds the quantity each teacher has taken
  // each line is the next item
  // each # is the next teacher in the lline
  // ## is the end of the line
  try {
   Scanner input = new Scanner(new File("SignOutValues.txt"));
   int lineNum = -1;
   while (input.hasNext()) {
    lineNum++; // keeps track of line num
    String line = input.nextLine(); // gets next line
    int i = 0; // index of line

    // stores the number of teacher that the program is on
    // used to find the name by using it as the input to
    // signOutName arrayList
    int teacherNum = 0;

    String amount = ""; // the current name found
    boolean terminated = false; // end of line or not
    while (!terminated) {
     while (!line.substring(i, i + 1).equals("#")) {
      amount += line.substring(i, i + 1);
      i++;     }
     if (!amount.equals("")) {// if not empty
      itemList.get(lineNum).signOut(itemList.get(lineNum).getSignOutName().get(teacherNum),
        Integer.parseInt(amount));// uses the signoutName to sign out the item by the teacher
               // with the amount just
     }
     teacherNum++;
     amount = "";
     i++;
     // fetched from the file

     if (line.substring(i, i + 1).equals("#")) { // if end of line
      terminated = true;
     }
    }
   }
   input.close(); // closes input
  } catch (IOException FileNotFoundException) { // checks for io exception
   System.out.println("ERROR: signOut amounts input file not found");// messages
   FileNotFoundException.printStackTrace(); // prints error details to the console
  }

 }

 /**
  * getAllTeachersFile 
  * reads a file for alll the reachers in the school]
  * @param: none
  * @return: void
  * @author: Ali Meshkat
  */
 public static void getAllTeachersFile() {
  try {
   Scanner input = new Scanner(new File("AllTeachers.txt"));
   while (input.hasNext()) {//runs through file (each line is a new teacher)
    Item.getAllTeachers().add(input.nextLine()); // gets line and add to teachers
   }
   input.close();
  } catch (IOException FileNotFoundException) { // checks for io exception
   System.out.println("ERROR: AllTeachers input file not found");// messages
   FileNotFoundException.printStackTrace(); // prints error details to the console
  }
 }

//getter for itemlist
 public ArrayList<Item> getItemList(){
   return itemList;
 }

 /**
  * getAllTeachersFile 
  * reads a file for all the teachers in the science dept.
  * @param: none
  * @return: void
  * @author: Ali Meshkat
  */
 public static void getScienceTeachersFile() {
  try {
   Scanner input = new Scanner(new File("ScienceTeachers.txt"));
   while (input.hasNext()) {
    Item.getScienceTeachers().add(input.nextLine()); // gets line and add to science teachers
   }
   input.close();
  } catch (IOException FileNotFoundException) { // checks for io exception
   System.out.println("ERROR: ScienceTeachers input file not found");// messages
   FileNotFoundException.printStackTrace(); // prints error details to the console
  }
 }

}