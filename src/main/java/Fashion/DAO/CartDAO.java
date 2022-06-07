package Fashion.DAO;

import java.util.List;

import Fashion.Model.Cart;



public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean deleteCart(int cartId);
	public boolean updateCart(Cart cart);
	public List<Cart> loadAll();
	
	public List<Cart> listCart(String userName);
	public Cart getCart(int cartId);
}
