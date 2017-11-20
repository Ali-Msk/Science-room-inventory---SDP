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
	static ArrayList<Item> itemList ;
	public static void main(String[] args) {
		//System.out.println(Integer.parseInt("null"));
		itemList  = new ArrayList<Item>();
		System.out.println("reading started");
		getItems(itemList);
		
		
		for (int i = 0; i <= itemList.size()-1; i++){
			System.out.println(itemList.get(i).getEquipmentName());
		}
	/*	Scanner input = new Scanner (System.in);
	 	ArrayList<Item> searched;
		System.out.println("search for?");
		String searchFor = input.nextLine();
		
		searched = search(searchFor, itemList);
		for (int i = 0; i<= searched.size()-1;i++){
			System.out.println(searched.get(i).getEquipmentName());
		}		

		input.close();*/
		itemList.get(0).signOut("GHoli", 3);
		itemList.get(0).signOut("Mr. J", 3);
		itemList.get(0).signBack("GHoli");
		itemList.get(0).signOut("Mr", 3);
		itemList.get(0).signOut("MS Hi", 10);
		itemList.get(0).signBack("Mr. J");



		try {
			new ChemGui();
		}catch(Exception E) {}
		
		saveToFile(itemList);//saves to file after the program is done
	}
	/*
	 * saveToFile 
	 * is run at the end of the program to save the3 modified itemList to the file for future use
	 * @param: arraylist of items
	 * @return: void
	 * @author: Ali Meshkat 
	 */
	public static void saveToFile(ArrayList<Item> itemList){
		try {
			PrintWriter output = new PrintWriter(new File("Equipment.txt"));	
			for (int i = 0 ; i <= itemList.size()-1; i++){
				output.print(itemList.get(i).getEquipmentName() + "#");
				output.print(itemList.get(i).getRoomNumber() + "#");
				output.print(itemList.get(i).getLocation() + "#");
				output.print(itemList.get(i).getTotalNumberOfItem() + "#");
				output.println(itemList.get(i).getNumLeft() + "##" );


				
			}
			output.close();
			
		}catch(IOException error){
			System.out.println("output IO error");
		}
	}
	
	
	
	
	/*
	 * getItems
	 * gets all the info for the items from the text file
	 * @param: arrylist of items which is where everything will saved to
	 * @return: void
	 * @author: Ali Meshkat
	 */
	public static void getItems(ArrayList<Item> itemList ){
		try{
			Scanner input = new Scanner(new File("Equipment.txt"));
			while(input.hasNext()){
				String item = input.nextLine();
				int i = 0;
				String name ="";
				String roomNum = "";
				String location = "";
				String quantity = "";
				String numLeft= "";
				boolean terminated = false;
				while(!item.substring(i,i+1).equals("#")){
					name += item.substring(i,i+1);
					i++;
//					System.out.println("name found: " + name);
				}
				i++;
				while (!item.substring(i,i+1).equals("#")){
					roomNum += item.substring(i,i+1);
					i++;
	//				System.out.println("roomNum found: " + roomNum);

				}
				i++;
				if(item.substring(i,i+1).equals("#")){
					terminated= true;
	//				System.out.println("terminated after room num");

				}
				if (!terminated){
					while (!item.substring(i,i+1).equals("#")){
						location += item.substring(i,i+1);
						i++;
	//					System.out.println("location found: " + location);

					}
					i++;

					if(item.substring(i,i+1).equals("#")){
						terminated= true;
//					System.out.println("terminated after location");

					}
					if(!terminated){
						while (!item.substring(i,i+1).equals("#")){
							quantity += item.substring(i,i+1);
							i++;
	//						System.out.println("quantity found: " + quantity);
//
						}
						i++;

						if(item.substring(i,i+1).equals("#")){
							terminated= true;
		//					System.out.println("terminated after quantity");
						}
						if(!terminated){
							while (!item.substring(i,i+1).equals("#")){
								numLeft += item.substring(i,i+1);
								i++;
			//					System.out.println("numLeft found: " + numLeft);

							}
							i++;

						}
					}
				}
				itemList.add(new Item(name, roomNum, location, quantity, numLeft));
			}
			input.close();
		}catch(IOException FileNotFoundException){ //checks for io exception
			System.out.println("ERROR: input file not found");//messages
			FileNotFoundException.printStackTrace(); //prints error details to the console 
		}
		
	}
	
	

}