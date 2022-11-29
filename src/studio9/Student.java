package studio9;

public class Student {
	private String firstName;
	private String lastName;
	private int idNum;
	private int attemptedCredits;
	private int passingCredits;
	private double totalPts;
	private double bearBalance;
	
	public Student(String fn, String ln, int r) {
		firstName = fn;
		lastName = ln;
		idNum = r;
	}
	
	/**
	 * Gets full name of student
	 * @return full name of student
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * Gets the ID of the current object
	 * @return ID number of current object
	 */
	public int getId() {
		return idNum;
	}
	
	/**
	 * Submit grade of student
	 * @param gd grade of student 
	 * @param crdts credits of the course
	 */
	public void submitGrade(double gd, int crdts) {
		if(gd >= 1.7) {
			passingCredits += crdts;
		}
		
		attemptedCredits += crdts;
		
		totalPts += crdts * gd;
	}
	
	/**
	 * Get total attempted credits
	 * @return total attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	/**
	 * Get total passing credits
	 * @return total passing credits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * Calculates student's grade point average
	 * @return student's grade point average
	 */
	public double calculateGradePointAverage() {
		return totalPts / attemptedCredits;
	}
	
	/**
	 * Gets class standing of student
	 * @return String indicating the student's class standing, Senior, Junior
	 * Sophomore or First Year
	 */
	public String getClassStanding() {
		if(passingCredits >= 90) {
			return "Senior";
		}
		else if(passingCredits >= 60) {
			return "Junior";
		}
		else if(passingCredits >= 30) {
			return "Sophomore";
		}
		else {
			return "First Year";
		}
	}
	
	/**
	 * Check if student is eligible for fraternity/sorority
	 * @return boolean value to indicate if student is eligible for fraternity/sorority
	 */
	public boolean isEligibleForPhiBetaKappa() {
		//System.out.println(calculateGradePointAverage() + ", " + passingCredits);
		if(calculateGradePointAverage() >= 3.6 && passingCredits >= 98) {
			return true;
		}
		else if(calculateGradePointAverage() >= 3.8 && passingCredits >= 75) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Add value to the bear bucks account of the student object
	 * @param amount the amount to be added
	 */
	public void depositBearBucks(double amount) {
		bearBalance += amount;
	}
	
	/**
	 * Minus value to the bear bucks account of the student object
	 * @param amount the amount to be deducted
	 */
	public void deductBearBucks(double amount) {
		bearBalance -= amount;
	}
	
	/**
	 * Get bear bucks value of student object
	 * @return remaining value of bear bucks account of the student object
	 */
	public double getBearBucksBalance() {
		return bearBalance;
	}
	
	/**
	 * Remove all bear bucks and return remaining value according to school policy
	 * @return refunded bear bucks value
	 */
	public double cashOutBearBucks() {
		double bb = bearBalance;
		bearBalance = 0d;
		
		if(bb > 10d) {
			return bb - 10d;
		}
		else {
			return 0d;
		}
	}
	
	/**
	 * Create a student object that is the child of two parent student objects
	 * @param fname first name of created student object
	 * @param other student object of the other parent
	 * @param isHyphenated is the student's last name hyphenated
	 * @param id id of the student
	 * @return the child student object
	 */
	public Student createLegacy(String fname, Student other, boolean isHyphenated, int id) {
		String lname = lastName;
		
		// Create a new hyphenated last name
		if(isHyphenated) {
			lname += "-" + other.lastName;
		}
		
		// Create bear bucks
		
		// Both parent bear bucks
		double bba = this.cashOutBearBucks();
		double bbb = other.cashOutBearBucks();
		
		// Create new student
		Student r = new Student(fname, lname, id);
		// New student bear balance
		r.bearBalance = bba + bbb;
		
		return r;
	}
	
	public String toString() {
		return getFullName() + " " + idNum;
	}
	
	
}
