<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Añadir Producto</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<c:if test="${on eq ''}">
					<h3>Cliente inexistente</h3>
				</c:if>

				<c:if test="${on ne null}">
					<h1>Change Product Customer</h1>
					<h4>Order Code: ${on}</h4>
					<form method="POST">
						<label>CUSTOMER</label> <select class="form-control"
							name="customer">
							<c:forEach items="${customers}" var="c">
								<c:if test="${c.customerNumber eq o.customerNumber}">
									<option value="${c.customerNumber}" selected>${c.customerName}</option>
								</c:if>
								<c:if test="${c.customerNumber ne o.customerNumber}">
									<option value="${c.customerNumber}">${c.customerName}</option>
								</c:if>
							</c:forEach>
						</select> <input type="submit" class="btn btn-primary w-100 mt-3"
							value="CHANGE CUSTOMER" />
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>