package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	private final Map<String, Student> uniList;

	// implement default constructor
	public UniversityDatabase() {
		 uniList = new HashMap<String, Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		uniList.put(accountName, student);
	}

	public int getStudentCount() {
		return uniList.size();
	}

	public String lookupFullName(String accountName) {
		
		if(uniList.get(accountName) == null)
			return null;
		else
			return uniList.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		double totalBearBucks = 0d;
		
		for(Student v : uniList.values()) {
			totalBearBucks += v.getBearBucksBalance();
		}
		
		return totalBearBucks;
	}
}
