package Fashion.DAO;

import java.util.List;

import Fashion.Model.Category;


public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	public boolean deleteCategory(int catId);
	public boolean updateCategory(Category category);
	
	public List<Category> listCategory();
	public Category getCategory(int catId);
}
