import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
public class Item {
  //create varible
  private int totalAmountItemInOneLocation;
  private int roomNumber;
  private String location;
  private String equipmentName;
  private HashMap<String, Integer>signOut=new HashMap<String, Integer>();
  private int signOutNumberTotal;
  //constructor
  public Item(String equipmentName, int roomNumber, String location, int totalAmountItemInOneLocation) { 
    this.equipmentName=equipmentName;
    this.roomNumber=roomNumber;
    this.location=location;
    this.totalAmountItemInOneLocation=totalAmountItemInOneLocation;
    signOutNumberTotal=0;
    this.signOut("Mr.Zhang", 100);
    this.signBack("Mr.Zhang", 40);
    
  }
  
  //signout some number of item
  public  void signOut(String teacherName, int numberOfItemSignOut){
    if(numberOfItemSignOut+ signOutNumberTotal<=totalAmountItemInOneLocation){
      signOutNumberTotal+=numberOfItemSignOut;
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
    }else{
      System.out.println("No");
    }
  }
  
  
  
  
  
  
  //method for signBack
  public void signBack(String teacherName, int numberOfItemSignIn){
    signOutNumberTotal-=numberOfItemSignIn;
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
    return signOutNumberTotal;
  }
  
  public String getNumSignInOrOut(){
    if(signOutNumberTotal>0){
      return "Sign Out: "+signOutNumberTotal;
    }else if(signOutNumberTotal<0){
      return "Sign In: "+-signOutNumberTotal;
    }else {
      return "No Sign In/Out ";
    }
  }
  
  public ArrayList<String> getSignOutName(){
    return new ArrayList<String>(signOut.keySet());
  }
  
  public int getRoomNumber(){
    return roomNumber;
  }
  public String getLocation(){
    return location;
  }
//a getter for the name of the equipment
  public String getEquipmentName(){
    return equipmentName;
  }
  //a method that get the totalAmountItemInOneLocation number of item left  
  public int getTotalNumberOfItem(){
    return totalAmountItemInOneLocation;
  }
  
  
  
}