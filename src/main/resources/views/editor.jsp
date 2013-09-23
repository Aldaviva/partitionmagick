<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Editor - PartitionMagick</title>
		<link href="${pageContext.request.contextPath}/styles/editor.css" rel="stylesheet" type="text/css" />
		<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico">
	</head>
	
	<body>
		<form:form modelAttribute="formData">
			<table>
				<thead>
					<tr>
						<th>Environment</th>
						<th>Partition</th>
						<th>Release</th>
						<th>Branch</th>
						<th>Plugin Color</th>
						<th># of POPs</th>
						<th># of APP nodes</th>
						<th># of CON nodes</th>
						<th># of MED nodes</th>
						<th>Comments</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${formData.partitions}" var="partition" varStatus="row">
						<tr>
							<td>
								<form:hidden path="partitions[${row.index}].id"/>
								<form:hidden path="partitions[${row.index}].sort"/>
								<form:input path="partitions[${row.index}].environment" />
							</td>
							<td><form:input path="partitions[${row.index}].name" /></td>
							<td><form:input path="partitions[${row.index}].release" /></td>
							<td><form:input path="partitions[${row.index}].branch" /></td>
							<td><form:select path="partitions[${row.index}].pluginColor" items="${pluginColors}"></form:select></td>
							<td><form:input path="partitions[${row.index}].popCount" /></td>
							<td><form:textarea path="partitions[${row.index}].appNodeCount" /></td>
							<td><form:textarea path="partitions[${row.index}].conNodeCount" /></td>
							<td><form:textarea path="partitions[${row.index}].medNodeCount" /></td>
							<td><form:textarea path="partitions[${row.index}].comments" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" />
		</form:form>
	</body>
</html>