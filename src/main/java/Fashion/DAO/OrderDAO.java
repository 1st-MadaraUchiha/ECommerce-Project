package Fashion.DAO;

import java.util.List;

import Fashion.Model.Order;

public interface OrderDAO {

	public boolean saveOrder(Order order);
	public List<Order> getOrderList(String userName);
	public boolean update(Order order);
}
