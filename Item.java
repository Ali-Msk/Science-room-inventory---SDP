import java.util.ArrayList;
import java.lang.Integer;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
public class Item {
	 //create varible
	  private static int numberInStock;
	  private int totalAmountItemInOneLocation;
	  private int roomNumber;
	  private int numLeft; // amount left (not signed out)
	  private String location;
	  private String equipmentName;
	  private HashMap<String, Integer>signOut=new HashMap<String, Integer>();
	  
	  //constructors
	  public Item(String equipmentName, int roomNumber, String location, int totalAmountItemInOneLocation) { 
	    this.equipmentName=equipmentName;
	    this.roomNumber=roomNumber;
	    this.location=location;
	    this.totalAmountItemInOneLocation=totalAmountItemInOneLocation;
	  }
	  public Item(String equipmentName, int roomNumber, String location){
		  this.equipmentName=equipmentName;
		  this.roomNumber=roomNumber;
		  this.location=location;
	  }
	  public Item(String equipmentName, int roomNumber){
		  this.equipmentName=equipmentName;
		  this.roomNumber=roomNumber;
	  }
	  public Item(String name){
		  this.equipmentName = name;
	  }
	  public Item(String name, String roomNumber, String location, String total, String amountLeft){
		 this.equipmentName = name;
		 this.roomNumber = Integer.parseInt(roomNumber);
		 if(!location.equals("")){
			 this.location = location;
		 }
		 if(!total.equals("")){
			 this.totalAmountItemInOneLocation = Integer.parseInt(total);
		 }
		 if(!amountLeft.equals("")){
			 this.numLeft = Integer.parseInt(amountLeft);
		 }

	  }
	  
	  //signout some number of item
	  public  void signOut(String teacherName, int numberOfItemSignOut){
	    
	    //if it has a teacher's name in the signout list, then combine two signout values to one
	    if(signOut.containsKey(teacherName)){
	      //if the sign out number of the teacher +numberOfItemSignOut is 0, then remove the teacher's name from the list.
	      if(signOut.get(teacherName)==-numberOfItemSignOut){
	        signOut.remove(teacherName);

	      }else{
	        //add number sign out to the list
	        signOut.put( teacherName,signOut.get(teacherName)+numberOfItemSignOut);

	      }
	    }else{
	      //else add the name to the list
	    signOut.put( teacherName,numberOfItemSignOut);
	    }
	  }
	  
	  
	  //setter for totalAmountItemInOneLocation varible
	  public void setTotal(int totalAmountItemInOneLocation){
	  this.totalAmountItemInOneLocation=totalAmountItemInOneLocation;
	  }
	  
	  
	  
	  //method for signBack
	  public void signBack(String teacherName, int numberOfItemSignIn){
	    
	    //if it has that name of teacher, then work on that value, else add it to the list
	    if(signOut.containsKey(teacherName)){
	      
	     if(signOut.get(teacherName)==numberOfItemSignIn){
	        signOut.remove(teacherName);

	      }else{
	        signOut.put( teacherName,signOut.get(teacherName)-numberOfItemSignIn);

	      }
	    }else{
	       signOut.put( teacherName,-numberOfItemSignIn);
	    }
	    
	  }
	  
	//a method that get the totalAmountItemInOneLocation number of item sign out
	  public int getNumSignChange(){
	    int num=0;
	     Iterator temp = signOut.entrySet().iterator();
	    while( temp.hasNext()){
	      
	      Map.Entry pair = (Map.Entry)temp.next();
	       num+= (Integer)pair.getValue();
	        temp.remove();
	        
	    }
	    
	    return num;
	  }
	    
	//a getter for the name of the equipment
	  public String getEquipmentName(){
	    return equipmentName;
	  }
	  //a method that get the totalAmountItemInOneLocation number of item left  
	  public int getTotalNumberOfItem(){
	    return totalAmountItemInOneLocation-getNumSignChange();
	  }
	  
	  //a method that return the total number of item in school
	  public int getNumberInStock(){
	    return numberInStock;
	  }
	  
	  //a method that set the total number of item in school
	  public void setNumberInStock(int numberInStock){
	    this.numberInStock=numberInStock;
	  }
	  public int getRoomNumber(){
		 return this.roomNumber; 	 
	  }
	  public void setRoomNumber(int room){
		 this.roomNumber = room; 	 
	  }
	  public String getLocation(){
		 return this.location; 	 
	  }
	  public void setLocation(String location){
		 this.location = location; 	 
	  }
	  public int getNumLeft(){
		 return this.numLeft; 	 
	  }
	  public void setLocation(int numLeft){
		 this.numLeft = numLeft; 	 
	  }
	  
}
