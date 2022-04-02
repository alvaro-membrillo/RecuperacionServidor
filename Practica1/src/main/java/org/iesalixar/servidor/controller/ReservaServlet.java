package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.model.Reserva;

/**
 * Servlet implementation class ReservaServlet
 */
@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/reserva.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		
		if (!sesion.isNew() && sesion.getAttribute("usuario") != null) {
			String fechaInicio = request.getParameter("inicio");
			String fechaFinal = request.getParameter("final");
			int personas = Integer.parseInt(request.getParameter("personas"));
			String[] servicios = request.getParameterValues("checkbox");
			
			Reserva reserva = new Reserva();
			
			reserva.setInicio(fechaInicio);
			reserva.setFin(fechaFinal);
			reserva.setPersonas(personas);
			reserva.setServicios(servicios);
			
			sesion.setAttribute("registroBean", reserva);
			
			response.sendRedirect(request.getContextPath()+"/Confirmar");
			return;
		}

	}

}
