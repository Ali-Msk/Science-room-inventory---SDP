/**
 * [ScienceLauncher.java]
 * @author Ali Meshkat 
 * 
 */

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class ScienceLauncher {

	static ArrayList<Item> itemList;
	static ArrayList<String> teacherName ;
	static ArrayList<String> allTeacherInSchool;
	
	public static void main(String[] args) {
		// System.out.println(Integer.parseInt("null"));
		itemList = new ArrayList<Item>();
		System.out.println("reading started");
		getItems(itemList);

		for (int i = 0; i <= itemList.size() - 1; i++) {
			System.out.println(itemList.get(i).getEquipmentName());
		}
		
		
		teacherName = new ArrayList<String>();
		allTeacherInSchool = new ArrayList<String>();
		
		teacherName.add("l;akjdf");
		teacherName.add("l;1211");
		teacherName.add("l;4444444444");
		allTeacherInSchool.add("l;555");
		allTeacherInSchool.add("l;6666");
		allTeacherInSchool.add("l;77777");
		allTeacherInSchool.add("l;88888");
		allTeacherInSchool.add("l;9999");
		allTeacherInSchool.add("l;2");
		allTeacherInSchool.add("l;wqe");
		allTeacherInSchool.add("l;77231777");
		allTeacherInSchool.add("l;8812131888");
		allTeacherInSchool.add("l;9999");		
		allTeacherInSchool.add("l;55qwe5");
		allTeacherInSchool.add("l;66qwe66");
		allTeacherInSchool.add("l;77weq777");
		allTeacherInSchool.add("l;88qwe888");
		allTeacherInSchool.add("l;zsweqq9999");
		allTeacherInSchool.add("l;sad555");
		allTeacherInSchool.add("l;ad6666");
		allTeacherInSchool.add("l;ae377777");
		allTeacherInSchool.add("l;awe388888");
		allTeacherInSchool.add("l;we999sear9");
		allTeacherInSchool.add("l;eeaeaw2");
		allTeacherInSchool.add("l;wweaefrarearaerwearqe");
		allTeacherInSchool.add("l;7aerwearaerr7231777");
		allTeacherInSchool.add("l;8eaweraer812131888");
		allTeacherInSchool.add("l;99erwwearwearer99");		
		allTeacherInSchool.add("l;5aewearrwearer5qwe5");
		allTeacherInSchool.add("l;66erqwe66");
		allTeacherInSchool.add("l;77ererwearweq777");
		allTeacherInSchool.add("l;88erererwwerwearqwe888");
		allTeacherInSchool.add("l;zswwearwerereaeqq9999");
		
		
		itemList.get(0).signOut("GHoli", 3);
		itemList.get(0).signOut("Mr. J", 3);
		itemList.get(0).signBack("GHoli");
		itemList.get(0).signOut("Mr", 3);
		itemList.get(0).signOut("MS Hi", 10);
		itemList.get(0).signBack("Mr. J");

		
		
		
		getTeachers();
		getAllTeachersFile();
		getScienceTeachersFile();
		System.out.println(Item.getAllTeacherNames());
		System.out.println("SCIENCEEEEEEE: " + Item.getScienceTeacherNames());

		try {
			new ChemGui();
		} catch (Exception E) {
			System.out.println("ERRRORRRrR");

		}
		System.out.println("savingggggggggg!!!!");
		saveToFile(itemList);// saves to file after the program is done
	}

	/**
	 * saveToFile is run at the end of the program to save the3 modified
	 * itemList to the file for future use
	 * @param: arraylist of items
	 * @return: void
	 * @author: Ali Meshkat
	 */
	public static void saveToFile(ArrayList<Item> itemList) {
		try {
			PrintWriter output = new PrintWriter(new File("Equipment.txt"));
			for (int i = 0; i <= itemList.size() - 1; i++){
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
			while (input.hasNext()) {
				String item = input.nextLine();
				int i = 0;
				String name = "";
				String roomNum = "";
				String location = "";
				String quantity = "";
				String numLeft = "";
				boolean terminated = false;
				while (!item.substring(i, i + 1).equals("#")) {
					name += item.substring(i, i + 1);
					i++;
					// System.out.println("name found: " + name);
				}
				i++;
				while (!item.substring(i, i + 1).equals("#")) {
					roomNum += item.substring(i, i + 1);
					i++;
					// System.out.println("roomNum found: " + roomNum);

				}
				i++;
				if (item.substring(i, i + 1).equals("#")) {
					terminated = true;
					// System.out.println("terminated after room num");

				}
				if (!terminated) {
					while (!item.substring(i, i + 1).equals("#")) {
						location += item.substring(i, i + 1);
						i++;
						// System.out.println("location found: " + location);

					}
					i++;

					if (item.substring(i, i + 1).equals("#")) {
						terminated = true;
						// System.out.println("terminated after location");

					}
					if (!terminated) {
						while (!item.substring(i, i + 1).equals("#")) {
							quantity += item.substring(i, i + 1);
							i++;
							// System.out.println("quantity found: " +
							// quantity);
							//
						}
						i++;

						if (item.substring(i, i + 1).equals("#")) {
							terminated = true;
							// System.out.println("terminated after quantity");
						}
						if (!terminated) {
							while (!item.substring(i, i + 1).equals("#")) {
								numLeft += item.substring(i, i + 1);
								i++;
								// System.out.println("numLeft found: " +
								// numLeft);

							}
							i++;

						}
					}
				}
				itemList.add(new Item(name, roomNum, location, quantity,
						numLeft));
			}
			input.close();
		} catch (IOException FileNotFoundException) { // checks for io exception
			System.out.println("ERROR: items input file not found");// messages
			FileNotFoundException.printStackTrace(); // prints error details to
														// the console
		}

	}

	/**
	 * getTeachers
	 * reads two files to find the teachers that have signed out each equipment 
	 * and to find how many each teacher has signed ouut
	 * @param: none
	 * @return: void
	 * @author: Ali Meshkat
	 */
	public static void getTeachers(){
		
		//finds the names of the teachers that have signed out each equiment
		//the line number is the item
		try{
			Scanner input = new Scanner (new File ("SignOutTeacherNames.txt"));
			int lineNum = -1;
			while (input.hasNext()) {
				lineNum++; //keeps track of line num
				String item = input.nextLine(); //gets next line
				int i = 0; //index of line
				String name = ""; //the current name found
				boolean terminated = false; //end of line or not
				while (!terminated) {
					
					while (!(item.substring(i, i + 1).equals("#"))) {
						name += item.substring(i, i + 1);
						i++;
											                                                                                                                      System.out.println("name found: " + name);
					}
					
					itemList.get(lineNum).getSignOutName().add(name); //adds the teacher to item
				    name = "";
					i++;
					if (item.substring(i, i+1).equals("#")) { //if end of line
						terminated = true;
						System.out.println("termninated");
					}
				}
			}
			input.close();
		} catch (IOException FileNotFoundException) { // checks for io exception
			System.out.println("ERROR:  teachers input file not found");// messages
			FileNotFoundException.printStackTrace(); // prints error details to
														// the console
		}
		
		
		//finds the quantity each teacher has taken
		//each line is the next item
		//each # is the next teacher in the lline 
		// ## is the end of the line
		try{
			Scanner input = new Scanner (new File ("SignOutValues.txt"));
			int lineNum = -1;
			while (input.hasNext()) {
				lineNum++; //keeps track of line num
				String line = input.nextLine(); //gets next line
				int i = 0; //index of line
				
				//stores the number of teacher that the program is on 
				//used to find the name by using it as the input to 
				//signOutName arrayList
				int teacherNum = 0; 
				
				String amount = ""; //the current name found
				boolean terminated = false; //end of line or not
				while (!terminated) {
					while (!line.substring(i, i + 1).equals("#")) {
						amount += line.substring(i, i + 1);
						i++;
					    System.out.println("name found: " + amount);
					}					
					if (!amount.equals("")) {//if not empty
						itemList.get(lineNum).signOut(itemList.get(lineNum).getSignOutName().get(teacherNum), Integer.parseInt(amount));//uses the signoutName to sign out the item by the teacher with the amount just 
					}																						//fetched from the file 
					i++;
					teacherNum++;
					if (line.substring(i, i+1).equals("#")) { //if end of line
						terminated = true;
					}
				}
			}
			input.close(); //closes input
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
			Scanner input = new Scanner (new File ("AllTeachers.txt"));
			while(input.hasNext()) {
				Item.getAllTeacherNames().add(input.nextLine()); //gets line and add to teachers
			}
			input.close();
		}catch (IOException FileNotFoundException) { // checks for io exception
			System.out.println("ERROR: AllTeacher input file not found");// messages
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
			Scanner input = new Scanner (new File ("ScienceTeachers.txt"));
			while(input.hasNext()) {
				Item.getScienceTeacherNames().add(input.nextLine()); //gets line and add to science teachers
			}
			input.close();
		}catch (IOException FileNotFoundException) { // checks for io exception
			System.out.println("ERROR: ScienceTeachers input file not found");// messages
			FileNotFoundException.printStackTrace(); // prints error details to the console											
		}
	}
	
	
	
	
	
	
	
	
	
	
}