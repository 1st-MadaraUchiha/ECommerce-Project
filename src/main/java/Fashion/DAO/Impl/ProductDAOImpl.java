package Fashion.DAO.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import Fashion.DAO.ProductDAO;
import Fashion.Model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	HibernateTemplate hTemplate;
	
	public boolean addProduct(Product product) {
		try {
		hTemplate.save(product);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(int productId) {
		try {
			Product pro = hTemplate.load(Product.class,productId);
			hTemplate.delete(pro);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		
	}

	public boolean updateProduct(Product product) {
		try {
			hTemplate.update(product);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	public List<Product> listProduct() {
		List<Product> pro = hTemplate.loadAll(Product.class);
		return pro;
	}

	public Product getProduct(int productId) {
		return hTemplate.get(Product.class,productId);
	}

	
}
