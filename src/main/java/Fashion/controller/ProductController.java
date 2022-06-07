package Fashion.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import Fashion.DAO.CartDAO;
import Fashion.DAO.CategoryDAO;
import Fashion.DAO.ProductDAO;
import Fashion.DAO.SupplierDAO;
import Fashion.Model.Category;
import Fashion.Model.Product;
import Fashion.Model.Supplier;
import jakarta.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig
public class ProductController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	ProductDAO productDAO;
	

	Product pro;
	Category category;
	Supplier supplier;
	
	@RequestMapping("/AddProduct")
	public String add(Model m) {
		extra(m);
		return"addproduct";
	}
	
	@RequestMapping("/ViewProduct/{productId}")
	public String addProduct(Model m,@PathVariable("productId")int i) {
		Product pro =productDAO.getProduct(i);
		m.addAttribute("viewProduct",pro);
		extra(m);
		return "addtocart";
	}
	
	
	@RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	public String productToDatabase(@ModelAttribute Product product, Model m) {

		MultipartFile multifile = product.getImage();
		if (!multifile.isEmpty()) {
			try {
				productDAO.addProduct(product);
				String path = "\\FashionFrontEnd\\src\\main\\webapp\\WEB-INF\\resource\\"+String.valueOf(product.getProductId())+".jpg";
				System.out.println(path);
				byte[] bimage = multifile.getBytes();
				File file = new File(path);
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(bimage);
				bos.close();
				extra(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.addAttribute("Error", "Exception Occured" + e.getMessage());
			}
		} else {
			m.addAttribute("Error", "Error Uploading File");
		}

		extra(m);
		return "addproduct";
	}

	@RequestMapping(value = "/deleteProduct/{productId}")
	public String delete(@PathVariable("productId") int pId, Model m) {
		productDAO.deleteProduct(pId);
		Path path = Paths.get("\\FashionFrontEnd\\src\\main\\webapp\\WEB-INF\\resource\\"+String.valueOf(pId)+".jpg");
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extra(m);
		return "addproduct";
	}

	@RequestMapping(value = "/editProduct/{productId}")
	public String edit(@PathVariable("productId") int pId, Model m) {
		Product pro = productDAO.getProduct(pId);
		m.addAttribute("product", pro);
		extra(m);
		
		return "editproduct";
	}
	
	@RequestMapping(value="/editedProduct")
	
	public String editPrduct(@ModelAttribute Product product, MultipartFile multi,Model m ) {
		try {
			multi = product.getImage();
			if (!multi.isEmpty()) {
			String path = "\\FashionFrontEnd\\src\\main\\webapp\\WEB-INF\\resource\\"+String.valueOf(product.getProductId())+".jpg";
			System.out.println(path);
			byte[] bimage = multi.getBytes();
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(bimage);
			bos.close();
			productDAO.updateProduct(product);
			}
			else {
				System.out.println("Error while executing edit operation");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extra(m);
		return "addproduct";
	}

	public void extra(Model m) {

		List<Category> catList = categoryDAO.listCategory();
		List<Supplier> supList = supplierDAO.listSupplier();
		List<Product> proList = productDAO.listProduct();
		m.addAttribute("cat", catList);
		m.addAttribute("sup", supList);
		m.addAttribute("pro", proList);
		m.addAttribute("pageinfo", "Manage Product");
	}
}
