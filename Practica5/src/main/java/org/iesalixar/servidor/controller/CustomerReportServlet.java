package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderDetailsImpl;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.OrderDetail;
import org.iesalixar.servidor.model.Product;

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
		
		int orderNumber = Integer.parseInt(request.getParameter("on"));
		DAOOrderDetailsImpl dao = new DAOOrderDetailsImpl();
		List<OrderDetail> orderDetails = dao.getOrderDetailsByOrderNumber(orderNumber);
		request.setAttribute("orderDetails", orderDetails);
		
		DAOProductImpl daoProduct = new DAOProductImpl();
		/*List<Product> products = daoProduct.getProductById();
		request.setAttribute("products", products);*/
		
		request.getRequestDispatcher("/WEB-INF/view/orderReport.jsp").forward(request, response);
	}

	
}
