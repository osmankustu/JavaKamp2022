package Day3.NLayeredHomeWork;


import java.util.ArrayList;
import java.util.List;

import Day3.NLayeredHomeWork.business.CategoryManager;
import Day3.NLayeredHomeWork.business.CourseManager;
import Day3.NLayeredHomeWork.business.InstructorManager;
import Day3.NLayeredHomeWork.core.Logger.DatabaseLogger;
import Day3.NLayeredHomeWork.core.Logger.FileLogger;
import Day3.NLayeredHomeWork.core.Logger.Logger;
import Day3.NLayeredHomeWork.core.Logger.MailLogger;
import Day3.NLayeredHomeWork.dataAccess.Concerete.HibernateInstructorDao;
import Day3.NLayeredHomeWork.dataAccess.Concerete.JdbcCategoryDao;
import Day3.NLayeredHomeWork.dataAccess.Concerete.JdbcCourseDao;
import Day3.NLayeredHomeWork.dataAccess.Concerete.JdbcInstructorDao;
import Day3.NLayeredHomeWork.entities.Category;
import Day3.NLayeredHomeWork.entities.Course;
import Day3.NLayeredHomeWork.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		
		List<Category> categoryes = new ArrayList<>(); //veritabanı simulasyonu
		Category category1 = new Category(1,"Yazılım");
		Category category2 = new Category(2,"Sanat");

		Instructor ınstructor1 = new Instructor(1,"Engin Demirog");
		
		List<Course> courses = new ArrayList<>(); //veritabanı simülasyonu
		Course course1 = new Course(1,"Java Yazılım Geliştirme",10);
		Course course2 = new Course(2,".NET  Yazılım Geliştirme",10);
		Course course3 = new Course(3,"Javascript Yazılım Geliştirme",-1);
		Course course4 = new Course(2,".NET  Yazılım Geliştirme",10);
		Logger[] loggers = {
				new DatabaseLogger(),
				new FileLogger(),
				new MailLogger()
		};
		
		List<Instructor> instructors = new ArrayList<>(); //veritabanı simülasyonu
		Instructor instructor1 = new Instructor(1,"Engin Demirog");
		Instructor instructor2 = new Instructor(2,"Osman Kuştu");
		
		//IoC
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(),categoryes,loggers);
		InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(),instructors,loggers);
		CourseManager courseManager =  new CourseManager(new JdbcCourseDao(), courses,loggers);
		
		categoryManager.add(category1);
		categoryManager.add(category2);
		
		instructorManager.add(ınstructor1);
		instructorManager.add(instructor2);
		
		courseManager.add(course1);
		courseManager.add(course2);
		
		//hatalı ders ekleme Name exists 
		courseManager.add(course4);
		
		//hatalı ders ekleme ders <0
		//courseManager.add(course3);
		
		//hatalı Kategori Ekleme Name exists
		//categoryManager.add(category1);
	}

}
