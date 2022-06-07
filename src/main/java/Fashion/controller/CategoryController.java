package Fashion.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import Fashion.DAO.CategoryDAO;
import Fashion.Model.Category;


@Controller
public class CategoryController {
	

	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value = "/catAdd", method = RequestMethod.POST)
	private String addCategoryFromForm(@ModelAttribute Category cat, Model m) {
		try {
		categoryDAO.addCategory(cat);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<Category> list= categoryDAO.listCategory();
		m.addAttribute("pageinfo", "Login");
		m.addAttribute("lists", list);
		
		return "addcategory";
	}
	
	@RequestMapping(value ="/editedCategory", method = RequestMethod.POST)
	private String editCategoryFromForm(@ModelAttribute Category cat,Model m) {
		try {
		categoryDAO.updateCategory(cat);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<Category> list= categoryDAO.listCategory();
		m.addAttribute("pageinfo", "Login");
		m.addAttribute("lists", list);
		return "addcategory";
	}

	@RequestMapping("/AddCategory")
	public String addCategoryPage(Model m) {
		List<Category> list= categoryDAO.listCategory();
		m.addAttribute("pageinfo", "Login");
		m.addAttribute("lists", list);
		return "addcategory";
	}
	
	@RequestMapping("/editCategory/{catId}")
	public String editCategoryPage(Model m,@PathVariable("catId")int id) {
		Category list= categoryDAO.getCategory(id);
		m.addAttribute("pageinfo", "Login");
		m.addAttribute("lists", list);
		return "editcategory";
	}
	
	@RequestMapping("/deleteCategory/{catId}")
	public String updateCategoryPage(Model m,@PathVariable("catId")int id) {
		categoryDAO.deleteCategory(id);
		List<Category> list= categoryDAO.listCategory();
		m.addAttribute("pageinfo", "Login");
		m.addAttribute("lists", list);
		return "addcategory";
	}
	
}
