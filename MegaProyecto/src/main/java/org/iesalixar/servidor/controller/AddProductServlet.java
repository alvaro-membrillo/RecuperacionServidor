package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOProductLineImpl dao = new DAOProductLineImpl();
		List<ProductLine> categorias = dao.getAllProductLines();
		
		request.setAttribute("categorias", categorias);
		
		request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String categoria = request.getParameter("categoria");
		String productScale = request.getParameter("productScale");
		String productVendor = request.getParameter("productVendor");
		String productDescription = request.getParameter("productDescription");
		String stockS = request.getParameter("stock");
		String buyPriceS = request.getParameter("buyPrice");
		String msrpS = request.getParameter("msrp");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double buyPrice = Double.parseDouble(buyPriceS);
		double msrp = Double.parseDouble(msrpS);
		
		if (productCode!=null && productName!=null && categoria!=null && productScale!=null && productVendor!=null && productDescription!=null &&
				stockS != null && buyPriceS!=null && msrpS!=null) {
			
			Product product = new Product();
			DAOProductImpl dao = new DAOProductImpl();
			product.setProductCode(productCode);
			product.setProductName(productName);
			product.setProductLine(categoria);
			product.setProductScale(productScale);
			product.setProductVendor(productVendor);
			product.setProductDescription(productDescription);
			product.setQuantityInStock(stock);
			product.setBuyPrice(buyPrice);
			product.setMsrp(msrp);
			
			dao.addProduct(product);
			logger.log(Level.INFO, "El producto " + product.getProductName() + " se ha añadido correctamente.");
		}
		
		response.sendRedirect(request.getContextPath()+"/Home");
	}

}
