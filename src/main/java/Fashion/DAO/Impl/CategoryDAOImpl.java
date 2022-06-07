package Fashion.DAO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import Fashion.DAO.CategoryDAO;
import Fashion.Model.Category;


@Component
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	HibernateTemplate hTemplate;
	

	public boolean addCategory(Category category) {
		try {
			this.hTemplate.save(category);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(int catId) {
		try {
			Category cat = hTemplate.load(Category.class, catId);
			this.hTemplate.delete(cat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			this.hTemplate.update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> listCategory() {
		List<Category> cat =this.hTemplate.loadAll(Category.class);
		return cat;
	}

	public Category getCategory(int catId) {
		Category cat = this.hTemplate.get(Category.class, catId);
		return cat;
	}
}