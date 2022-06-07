package Fashion.DAO;

import java.util.List;

import Fashion.Model.Product;



public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	
	public List<Product> listProduct();
	public Product getProduct(int productId);
}
