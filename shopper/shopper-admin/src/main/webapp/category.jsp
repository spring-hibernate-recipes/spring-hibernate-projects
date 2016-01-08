<%@include file="config.jsp"%>
<html>
<head>
<title>Control Panel</title>
<script src="jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function submitForm() {
		alert("Going to save data..");
		var data = {name: $('#name').val(),
				description: $('#description').val(),
				parentId: $('#parentId').val(),};
		$.post('<%=REST_BASE%>/category', data, function(response) {
			alert(JSON.stringify(response));
		});
	}
</script>
</head>
<body>
	<form id="form0" method="post" action="<%=REST_BASE%>/category">
		<table>
			<tr>
				<td>Name</td>
				<td><input id="name" type="text" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input id="description" type="text" /></td>
			</tr>
			<tr>
				<td>Parent</td>
				<td><select name="parentId" id="parentId">
						<option></option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Category"
					onclick="submitForm(); return false;" /></td>
			</tr>
		</table>
	</form>
</body>
</html>