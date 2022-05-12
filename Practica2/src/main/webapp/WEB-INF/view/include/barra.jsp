<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="bootstrap.jsp" />

<ul class="nav bg-primary">

	<li class="nav-item"><a class="nav-link text-white" aria-current="page"
		href="<%=request.getContextPath()%>"><fmt:message key="home" /></a>
	</li>

	<li class="nav-item"><a class="nav-link text-white" aria-current="page"
		href="<%=request.getContextPath() + "/Oficinas"%>"><fmt:message key="searchOffices" /></a></li>

	<li class="nav-item">
		<p class="text-white">
			Está usted logeado como: 
			<%=session.getAttribute("firstName") + " " + session.getAttribute("lastName")%>
		</p>
	</li>

	<li class="nav-item">
		<a class="text-white" href="<%= request.getContextPath() + "/Logout" %>"><fmt:message key="exit" /></a>
	</li>

</ul>
