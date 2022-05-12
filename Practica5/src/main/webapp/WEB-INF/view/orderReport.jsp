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
<title><fmt:message key="orderReport" /></title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">

			<c:if test="${error == null}">

				<jsp:include page="include/barra.jsp" />
				<h1 class="text-center"><fmt:message key="orderReport" /></h1>
				<h4><fmt:message key="orderNumber" />: ${on}</h4>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col"><fmt:message key="productName" /></th>
							<th scope="col"><fmt:message key="quantity" /></th>
							<th scope="col"><fmt:message key="priceEach" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderDetails}" var="od">
							<tr>
								<td>${od.productName}</td>
								<td>${od.quantityOrdered}</td>
								<td>${od.priceEach}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${error!=null}">
				<h1><fmt:message key="orderError" /></h1>
				<a class="btn btn-info col-2" href="${pageContext.request.contextPath}/Home"><fmt:message key="home" /></a>
			</c:if>
		</div>
	</div>
</body>
</html>