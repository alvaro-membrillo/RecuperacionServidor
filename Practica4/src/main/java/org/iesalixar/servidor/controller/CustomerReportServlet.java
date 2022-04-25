package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.model.Customer;

/**
 * Servlet implementation class CustomerReportServlet
 */
@WebServlet("/CustomerReportServlet")
public class CustomerReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOCustomerImpl dao = new DAOCustomerImpl();
		int cn = Integer.parseInt(request.getParameter("cn"));
		Customer customer = dao.getCustomerById(cn);
		
		double total = dao.getTotalPagos(cn);
		int pedidos = dao.getNumPedidos(cn);
		
		request.setAttribute("c", customer);
		request.setAttribute("total", total);
		request.setAttribute("pedidos", pedidos);
		
		request.getRequestDispatcher("/WEB-INF/view/customerReport.jsp").forward(request, response);
	}

}
