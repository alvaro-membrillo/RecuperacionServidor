package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductLineImpl;

/**
 * Servlet implementation class ProductLineReportServlet
 */
public class ProductLineReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ProductLineReportServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductLineReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoria = request.getParameter("cat");
		request.setAttribute("categoria", categoria);

		DAOProductLineImpl dao = new DAOProductLineImpl();
		int totalProductos = dao.getAllProducts(categoria);
		request.setAttribute("totalProductos", totalProductos);

		logger.log(Level.INFO, "Has seleccionado la categoria: " + categoria);
		request.getRequestDispatcher("/WEB-INF/view/productLineReport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
