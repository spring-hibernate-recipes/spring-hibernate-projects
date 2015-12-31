<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eshoppe Admin :: New Product Category</title>
</head>
<body>
	<h1>Eshoppe Admin</h1>
	<hr>
	New Product Category
	<hr>
	<form method="post"
		action="http://localhost:8080/eshoppe-rest/eshoppe/productCategory">
		<table>
			<tr>
				<td class="label">Name</td>
				<td></td>
			</tr>
			<tr>
				<td class="label">Description</td>
				<td></td>
			</tr>
			<tr>
				<td class="label">Properties</td>
				<td></td>
			</tr>
			<tr>
				<td class="label">Images</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
	<hr>
</body>
</html>