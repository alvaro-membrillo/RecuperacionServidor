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
			
			<h1 class="text-center"><fmt:message key="ordersTable" /></h1>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"><fmt:message key="orderNumber" /></th>
						<th scope="col"><fmt:message key="orderDate" /></th>
						<th scope="col"><fmt:message key="shippedDate" /></th>
						<th scope="col"><fmt:message key="status" /></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="o">
						<tr>
							<td>${o.orderNumber}</td>
							<td>${o.orderDate}</td>
							<td>${o.shippedDate}</td>
							<td>${o.status}</td>
							<c:if test="${sessionScope.role eq 'user'}">
								<td><a href="${pageContext.request.contextPath}/OrderReport?on=${o.orderNumber}"><i class="bi bi-eye-fill"></i></a></td>
							</c:if>
							<c:if test="${sessionScope.role eq 'admin'}">
								<td><a href="${pageContext.request.contextPath}/Admin/ChangeOrderCustomer?on=${o.orderNumber}"><i class="bi bi-people-fill"></i></a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>