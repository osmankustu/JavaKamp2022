package Day3.NLayeredHomeWork.dataAccess.Concerete;

import Day3.NLayeredHomeWork.dataAccess.Abstract.CategoryDao;
import Day3.NLayeredHomeWork.entities.Category;

public class JdbcCategoryDao implements CategoryDao {

	@Override
	public void add(Category category) {
		System.out.println("JDBC ile Kategori Eklendi " + category.getCategoryName());
		
	}

	

}
