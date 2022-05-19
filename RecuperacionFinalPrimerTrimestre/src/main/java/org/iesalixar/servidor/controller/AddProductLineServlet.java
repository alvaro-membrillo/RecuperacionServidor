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
public class AddProductLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddProductLineServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductLineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/addProductLine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productLine = request.getParameter("productLine");
		String textDescription = request.getParameter("textDescription");

		if (productLine != null && textDescription != null) {

			ProductLine categoria = new ProductLine();
			DAOProductLineImpl dao = new DAOProductLineImpl();
			categoria.setProductLine(productLine);
			categoria.setTextDescription(textDescription);

			if (dao.getProductLine(productLine) != categoria) {
				logger.log(Level.INFO, "La categoría: " + categoria.getProductLine() + ", se ha añadido correctamente.");
				dao.addProductLine(categoria);

			} else {
				logger.log(Level.INFO, "La categoría: " + categoria.getProductLine() + ", ya existe.");
				request.setAttribute("error", "Ya existe la categoria: " + categoria.getProductLine());
			}

		} else {
			logger.log(Level.INFO, "No puede haber campos vacíos");
			request.setAttribute("error", "Hay campos vacíos");
		}

		response.sendRedirect(request.getContextPath() + "/Home");
	}

}
