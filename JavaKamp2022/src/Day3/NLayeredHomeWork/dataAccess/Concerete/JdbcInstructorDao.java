package Day3.NLayeredHomeWork.dataAccess.Concerete;

import Day3.NLayeredHomeWork.dataAccess.Abstract.InstructorDao;
import Day3.NLayeredHomeWork.entities.Instructor;

public class JdbcInstructorDao implements InstructorDao{

	@Override
	public void add(Instructor instructor) {
		
		System.out.println("JDBC ile Eğitmen Eklendi" + instructor.getInstructorName());
		
	}

}
