package Fashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Fashion.DAO.ProductDAO;
import Fashion.DAO.UserDAO;
import Fashion.Model.Product;
import Fashion.Model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class PageController{
	int i = 0;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/")
	public String index(Model m) {
	List<Product> p =productDAO.listProduct();
	m.addAttribute("pro",p);
	m.addAttribute("pageinfo","Login");
	return "index";	
	}
	
	@RequestMapping("/Home")
	public String home(Model m) {
		List<Product> p =productDAO.listProduct();
		m.addAttribute("pro",p);
		m.addAttribute("pageinfo","Login");
		return "index";
	}
	
	@RequestMapping("/Login")
	public String login(Model m) {
		m.addAttribute("pageinfo","Login");
		return "login";
	}
	
	@RequestMapping("/Register")
	public String register(Model m) {
		m.addAttribute("pageinfo","Login");
		return "register";
	}
	
	@RequestMapping("/ContactUs")
	public String contactUs(Model m) {
		m.addAttribute("pageinfo","Login");
		return "contactus";
	}
	
	@RequestMapping("/AboutUs")
	public String aboutUs(Model m) {
		m.addAttribute("pageinfo","Login");
		return "aboutus";
	}
	
	@RequestMapping("/LogOut")
		public String logout(Model m,HttpSession session) {
		session.setAttribute("userName","LogOut");
		m.addAttribute("role","invalid");
			return "index";
		}
	
	@RequestMapping("/loginForm")
	public String loginForm(@RequestParam("userName")String userName,@RequestParam("password") String password,Model m,HttpServletRequest request) {
		try { 
		User user =userDAO.getUser(userName);	
		if((user.getUserName().equals(userName)) && (user.getPassword().equals(password))) {
		request.getSession().setAttribute("userName", userName);
		request.getSession().setAttribute("role",user.getRole());
	
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/Register")
	public String register(@ModelAttribute User user,@RequestParam("password")String password,@RequestParam("repeatPassword") String repeatPassword) {
		if(password.equals(repeatPassword)) {
			userDAO.addUser(user);
			return "index";
		}
		else {
		return "register";
		}
	}
}
	
	
