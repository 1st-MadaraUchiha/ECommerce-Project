package Fashion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Fashion.DAO.CartDAO;
import Fashion.Model.Cart;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping(value="/AddToCart",method = RequestMethod.POST)
	public String addCart(@ModelAttribute Cart cart,Model m,HttpServletRequest request) { 
		String userName= (String)request.getSession().getAttribute("userName");
		  List<Cart> carts = cartDAO.listCart(userName);
		  List<Cart> lister = new ArrayList<Cart>();
		  for(Cart c:carts) {
			   if(!c.getPaymentStatus().equals("paid")) {
				   lister.add(c); 
			   }
		  }
		  m.addAttribute("cart",lister);
		  m.addAttribute("grandTotal", sum(lister));
		 	return "showcartlist";
	}
	
	
	@RequestMapping("/deleteCart/{cartId}")
	public String deleteCart(Model m, HttpServletRequest request,@PathVariable("cartId") int cartId) {
		try {
		String userName =(String)request.getSession().getAttribute("userName");
		Cart cart = cartDAO.getCart(cartId);
		if(cart.getUserName().equals(userName)) {
		cartDAO.deleteCart(cartId);
		 List<Cart> carts = cartDAO.listCart(userName);
		m.addAttribute("grandTotal", sum(carts));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "showcartlist";
	}
	@RequestMapping("/editCart/{cartId}/{quantity}")
	public String updateCart(Model m, HttpServletRequest request,@PathVariable("cartId") int cartId,@PathVariable("quantity") int quantity) {
		try {
			String userName =(String)request.getSession().getAttribute("userName");
			Cart cart = cartDAO.getCart(cartId);
			if(cart.getUserName().equals(userName)) {
				cart.setQuantity(quantity);
			cartDAO.updateCart(cart);
			}
			 List<Cart> carts = cartDAO.listCart(userName);
			 for(Cart c:carts) {
				   if(c.getPaymentStatus().equals("paid")) {
					   carts.remove(c); 
				   }
			  }
			m.addAttribute("grandTotal", sum(carts));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return "showcartlist";
	}
	
	public int sum(List<Cart> cart) {
		int sum = 0;
		for (Cart c : cart) {
		 sum = sum + c.getPrice()*c.getQuantity();
		}
		return sum;
	}
}
