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
<title><fmt:message key="productLine" /></title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<jsp:include page="include/barra.jsp" />

			<c:if test="${sessionScope.role eq 'user'}">
				<h2><fmt:message key="categoryAviable" /></h2>

				<c:forEach items="${categorias}" var="c">
					<li><a href="${pageContext.request.contextPath}/MostrarProductos?productLine=${c.productLine}">${c.productLine}</a></li>
				</c:forEach>

			</c:if>

			<c:if test="${sessionScope.role eq 'admin'}">
				<h2><fmt:message key="operationsAviable" /></h2>
				
				<li><a href="${pageContext.request.contextPath}/Admin/Empleados"><fmt:message key="showEmployee" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Admin/AddEmpleado"><fmt:message key="addEmployee" /></a></li>				
			</c:if>

		</div>
	</div>
</body>
</html>