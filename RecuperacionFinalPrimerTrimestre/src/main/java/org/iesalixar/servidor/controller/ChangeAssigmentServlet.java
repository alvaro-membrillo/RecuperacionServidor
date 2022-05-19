package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ChangeAssigmentServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAssigmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
//		String cat = request.getParameter("cat");
//		request.setAttribute("cat", cat);
			
		DAOProductImpl dao = new DAOProductImpl();
		List<Product> productos = dao.getAllProducts();
		request.setAttribute("productos", productos);
		
		DAOProductLineImpl daoCat = new DAOProductLineImpl();
		List<ProductLine> categorias = daoCat.getAllProductLines();
		request.setAttribute("categorias", categorias);

		request.getRequestDispatcher("/WEB-INF/view/changeAssigment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String productName = request.getParameter("product");
		String productLine = request.getParameter("productLine");
		
		if (productName!=null && productLine!=null) {
			DAOProductImpl dao = new DAOProductImpl();
			dao.updateProduct(productName, productLine);
			
			logger.log(Level.INFO, "Se ha cambiado la asignacion de la categoria al producto " + productName
			+ " por " + productLine);
			request.setAttribute("error", null);
		} else {
			logger.log(Level.INFO, "No se ha podido cambiar la asignacion de la categoria al producto " + productName
					+ " por " + productLine);
			request.setAttribute("error", "Hay campos nulos");
		}
		
		response.sendRedirect(request.getContextPath()+"/Home");
		
//		DAOProductImpl dao = new DAOProductImpl();
//		String productCode = request.getParameter("cn");
//		Product producto = dao.(Integer.parseInt(cn));
//		
//		logger.log(Level.INFO, "Se ha cambiado la asignacion de la categoria al producto " + cliente.getCustomerNumber()
//		+ " --- " + cliente.getCustomerName() + " por el empleado " + cliente.getSalesRepEmployeeNumber());
		
	}

}
