<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>hello! ${id1}</title>
</head>
<body>


	<table>
		<tr>
			<td>id:</td>
			<td><input type="text"></td>
		</tr>

		<tr>
			<td>pw:</td>
			<td><input type="password"></td>
			<td><input type="button" value="로그인"></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>hello</td>
			<td>${id1}</td>
		</tr>

	</table>


</body>
</html>