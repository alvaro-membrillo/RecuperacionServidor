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
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddCustomerServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		List<Employee> listaEmpleados = dao.getAllEmployees();
		
		request.setAttribute("listaEmpleados", listaEmpleados);
		
		request.getRequestDispatcher("/WEB-INF/view/addCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String customerName = request.getParameter("customerName");
		String contactFirstName = request.getParameter("contactFirstName");
		String contactLastName = request.getParameter("contactLastName");
		String phone = request.getParameter("phone");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		int empleado = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
		double creditLimit = Double.parseDouble(request.getParameter("creditLimit"));

		if (customerNumber >= 0 && customerName != null && contactFirstName != null && contactLastName != null
				&& phone != null && addressLine1 != null && addressLine2 != null && city != null && state != null
				&& postalCode != null && country != null && empleado >= 0 && creditLimit >= 0) {

			Customer customer = new Customer();
			DAOCustomerImpl dao = new DAOCustomerImpl();
			customer.setCustomerNumber(customerNumber);
			customer.setCustomerName(customerName);
			customer.setContactLastName(contactLastName);
			customer.setContactFirstName(contactFirstName);
			customer.setPhone(phone);
			customer.setAddressLine1(addressLine1);
			customer.setAddressLine2(addressLine2);
			customer.setCity(city);
			customer.setState(state);
			customer.setPostalCode(postalCode);
			customer.setCountry(country);
			customer.setSalesRepEmployeeNumber(empleado);
			customer.setCreditLimit(creditLimit);

			dao.addCustomer(customer);
			logger.log(Level.INFO, "El cliente " + customer.getCustomerName() + " se ha añadido correctamente.");
		}

		response.sendRedirect(request.getContextPath() + "/Home");
	}

}
