<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />
<fmt:setBundle basename="interface" />

<ul class="nav bg-primary">

	<li class="nav-item"><a class="nav-link text-white"
		aria-current="page" href="<%=request.getContextPath()%>/Home"><fmt:message key="home" /></a></li>

	<c:if test="${sessionScope.role eq 'user'}">
		<fmt:message key="userTitle" />
	</c:if>

	<c:if test="${sessionScope.role eq 'admin'}">
		<li class="nav-item"><a href="${pageContext.request.contextPath}/Admin/Empleados" class="text-white"><fmt:message key="showEmployee" /></a></li>
		<li class="nav-item"><a href="${pageContext.request.contextPath}/Admin/AddEmpleado" class="text-white"><fmt:message key="addEmployee" /></a></li>
		
		<fmt:message key="adminTitle" />
		
	</c:if>

	<li class="nav-item"><a class="text-white"
		href="<%=request.getContextPath() + "/Logout"%>"> <i
			class="bi bi-box-arrow-left"></i>
	</a></li>

</ul>
