package Day3.NLayeredHomeWork.dataAccess.Concerete;

import Day3.NLayeredHomeWork.dataAccess.Abstract.CourseDao;
import Day3.NLayeredHomeWork.entities.Course;

public class HibernateCourseDao implements CourseDao{

	@Override
	public void add(Course course) {
		System.out.println("Hibernate ile Ders Eklendi "+course.getCourseName());
		
	}

}
