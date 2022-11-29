package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// init map
		Map<String, Double> list = new HashMap<String, Double>();
		
		// put info into map
		list.put("Carl", 180d);
		list.put("Sam", 175d);
		list.put("Harry", 182d);
		list.put("Sarah", 165d);
		
		
		// get info
		System.out.println("Enter name: ");
		String name = in.next();
		while(!name.equals("quit")) {
			if (list.get(name) != null) {
				System.out.println("Name: " + name);
				System.out.println("Height: " + list.get(name));
			}
			else {
				System.out.println("No person found");
			}
			
			System.out.println();
			System.out.println("Enter name: ");
			name = in.next();
		}
	}
}
