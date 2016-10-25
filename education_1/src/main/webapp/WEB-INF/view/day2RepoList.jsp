<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>List Sample</title>
</head>
<body>
	<table>
		<tr>
			<td>id:			</td>
			<td>name:		</td>
			<td>address:	</td>
			<td>password:	</td>
		</tr>
		
		<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.id}</td>
			<td>${list.name}</td>
			<td>${list.address}</td>
			<td>${list.password}</td>
		</tr>
		</c:forEach>
	
	</table>
	



</body>
</html>