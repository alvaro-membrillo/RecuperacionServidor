package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
@WebServlet("/ChangeAssigmentServlet")
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssigmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		List<Employee> listaEmpleados = dao.getAllEmployees();
		DAOCustomerImpl daoCust = new DAOCustomerImpl();
		
		Integer customerNumber = Integer.parseInt(request.getParameter("id"));
		Customer customer = daoCust.getCustomerById(customerNumber);
		
		request.setAttribute("empleados", listaEmpleados);
		request.setAttribute("c", customer);
		
		request.getRequestDispatcher("/WEB-INF/view/cambiarEmpleadoAsignado.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empleado = request.getParameter("empleadoAsignado");
		DAOCustomerImpl dao = new DAOCustomerImpl();
		
		if (empleado != null) {
			dao.changeEmpleado(Integer.parseInt(empleado));
			
		} else {
			request.setAttribute("error", "El empleado es nulo");
		}
		
		response.sendRedirect(request.getContextPath()+"/Home");
	}

}
