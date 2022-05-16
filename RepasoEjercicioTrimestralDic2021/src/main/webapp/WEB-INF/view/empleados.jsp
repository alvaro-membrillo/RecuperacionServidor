<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title><fmt:message key="orders" /></title>
</head>
<body>

	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<jsp:include page="include/barra.jsp" />

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
							<td>${e.oficina}</td>
							<td>${e.jefe}</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

</body>
</html>