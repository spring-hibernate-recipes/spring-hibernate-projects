<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eshoppe Admin :: New Employee</title>
<%@include file="stylesheets.jsp"%>
<script type="text/javascript" src="jquery-git2.min.js"></script>
<script type="text/javascript">
	function saveEmployee() {
		var formData = $("#f0").serialize();
		alert(formData);
		$.post("http://localhost:8080/eshoppe-rest/eshoppe/employee", formData,
				function(response) {
					alert(response);<% %>
				});
	}
</script>
</head>
<body>
	<h1>Admin</h1>
	<hr>
	New Employee
	<hr>
	<form id="f0">
		<table>
			<tr>
				<td class="label">First name</td>
				<td><input type="text" name="firstName" size="30"></td>
			</tr>
			<tr>
				<td class="label">Last name</td>
				<td><input type="text" name="lastName" size="30"></td>
			</tr>
			<tr>
				<td class="label">Personal Email Address</td>
				<td><input type="text" name="emailAddress" size="30"></td>
			</tr>
			<tr>
				<td class="label">Emergency Contact Name</td>
				<td><input type="text" name="emergencyContactName" size="30"></td>
			</tr>
			<tr>
				<td class="label">Emergency Contact Number</td>
				<td><input type="text" name="emergencyContactNumber" size="30"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="Save Employee"
					onclick="saveEmployee();"></td>
			</tr>
		</table>
	</form>
	<hr />
</body>
</html>