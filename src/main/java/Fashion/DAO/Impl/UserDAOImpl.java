package Fashion.DAO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Fashion.DAO.UserDAO;
import Fashion.Model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	HibernateTemplate hTemplate;

	
public boolean addUser(User user) {
		try {
			hTemplate.save(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int userId) {
		try {
			User user = hTemplate.load(User.class,userId);
			hTemplate.delete(user);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			hTemplate.update(user);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<User> listUser() {
		List<User> loadAll = hTemplate.loadAll(User.class);
		return loadAll;
	}

	public User getUser(String userName) {
		User user = hTemplate.get(User.class,userName);
		return user;
	}
}