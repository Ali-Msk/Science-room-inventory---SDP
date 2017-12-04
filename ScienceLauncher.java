
/**
 * [ScienceLauncher.java]
 * sciecneLauncher sets up everything needed for the gui to run 
 * this includes some variables + file Inputs 
 * @author Ali Meshkat 
 * @Date: Nov 29, 2017
 * @instructor: Mr. Mangat
 */

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class ScienceLauncher {

	static ArrayList<Item> itemList;

	 ScienceLauncher() {
		 
		itemList = new ArrayList<Item>();//sets arraylist for items
		getItems(itemList); //inputs items

		//inputs teachers related things
		getTeachers();
		getAllTeachersFile();
		getScienceTeachersFile();

		try {
			new ChemGui(); //runs gui + main backend 
		} catch (Exception E) {
			System.out.println("ERROR running chemGui ");
			E.printStackTrace();
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

					}
				}
				itemList.add(new Item(name, roomNum, location, quantity, /*numLeft*/ quantity)); //adds item to arraylist
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
	public static void getTeachers() {

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

					if(!name.equals(""))
					itemList.get(lineNum).getSignOutName().add(name); // adds the teacher to item

					name = "";
					i++;
					if (item.substring(i, i + 1).equals("#")) { // if end of line
						terminated = true;
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
						i++;					}
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