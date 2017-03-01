package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SimpleStateful.Cart;
import facade.AbstractFacade;
import model.Product;
import session4.ProductCart;
import session4.vo.ProductVO;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AbstractFacade facade;
	
    /**
     * Default constructor. 
     */
    public HomeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductCart productCart = facade.getCommonBean().getProductCart();
		Cart cart = facade.getCommonBean().getCart();
				
		ProductVO productVO = new ProductVO("1", "Nhan");
		productCart.addProduct(productVO);
    	System.out.println("===result: "+ productCart.getProductVOs().get(0).toString());
    	
    	List<Product> ps = cart.findAllProduct();
    	System.out.println("====List size: "+ ps.size());
    	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
