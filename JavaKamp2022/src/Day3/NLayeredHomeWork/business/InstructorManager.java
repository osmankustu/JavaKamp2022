package Day3.NLayeredHomeWork.business;

import java.util.List;

import Day3.NLayeredHomeWork.core.Logger.Logger;
import Day3.NLayeredHomeWork.dataAccess.Abstract.InstructorDao;
import Day3.NLayeredHomeWork.entities.Instructor;

public class InstructorManager {
	private InstructorDao _instructorDao;
	private List<Instructor> _instructor;
	private Logger[] _logger;
	
	public InstructorManager(InstructorDao _instructorDao, List<Instructor> _instructor,Logger[] logger) {
	
		this._instructorDao = _instructorDao;
		this._instructor = _instructor;
		this._logger = logger;
	}
	

	public void add(Instructor instructor) {
		 _instructorDao.add(instructor);
		 _instructor.add(instructor);
		 
		 for (Logger loggers : _logger) {
			 loggers.Log();
		}
	 }

}
