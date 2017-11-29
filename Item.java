import java.util.ArrayList;
import java.lang.Integer;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Item {
	// create varible
	private static ArrayList<String> allTeachers = new ArrayList<String>(); //name of all teachers in the school - static
	private static ArrayList<String> scienceTeachers = new ArrayList<String>(); //name of all teachers in science - static
	private static int numberInStock;
	private int totalAmountItemInOneLocation;
	private int roomNumber;
	private int numLeft; // amount left (not signed out)
	private String location;
	private String equipmentName;
	private HashMap<String, Integer> signOut = new HashMap<String, Integer>();
	private ArrayList<String> signOutName; //is the name of the teachers who have signed this out

	// constructors
	public Item(String equipmentName, int roomNumber, String location, int totalAmountItemInOneLocation) {
		this.equipmentName = equipmentName;
		this.roomNumber = roomNumber;
		this.location = location;
		this.totalAmountItemInOneLocation = totalAmountItemInOneLocation;
	}

	public Item(String equipmentName, int roomNumber, String location) {
		this.equipmentName = equipmentName;
		this.roomNumber = roomNumber;
		this.location = location;
	}

	public Item(String equipmentName, int roomNumber) {
		this.equipmentName = equipmentName;
		this.roomNumber = roomNumber;
	}

	public Item(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	/**
	 * main constructor used to create an item and save in itemList takes in all as
	 * string and converts
	 * @param: all required fields in form of string
	 */
	public Item(String name, String roomNumber, String location, String total, String amountLeft) {
		this.equipmentName = name;
		this.roomNumber = Integer.parseInt(roomNumber);
		if (!location.equals("") || !location.equals(null)) {
			this.location = location;
		} else {
			this.location = " ";
		}
		if (!total.equals("") && !total.equals(null)) {
			this.totalAmountItemInOneLocation = Integer.parseInt(total);
		} else {
			this.totalAmountItemInOneLocation = 0;
		}
		if (!amountLeft.equals("") && !amountLeft.equals(null)) {
			this.numLeft = Integer.parseInt(amountLeft);
		}
		signOutName = new ArrayList<String>();
	}

	// signout some number of item
	public void signOut(String teacherName, int numberOfItemSignOut) {
		boolean dontAdd = false;
		for(int i = 0; i<=signOutName.size()-1; i ++) {
			if (signOutName.get(i).equals(teacherName)) {
				dontAdd = true;
			}
		}
		if(!dontAdd) {
			signOutName.add(teacherName);
		}
		
		this.numLeft -= numberOfItemSignOut;
		// if it has a teacher's name in the signout list, then combine two
		// signout values to one
		if (signOut.containsKey(teacherName)) {
			// if the sign out number of the teacher + numberOfItemSignOut is 0,
			// then remove the teacher's name from the list.
			if (signOut.get(teacherName) == -numberOfItemSignOut) {
				signOut.remove(teacherName);

			} else {
				// add number sign out to the list
				signOut.put(teacherName, signOut.get(teacherName) + numberOfItemSignOut);

			}
		} else {
			// else add the name to the list
			signOut.put(teacherName, numberOfItemSignOut);
		}
	}

	// method for signBack
	public void signBack(String teacherName) {
		this.numLeft += signOut.get(teacherName); // updates amount left
		for (int i =0; i <= signOutName.size()-1; i++) {
			if (signOutName.get(i).equals(teacherName)) {
				signOutName.remove(i);
			}
		}
		
		for (int i = 0; i <= signOutName.size() - 1; i++) { // finds the teacher
			// in arrayList and
			// removes
			if (signOutName.get(i).equals(teacherName)) {
				signOutName.remove(i);
			}
		}
		System.out.println("Signed backk in");
		signOut.remove(teacherName);
	}

	// a method that get the totalAmountItemInOneLocation number of item sign
	// out
	public int getNumSignChange() {
		int num = 0;
		Iterator temp = signOut.entrySet().iterator();
		while (temp.hasNext()) {

			Map.Entry pair = (Map.Entry) temp.next();
			num += (Integer) pair.getValue();
			temp.remove();

		}

		return num;
	}
	
	/**
	 * getTeacherAmount
	 * returns the number of this item the input teacher has signed out\
	 * @param: string name of the teacher
	 * @return: the number of this item the teacher has signed out\
	 * @author: Ali Meshkat
	 */
	public int getTeacherAmount(String name) {
		return signOut.get(name);
	}
	
	
	
	// getters and setters for item.java

	public  ArrayList<String> getSignOutName() {
		return this.signOutName;
	}
	public static ArrayList<String> getAllTeachers(){
		return allTeachers;
	}
	
	public static ArrayList<String> getScienceTeachers(){
		return scienceTeachers;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String str) {
		this.equipmentName = str;
	}

	public int getTotalNumberOfItem() {
		return totalAmountItemInOneLocation;
	}

	public int getNumberInStock() {
		return numberInStock;
	}

	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(int room) {
		this.roomNumber = room;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumLeft() {
		return this.numLeft;
	}

	public void setLocation(int numLeft) {
		this.numLeft = numLeft;
	}

	public void setTotal(String totalAmountItemInOneLocation) {
		try {
			this.totalAmountItemInOneLocation = Integer.parseInt(totalAmountItemInOneLocation);
		} catch (Exception E) {
			System.out.println("Number available cannot contain letters");
		}
	}

	public void setRoomNum(String roomNum) {
		try {
			this.roomNumber = Integer.parseInt(roomNum);
		} catch (Exception E) {
			System.out.println("Room number cannot contain letters");
		}
	}

}