package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		List<Employee> empleados = dao.getAllEmployees();
		
		DAOOfficeImpl daoOffice = new DAOOfficeImpl();
		List<Office> offices = daoOffice.getAllOffices();
		
		request.setAttribute("empleados", empleados);
		request.setAttribute("oficinas", offices);
		
		request.getRequestDispatcher("/WEB-INF/view/mostrarEmpleados.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
