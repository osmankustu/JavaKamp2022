package Day3.NLayeredHomeWork.entities;

public class Instructor {
	private int ınstructorId;
	private String ınstructorName;
	
	public Instructor(int instructorId, String instructorName) {
		super();
		ınstructorId = instructorId;
		ınstructorName = instructorName;
	}
	
	public Instructor() {
		super();
	}

	public int getInstructorId() {
		return ınstructorId;
	}

	public void setInstructorId(int instructorId) {
		ınstructorId = instructorId;
	}

	public String getInstructorName() {
		return ınstructorName;
	}

	public void setInstructorName(String instructorName) {
		ınstructorName = instructorName;
	}
	
	
}
