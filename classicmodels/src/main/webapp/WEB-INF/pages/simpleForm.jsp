<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Form</title>
<script type="text/javascript" src="resources/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#form0').submit(function(e) {
			var data = {};
			$('#form0 input').each(function() {
				data[this.id] = $(this).val();
			});
			alert(JSON.stringify(data));
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'rest/simple',
				data : JSON.stringify(data),
			}).done(function(response) {
				alert(JSON.stringify(response.data));
			});
			e.preventDefault();
		});
	});
</script>
</head>
<body>
	<form id="form0">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" id="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" id="lastName" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" id="emailAddress" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" id="phoneNumber" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
</body>
</html>