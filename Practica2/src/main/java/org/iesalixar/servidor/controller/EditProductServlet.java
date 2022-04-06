package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.dao.DAOProductoImpl;
import org.iesalixar.servidor.model.ProductLine;
import org.iesalixar.servidor.model.Producto;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productCode = request.getParameter("p");

		if (productCode != null) {

			// Para recibir todos los valores de los productos
			DAOProductoImpl dao = new DAOProductoImpl();
			Producto producto = dao.getProducto(productCode);
			request.setAttribute("producto", producto);
			
			// Para recibir todas las categorías (productLines)
			DAOProductLineImpl daoPl = new DAOProductLineImpl();
			List<ProductLine> productLines = daoPl.getAllProductLines();
			request.setAttribute("productLines", productLines);

			request.getRequestDispatcher("/WEB-INF/view/editarProducto.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher(request.getContextPath()+"/Admin/Inicio");
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		String productLine = request.getParameter("productLine");
		String productScale = request.getParameter("productScale");
		String productVendor = request.getParameter("productVendor");
		String productDescription = request.getParameter("productDescription");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		Double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));
		Double msrp = Double.parseDouble(request.getParameter("msrp"));

		if (productName != null && productCode != null && productLine != null && productScale != null
				&& productVendor != null && productDescription != null && quantityInStock != 0 && buyPrice != 0.0
				&& msrp != 0.0) {

			/*Producto product = new Producto(productName, productCode, productLine, productScale, productVendor,
					productDescription, quantityInStock, buyPrice, msrp);*/
			Producto product = new Producto();
			product.setProductCode(productCode);
			product.setProductName(productName);
			product.setProductLine(productLine);
			product.setProductScale(productScale);
			product.setProductVendor(productVendor);
			product.setProductDescription(productDescription);
			product.setQuantityInStock(quantityInStock);
			product.setBuyPrice(buyPrice);
			product.setMsrp(msrp);

			DAOProductoImpl daoImpl = new DAOProductoImpl();

			daoImpl.editProducto(product);
			//request.getRequestDispatcher(request.getContextPath()+"/Admin/Inicio");
			response.sendRedirect(request.getContextPath()+"/Admin/Inicio");
		}

	}

}
