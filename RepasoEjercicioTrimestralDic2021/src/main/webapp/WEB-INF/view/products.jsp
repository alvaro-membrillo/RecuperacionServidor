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
<title><fmt:message key="showEmployee" /></title>
</head>
<body>
	<div class="container mt-5">
		<c:if test="${requestScope.categoria!=null}">
			<div class="row justify-content-center mt-5">
				<jsp:include page="include/barra.jsp" />


				<h1 class="row justify-content-center mt-3">
					<fmt:message key="p1" />
					<%=request.getAttribute("categoria")%></h1>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col"><fmt:message key="name" /></th>
							<th scope="col"><fmt:message key="description" /></th>
							<th scope="col"><fmt:message key="manufacturer" /></th>
							<th scope="col"><fmt:message key="buyprice" /></th>
							<th scope="col"><fmt:message key="stock" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="p">
							<tr>
								<td>${p.productName}</td>
								<td>${p.productDescription}</td>
								<td>${p.productVendor}</td>
								<td>${p.buyPrice}</td>
								<td>${p.quantityInStock}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${requestScope.categoria eq null}">
			<h2 class="text-danger"><fmt:message key="error1" /></h2>
			<h3><a href="${pageContext.request.contextPath}/Home"><fmt:message key="return" /></a></h3>
		</c:if>
	</div>
</body>
</html>