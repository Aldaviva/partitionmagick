<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Partitions</title>
		<link href="${pageContext.request.contextPath}/styles/dashboard.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
		<div class="partitions">
			<c:forEach items="${partitions}" var="partition">
				<div class="partition">
					<div class="label">
						<span class="name">${partition.name}</span>
						<span class="environment">${partition.environment}</span>
					</div>
					
					<div class="release">${partition.release}</div>
					
					<div class="branch ${partition.branch}">${partition.branch}</div>
				</div>
			</c:forEach>
		</div>
		
		<div class="calendar">
			<c:forEach items="${calendarEvents}" var="event">
				<div class="event">
					<div class="date">
						<span class="month">
							<joda:format value="${event.start}" pattern="MMM"/>
						</span>
						<span class="day-of-month">
							<joda:format value="${event.start}" pattern="d"/>
						</span>
						<span class="day-of-week">
							<joda:format value="${event.start}" pattern="E"/>
						</span>
					</div>
					
					<div class="name">
						<c:forTokens items="${event.name}" delims=" " var="token">
							<c:choose>
								<c:when test='${fn:containsIgnoreCase("z1 z2 a1 a2 q1 q2", token)}'>
									<span class="partition">${token}</span>
								</c:when>
								<c:when test='${fn:containsIgnoreCase("master rel beta live", token)}'>
									<span class="branch ${token}">${token}</span>
								</c:when>
								<c:otherwise>
									<c:out value="${token}" />
								</c:otherwise>
							</c:choose>
						</c:forTokens>
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