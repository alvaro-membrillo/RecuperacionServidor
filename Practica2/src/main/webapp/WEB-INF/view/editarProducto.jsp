<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Inicio</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label>ProductCode</label> <input value="${producto.productCode}"
						type="text" class="form-control" name="productCode" readOnly>
					<label>ProductName</label> <input value="${producto.productName}"
						type="text" class="form-control" name="productName" required>
					<label>ProductLine</label> <select name="productLine">
						<c:forEach items="${productLines}" var="pl">
							<c:choose>
								<c:when test="${producto.productLine.equals(pl.productLine)}">
									<option selected>${pl.productLine}</option>
								</c:when>
								<c:otherwise>
									<option>${pl.productLine}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <br> <label>ProductScale</label> <input
						value="${producto.productScale}" type="text" class="form-control"
						name="productScale" required> <label>ProductVendor</label>
					<input value="${producto.productVendor}" type="text"
						class="form-control" name="productVendor" required> <label>ProductDescription</label>
					<textarea rows="4" class="form-control"
						name="productDescription">${producto.productDescription}</textarea>
					<label>QuantityInStock</label> <input
						value="${producto.quantityInStock}" type="number"
						class="form-control" name="quantityInStock" required> <label>BuyPrice</label>
					<input name="buyPrice" value="${producto.buyPrice}" type="number"
						class="form-control" name="buyPrice" required> <label>MSRP</label>
					<input name="msrp" value="${producto.msrp}" type="number" class="form-control"
						name="msrp" required> <input type="submit"
						class="btn btn-primary w-100 mt-3" value="MODIFICAR" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>