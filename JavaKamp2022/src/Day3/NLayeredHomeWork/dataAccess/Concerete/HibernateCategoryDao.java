package Day3.NLayeredHomeWork.dataAccess.Concerete;

import Day3.NLayeredHomeWork.dataAccess.Abstract.CategoryDao;
import Day3.NLayeredHomeWork.entities.Category;

public class HibernateCategoryDao implements CategoryDao {

	@Override
	public void add(Category category) {
		System.out.println("Hibernate ile Kategori Eklendi "+ category.getCategoryName());
		
	}

}
