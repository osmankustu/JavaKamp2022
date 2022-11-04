package Day3.NLayeredHomeWork.dataAccess.Concerete;

import Day3.NLayeredHomeWork.dataAccess.Abstract.InstructorDao;
import Day3.NLayeredHomeWork.entities.Instructor;

public class HibernateInstructorDao implements InstructorDao {

	@Override
	public void add(Instructor instructor) {
		
		System.out.println("Hibernate ile Eğitmen Eklendi " + instructor.getInstructorName());
		
	}

}
