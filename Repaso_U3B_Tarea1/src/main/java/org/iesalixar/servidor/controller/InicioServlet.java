package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class InicioServlet
 */
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(InicioServlet.class);

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

		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
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

			if (user != null) {
				if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
					HttpSession sesion = request.getSession();
					
					sesion.setAttribute("usuario", user.getUsuario());
					sesion.setAttribute("firstName", user.getFirstName());
					sesion.setAttribute("lastName", user.getLastName());
					sesion.setAttribute("email", user.getEmail());
					sesion.setAttribute("role", user.getRole());

					if ("admin".equals(user.getRole())) {
						response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
						logger.log(Level.INFO, "Admin se ha conectado");
					} else {
						response.sendRedirect(request.getContextPath());
						logger.log(Level.INFO, "Usuario se ha conectado");
						/*doGet(request, response);
						return;*/
					}
				} else {
					request.setAttribute("error", "Credenciales incorrectas");
					logger.log(Level.WARN, "Credenciales incorrectas");
					doGet(request, response);
					return;
				}
			} else {
				request.setAttribute("Error", "Usuario no existente");
				logger.log(Level.WARN, "Usuario no existente");
				doGet(request, response);
				return;
			}
		} else {
			request.setAttribute("error", "Login incorrecto");
			logger.log(Level.WARN, "Login inv??lido, usuario no existente");
			doGet(request, response);
			return;
		}

	}

}
