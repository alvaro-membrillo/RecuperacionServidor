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
<title>Inicio</title>
</head>
<body>
	<jsp:include page="include/barra.jsp" />

	<div class="container mt-5">
		<div class="row justify-content-center mt-2">
			<h3><fmt:message key="title" /></h3>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"><fmt:message key="category" /></th>
						<th scope="col"><fmt:message key="description" /></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categorias}" var="c">
						<tr>
							<td>${c.productLine}</td>
							<td>${c.textDescription}</td>
							<c:if test="${sessionScope.role eq 'user'}">
								<td><a href="${pageContext.request.contextPath}/ProductLine?cat=${c.productLine}"><i
										class="bi bi-eye-fill"></i></a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>
</body>
</html>