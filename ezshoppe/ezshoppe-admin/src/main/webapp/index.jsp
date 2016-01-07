<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">
<%@include file="config.jsp"%>
<html>

<head>

<title>Conforming HTML 4.01 Strict Template</title>

</head>

<body>
	<form method="POST" action="<%=REST_URL%>/user/authenticate">
		<table>
			<tr>
				<td class="label">Username</td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td class="label">Password</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>