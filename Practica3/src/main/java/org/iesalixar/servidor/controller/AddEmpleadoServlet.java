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
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddEmpleadoServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpleadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOOfficeImpl dao = new DAOOfficeImpl();
		List<Office> offices = dao.getAllOffices();
		request.setAttribute("offices", offices);

		DAOEmployeeImpl daoEmpl = new DAOEmployeeImpl();
		List<Employee> employees = daoEmpl.getAllEmployees();
		request.setAttribute("employees", employees);

		request.getRequestDispatcher("/WEB-INF/view/addEmpleado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int numeroUsuario = Integer.parseInt(request.getParameter("employeeNumber"));
		String nombre = request.getParameter("firstName");
		String apellido = request.getParameter("lastName");
		String extension = request.getParameter("extension");
		String email = request.getParameter("email");
		String puesto = request.getParameter("jobTitle");
		String oficina = request.getParameter("office");
		int jefe = Integer.parseInt(request.getParameter("boss"));

		if (numeroUsuario >= 0 && jefe >= 0 && nombre!=null && apellido!=null && extension!=null && email!=null && puesto!=null && oficina!=null) {

			Employee empleado = new Employee();
			DAOEmployeeImpl dao = new DAOEmployeeImpl();
			empleado.setEmployeeNumber(numeroUsuario);
			empleado.setLastName(apellido);
			empleado.setFirstName(nombre);
			empleado.setExtension(extension);
			empleado.setEmail(email);
			empleado.setJobTitle(puesto);
			empleado.setOfficeCode(oficina);
			empleado.setReportsTo(jefe);

			dao.addEmployee(empleado);

			logger.log(Level.INFO, "El empleado " + empleado.getFirstName() + " " + empleado.getLastName()
					+ " se ha añadido correctamente.");

			response.sendRedirect(request.getContextPath() + "/Admin/Empleados");
		}
	}

}
