package Day3.NLayeredHomeWork.dataAccess.Concerete;

import Day3.NLayeredHomeWork.dataAccess.Abstract.CourseDao;
import Day3.NLayeredHomeWork.entities.Course;

public class JdbcCourseDao implements CourseDao{

	@Override
	public void add(Course course) {
		System.out.println(" JDBC İle Ders Eklendi" + course.getCourseName());
		
	}

}
