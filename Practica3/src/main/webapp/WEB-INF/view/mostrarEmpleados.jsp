<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Mostrar Empleados</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<jsp:include page="include/barra.jsp" />
	
			<div class="row justify-content-end"><a href="AddEmpleado" class="btn btn-primary col-2 mt-1">Añadir empleado</a></div>
			
			<h1 class="row justify-content-center mt-3">Empleados</h1>

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Número</th>
						<th scope="col">Apellidos</th>
						<th scope="col">Nombre</th>
						<th scope="col">Puesto</th>
						<th scope="col">Oficina</th>
						<th scope="col">Jefe</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${empleados}" var="e">
						<tr>
							<td>${e.employeeNumber}</td>
							<td>${e.lastName}</td>
							<td>${e.firstName}</td>
							<td>${e.jobTitle}</td>
							<c:forEach items="${oficinas}" var="o">
								<c:if test="${o.officeCode eq e.officeCode}">
									<td>${o.city}</td>
								</c:if>
							</c:forEach>
							<c:forEach items="${empleados}" var="em">
								<c:if test="${e.reportsTo eq em.employeeNumber}">
									<td>${em.firstName} ${em.lastName}</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
					
					
				</tbody>

			</table>

		</div>
	</div>
</body>
</html>