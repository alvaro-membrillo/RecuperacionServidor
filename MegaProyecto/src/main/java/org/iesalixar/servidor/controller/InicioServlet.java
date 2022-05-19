package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Order;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class InicioServlet
 */
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioServlet() {
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

		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		if (usuario != null && password != null) {
			DAOUsuarioImpl dao = new DAOUsuarioImpl();
			Usuario user = dao.getUsuario(usuario);

			if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", user.getUsuario());
				sesion.setAttribute("email", user.getEmail());
				sesion.setAttribute("password", user.getPassword());
				sesion.setAttribute("role", user.getRole());
				sesion.setAttribute("firstName", user.getFirstName());
				sesion.setAttribute("lastName", user.getLastName());
				response.sendRedirect(request.getContextPath() + "/Home");
			} else {
				request.setAttribute("error", "Login inválido");
				doGet(request, response);
				return;
			}
		} else {
			request.setAttribute("error", "Usuario no existente");
			doGet(request, response);
			return;
		}
	}

}
