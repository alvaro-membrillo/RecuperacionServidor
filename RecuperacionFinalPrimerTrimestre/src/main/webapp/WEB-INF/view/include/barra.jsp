<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />
<fmt:setBundle basename="interface" />

<%-- <c:if test="${sessionScope.usuario!=null}"> --%>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">

			<li class="nav-item active"><a class="nav-link text-white"
				href="${pageContext.request.contextPath}/Home"><fmt:message key="home" /></a></li>

			<c:if test="${role eq 'admin'}">
				<li class="nav-item active"><a class="nav-link text-white"
					href="${pageContext.request.contextPath}/Admin/AddProductLine"><fmt:message key="addCategory" /></a></li>

				<li class="nav-item active"><a class="nav-link text-white"
					href="${pageContext.request.contextPath}/Admin/ChangeProductProductLine"><fmt:message key="asignCategory" /></a></li>
			</c:if>

			<li class="nav-item active"><a class="text-white"
				href="${pageContext.request.contextPath}/LogOut"> <i
					class="bi bi-box-arrow-left"></i></a></li>
		</ul>
	</div>
</nav>
<%-- </c:if> --%>
