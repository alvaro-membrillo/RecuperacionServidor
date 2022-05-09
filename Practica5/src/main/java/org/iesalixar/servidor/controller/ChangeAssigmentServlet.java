package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Order;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
@WebServlet("/ChangeAssigmentServlet")
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ChangeAssigmentServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAssigmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer orderNumber = Integer.parseInt(request.getParameter("on"));
		request.setAttribute("on", orderNumber);
		
		DAOCustomerImpl dao = new DAOCustomerImpl();
		List<Customer> customers = dao.getAllCustomers();
		
		DAOOrderImpl daoOrder = new DAOOrderImpl();
		Order order = daoOrder.getOrderById(orderNumber);
		request.setAttribute("o", order);
		
		request.setAttribute("customers", customers);

		request.getRequestDispatcher("/WEB-INF/view/changeProductCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int orderNumber = Integer.parseInt(request.getParameter("on"));
		int salesRepEmployeeNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
		
		if (orderNumber >= 0 && salesRepEmployeeNumber >= 0) {
			DAOCustomerImpl dao = new DAOCustomerImpl();
			dao.updateEmployeeCustomer(orderNumber, salesRepEmployeeNumber);
		}
		
		response.sendRedirect(request.getContextPath()+"/Home");
		
		DAOCustomerImpl dao = new DAOCustomerImpl();
		String cn = request.getParameter("cn");
		Customer cliente = dao.getCustomer(Integer.parseInt(cn));
		
		logger.log(Level.INFO, "Se ha cambiado la asignacion del empleado  al cliente " + cliente.getCustomerNumber()
		+ " --- " + cliente.getCustomerName() + " por el empleado " + cliente.getSalesRepEmployeeNumber());
		
	}

}
