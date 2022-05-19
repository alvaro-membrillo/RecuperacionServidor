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
<title><fmt:message key="changeAssigment" /></title>
</head>
<body>
	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<h2><fmt:message key="changeAssigment" /></h2>
				<form method="POST">
					<label><fmt:message key="product" /></label> <select class="form-control" name="product">
						<c:forEach items="${productos}" var="p">
							<option value="${p.productCode}">${p.productName}</option>
						</c:forEach>
					</select> <label><fmt:message key="category" /></label> <select class="form-control"
						name="productLine">
						<c:forEach items="${categorias}" var="c">
							<option value="${c.productLine}">${c.productLine}</option>
						</c:forEach>
					</select> <input type="submit" class="btn btn-primary w-100 mt-3"
						value="<fmt:message key="assign" />" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>