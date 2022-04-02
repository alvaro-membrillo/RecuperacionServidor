package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOficina;
import org.iesalixar.servidor.dao.DAOOficinaImpl;
import org.iesalixar.servidor.model.Oficina;

/**
 * Servlet implementation class OficinaServlet
 */
@WebServlet("/OficinaServlet")
public class OficinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOficinaImpl dao = new DAOOficinaImpl();
		
		String oficina = request.getParameter("oficina");
		
		request.setAttribute("offices", dao.getAllOficinas());
		request.setAttribute("oficinas", dao.getOficina(oficina));
		
		request.getRequestDispatcher("WEB-INF/view/oficinas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("oficina");
		
		response.sendRedirect(request.getContextPath()+"/Oficinas?oficinas="+id);
	}

}
