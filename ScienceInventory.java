/**
 * [ScienceInventory.java]
 * a program to keep track of the Science dept. equipment in schools
 * @author Ali Meshkat, Israel Shpilman, Vincent Zhang
 * @date Nov 29, 2017
 * @instrctor Mr. Mangat
 */
public class ScienceInventory {
	public static void main(String[] args) {
		try {
			new ScienceLauncher();
		}catch(Exception E) {
			System.out.println("Error running scienceLauncher");
			E.printStackTrace();
		}
	}
}
