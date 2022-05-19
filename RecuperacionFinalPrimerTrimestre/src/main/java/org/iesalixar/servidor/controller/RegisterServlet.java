package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class InicioServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * DAOOrderImpl dao = new DAOOrderImpl(); List<Order> orders =
		 * dao.getAllOrders();
		 * 
		 * request.setAttribute("orders", orders);
		 */

		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		DAOUsuarioImpl dao = new DAOUsuarioImpl();

		if (usuario != null && password != null && email != null && firstName != null && lastName != null) {
			if (dao.getUsuario(usuario) != null) {
				request.setAttribute("error", "Usuario existente");
				doGet(request, response);
				return;
			} else {
				password = PasswordHashGenerator.hashPassword(password);

				Usuario user = new Usuario();
				user.setUsuario(usuario);
				user.setPassword(password);
				user.setEmail(email);
				user.setRole("user");
				user.setFirstName(firstName);
				user.setLastName(lastName);

				dao.registerUsuario(user);
			}
		}

		response.sendRedirect(request.getContextPath());

	}

}
