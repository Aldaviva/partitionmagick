<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					${event.name}
				</div>
			</c:forEach>
		</div>
		
		<div class="comments">
			<c:forEach items="${partitions}" var="partition">
				<c:if test="${partition.comments != null}">
					<div>${partition.comments}</div>
				</c:if>
			</c:forEach>
		</div>
		
		<script src="${pageContext.request.contextPath}/scripts/dashboard.js" type="text/javascript"></script>
	</body>
</html>