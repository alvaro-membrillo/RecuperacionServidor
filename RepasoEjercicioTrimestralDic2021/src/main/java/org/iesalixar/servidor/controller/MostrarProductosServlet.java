package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class MostrarProductosServlet
 */
@WebServlet("/MostrarProductosServlet")
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarProductosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOProductImpl dao = new DAOProductImpl();
		String categoria = request.getParameter("productLine");

		request.setAttribute("categoria", categoria);
		request.setAttribute("productos", dao.getProductsByCategoria(categoria));

		request.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(request, response);
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
