<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>PartitionMagick</title>
		<link href="${pageContext.request.contextPath}/styles/dashboard.css" rel="stylesheet" type="text/css" />
		<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico">
	</head>
	
	<body>
		<div class="partitions">
			<c:forEach items="${partitions}" var="partition">
				<c:if test="${!partition.name.isEmpty()}">
					<div class="partition">
						<div class="label">
							<span class="name">${partition.name}</span>
							<span class="environment">${partition.environment}</span>
						</div>
						
						<div class="release ${fn:toLowerCase(partition.pluginColor)}">${partition.release}</div>
						
						<div class="branch">${partition.branch}</div>
						
						<div class="buildHash">${partition.buildHash}</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="calendar">
			<h1>Release Calendar</h1>
			<c:forEach items="${calendarEvents}" var="event">
				<div class="event ${(fn:containsIgnoreCase(event.name, 'z1') || fn:containsIgnoreCase(event.name, 'z2')) ? 'prod' : ''}">
					<div class="date">
						<span class="day-of-week">
							<joda:format value="${event.start}" pattern="E"/>
						</span>
						<span class="day-of-month">
							<joda:format value="${event.start}" pattern="d"/>
						</span>
						<span class="month">
							<joda:format value="${event.start}" pattern="MMM"/>
						</span>
					</div>
					
					<div class="name">
						<c:set var="eventName" value="${event.name}" />
						<% pageContext.setAttribute("tokens", ((String) pageContext.getAttribute("eventName")).split("(?<=,)|(?=,)|(?<=\\s+)|(?=\\s+)")); %>
						<c:forEach items="${tokens}" var="token">
							<c:choose>
								<c:when test='${token.equals(" ")}'><c:out value="${token}" /></c:when>
								<c:when test='${fn:containsIgnoreCase("z1 z2 a1 a2 q1 q2 g1 g2 q11 q12 e f", token)}'><span class="partition">${token}</span></c:when>
								<c:when test='${fn:containsIgnoreCase("master rel beta live", token)}'><span class="branch">${fn:toUpperCase(token)}</span></c:when>
								<c:otherwise><c:out value="${token}" /></c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<script type="text/javascript">
			window.contextPath = "${pageContext.request.contextPath}";
		</script>
		<script src="${pageContext.request.contextPath}/javascript/atmosphere.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/dashboard.js" type="text/javascript"></script>
	</body>
</html>