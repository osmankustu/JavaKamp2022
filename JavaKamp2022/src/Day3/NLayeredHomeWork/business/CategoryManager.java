package Day3.NLayeredHomeWork.business;

import java.util.List;

import Day3.NLayeredHomeWork.core.Logger.Logger;
import Day3.NLayeredHomeWork.dataAccess.Abstract.CategoryDao;
import Day3.NLayeredHomeWork.entities.Category;

public class CategoryManager {

	private CategoryDao _categoryDao;
	private List<Category> _category;
	private Logger[] logger;
	
	public CategoryManager(CategoryDao categoryDao,List<Category> category,Logger[] logger) {
			this._categoryDao = categoryDao;
			this._category = category;
			this.logger = logger;
	}
	
	
	
	public void add(Category category) throws Exception {
	
		for (Category categories : _category) {
		
			if(categories.getCategoryName().equals(category) || categories.getCategoryId() == category.getCategoryId()) {
				
				throw new Exception("Bu Kategori ismi Mevcut " + category.getCategoryName());
			}
			
		}
		_categoryDao.add(category);
		_category.add(category);
		
		
		for(Logger loggers:logger) {
            loggers.Log();
        }
	    
	
	}
	

}
