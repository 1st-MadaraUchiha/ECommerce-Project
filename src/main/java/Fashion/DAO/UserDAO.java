package Fashion.DAO;

import java.util.List;
import Fashion.Model.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean deleteUser(int userId);
	public boolean updateUser(User user);

	
	public List<User> listUser();
	public User getUser(String userName);	
}
