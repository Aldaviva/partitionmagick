<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Wiki - Partitions</title>
		<link href="${pageContext.request.contextPath}/styles/wiki.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
		<table border="1">
			<thead>
				<tr>
					<th class="environment">Environment</th>
					<th class="name">Partition</th>
					<th class="release">Release</th>
					<th class="branch">Branch</th>
					<th class="popCount"># of POPs</th>
					<th class="appNodeCount"># of APP nodes</th>
					<th class="conNodeCount"># of CON nodes</th>
					<th class="medNodeCount"># of MED nodes</th>
					<th class="comments">Comments</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${partitions}" var="partition">
					<tr>
						<td class="environment">${partition.environment}</td>
						<td class="name">${partition.name}</td>
						<td class="release">${partition.release}</td>
						<td class="branch">${partition.branch}</td>
						<td class="popCount">${partition.popCount}</td>
						<td class="appNodeCount">${partition.appNodeCount}</td>
						<td class="conNodeCount">${partition.conNodeCount}</td>
						<td class="medNodeCount">${partition.medNodeCount}</td>
						<td class="comments">${partition.comments}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>