package Fashion.DAO.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import Fashion.DAO.CartDAO;
import Fashion.DAO.OrderDAO;
import Fashion.Model.Cart;
import Fashion.Model.Order;

@Transactional
@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	HibernateTemplate hTemplate;
	
	@Autowired
	CartDAO cartDAO;
	
	public boolean saveOrder(Order order) {
		hTemplate.save(order);
		update(order);
		return false;
	}

	public List<Order> getOrderList(String userName) {
		List<Order> orderList = (List<Order>) hTemplate.load(Order.class, userName);
		return orderList;
	}

	public boolean update(Order order) {
		int i =order.getCartId();
		Cart cart = cartDAO.getCart(i);	
		cart.setPaymentStatus("paid");
		cartDAO.updateCart(cart);
	
		
		return false;
	}

}
