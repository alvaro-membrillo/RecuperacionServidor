package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOUserImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email!=null && password!=null) {
			DAOUserImpl dao = new DAOUserImpl();
			Usuario usuario = dao.getUser(email);
			
			if (PasswordHashGenerator.checkPassword(password, usuario.getPassword())) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", usuario.getUsuario());
				sesion.setAttribute("firstName", usuario.getFirstName());
				sesion.setAttribute("lastName", usuario.getLastName());
				sesion.setAttribute("email", usuario.getEmail());
				sesion.setAttribute("role", usuario.getRole());
				response.sendRedirect(request.getContextPath()+"/Home");
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
