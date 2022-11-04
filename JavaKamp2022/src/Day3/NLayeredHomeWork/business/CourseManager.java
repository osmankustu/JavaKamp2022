package Day3.NLayeredHomeWork.business;

import java.util.List;

import Day3.NLayeredHomeWork.core.Logger.Logger;
import Day3.NLayeredHomeWork.dataAccess.Abstract.CourseDao;
import Day3.NLayeredHomeWork.entities.Course;

public class CourseManager {

	private CourseDao _courseDao;
	private List<Course> _course;
	private Logger[] _loggers;
	
	public CourseManager(CourseDao courseDao , List<Course> course,Logger[] loggers) {
			this._courseDao = courseDao;
			this._course =course;
			this._loggers = loggers;
	}
	
	public void add(Course course) throws Exception{
		if(course.getCoursePrice() < 0) {
			throw new Exception("Kurs Fiyatı 0 dan küçük olamaz" + course.getCoursePrice());
		}
		
		for (Course courses : _course) {
			if(courses.getCourseName().equals(course.getCourseName())) {
				throw new Exception("Bu Ders İsmi Sistemde Mevcuttur !!" + course.getCourseName());
			}
		}
		_courseDao.add(course);
		_course.add(course);
		
		for (Logger loggers : _loggers) {
			
			loggers.Log();
		}
	}
}
