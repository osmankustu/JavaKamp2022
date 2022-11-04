package Day3.NLayeredHomeWork.entities;

public class Course {
	
	private int courseId;
	private String courseName;
	private double coursePrice;
	
	public Course(int courseId, String courseName,double coursePrice) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
	}
	public Course() {
		
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	

}
