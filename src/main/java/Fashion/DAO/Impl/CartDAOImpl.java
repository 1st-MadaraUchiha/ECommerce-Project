package Fashion.DAO.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import Fashion.DAO.CartDAO;
import Fashion.Model.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	HibernateTemplate hTemplate;
	
	public boolean addCart(Cart cart) {
		try {
			hTemplate.save(cart);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCart(int cartId) {
		try {
			Cart cart = hTemplate.get(Cart.class,cartId);
			hTemplate.delete(cart);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCart(Cart cart) {
		try {
			hTemplate.update(cart);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Cart> listCart(String userName) {
			List<Cart> cart = (List<Cart>) hTemplate.load(Cart.class,userName);
			return cart;
	}

	public Cart getCart(int cartId) {
	Cart cart = hTemplate.get(Cart.class,cartId);
	return cart;	
	}

	public List<Cart> loadAll() {
		List<Cart> carts = hTemplate.loadAll(Cart.class);
		return carts;
	}
 
}
