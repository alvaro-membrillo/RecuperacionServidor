<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Añadir cliente</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<h2>CLIENTE ${c.customerName}</h2>
				<h2>CONTACTO EN CLIENTE ${c.contactFirstName}
					${c.contactLastName}</h2>
				<form method="POST">
					<label>Empleado Asignado</label> <select class="form-select"
						name="empleadoAsignado">
						<c:forEach items="${empleados}" var="e">
							<c:choose>
								<c:when test="${e.employeeNumber eq c.salesRepEmployeeNumber}">
									<option value="${e.employeeNumber}" selected>${e.firstName}
										${e.lastName}</option>
								</c:when>
								<c:otherwise>
									<option value="${e.employeeNumber}">${e.firstName}
										${e.lastName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <input type="submit" class="btn btn-primary w-100 mt-3"
						value="Asignar empleado" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>