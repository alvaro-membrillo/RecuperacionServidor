<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Customer</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<jsp:include page="include/barra.jsp" />
			
			<c:if test="${sessionScope.role eq 'admin'}">
				<div class="row justify-content-end"><a href="${pageContext.request.contextPath}/Admin/AddCustomer" class="btn btn-primary col-2 mt-1">Añadir Customer</a></div>
			</c:if>

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Número del cliente</th>
						<th scope="col">Nombre del cliente</th>
						<th scope="col">Nombre del contacto</th>
						<th scope="col">Apellidos del contacto</th>
						<th scope="col">Teléfono</th>
						<th scope="col">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="c">
						<tr>
							<td>${c.customerNumber}</td>
							<td>${c.customerName}</td>
							<td>${c.contactFirstName}</td>
							<td>${c.contactLastName}</td>
							<td>${c.phone}</td>
							<c:if test="${sessionScope.role eq 'user'}">
								<td><a href="${pageContext.request.contextPath}/CustomerReport?cn=${c.customerNumber}"><i class="bi bi-eye-fill"></i></a></td>
							</c:if>
							<c:if test="${sessionScope.role eq 'admin'}">
								<td><a href="${pageContext.request.contextPath}/Admin/ChangeAssigment?id=${c.customerNumber}"><i class="bi bi-people-fill"></i></a></td>
							</c:if>
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
			
			<c:if test="${sessionScope.role eq 'admin'}">
				<div class="row justify-content-end"><a href="${pageContext.request.contextPath}/Admin/AddCustomer" class="btn btn-primary col-2 mt-1">Añadir Customer</a></div>
			</c:if>

		</div>
	</div>
</body>
</html>