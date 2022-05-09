<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Order Report</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<jsp:include page="include/barra.jsp" />

			<h1 class="text-center">Order Report</h1>

			<h4>Order Code: ${cn}</h4>

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Product Name</th>
						<th scope="col">Quantity</th>
						<th scope="col">Price Each</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderDetails}" var="od">
						<tr>
							<!--<c:forEach items="${products}" var="p">
								<c:if test="${p.productCode eq od.productCode}">
									<td>${p.productName}</td>
								</c:if>
							</c:forEach>-->
							<td>${od.productCode}</td>
							<td>${od.quantityOrdered}</td>
							<td>${od.priceEach}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>