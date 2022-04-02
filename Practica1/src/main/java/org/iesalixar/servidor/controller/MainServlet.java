package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(false);
				
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		Date createTime = new Date(sesion.getCreationTime());
		sesion.setAttribute("createTime", createTime);
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String confirmar = request.getParameter("confirmar");
		String email = request.getParameter("email");

		if (usuario != null && password != null) {

			if (password.equals(confirmar)) {

				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("password", password);
				sesion.setAttribute("email", email);

				response.sendRedirect(request.getContextPath()+"/Reservar");
				
			}

		} else {
			request.setAttribute("errorLogin", "Invalid Login");
			
			response.sendRedirect(request.getContextPath()+"/Reservar");
			
			// response.sendRedirect(request.getContextPath());
			/*
			 * doGet(request, response); return;
			 */
		}

		//doGet(request, response);
	}

}
