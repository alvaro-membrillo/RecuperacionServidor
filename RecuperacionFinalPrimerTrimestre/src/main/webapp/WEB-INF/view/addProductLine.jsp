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
<title><fmt:message key="addProductLine" /></title>
</head>
<body>
	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<h2><fmt:message key="addProductLine" /></h2>
				<form method="POST">
					<label><fmt:message key="category" /></label>
					<input type="text" class="form-control" name="productLine" required>
					<label><fmt:message key="description" /></label>
					<input type="text" class="form-control" name="textDescription" required>
					
					<c:if test="${error ne null}">
						<p class="text-warning">${error}</p>
					</c:if>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="<fmt:message key="add" />" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>