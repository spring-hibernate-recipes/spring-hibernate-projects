<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eshoppe Admin :: New Product Category</title>
<script type="text/javascript" src="jquery-git2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.get("http://localhost:8080/eshoppe-rest/eshoppe/category", function(
				response) {
			var dropDown = $("#parentCategory");
			$.each(response.categories, function(category) {
				dropDown.append($("<option />").val(category.id).text(
						category.name));
			});
		});
	});
	function submitform() {
		var obj = $("#form0");
		var formData = new FormData();
		$.each($(obj).find('input[type="file"]'), function(i, tag){
			$.each($(tag)[0].files, function(i, file){
				formData.append(tag.name, file);
			});
		});
		var params = $(obj).serializeArray();
		$.each(params, function(i, value){
			formData.append(value.name, value.value);
		});
		$.ajax({url:'http://localhost:8080/eshoppe-rest/eshoppe/productCategory',type: 'POST', data: formData, processData: false, contentType: false}).done(function(response){
			alert(response.message);
		});
	}
</script>
</head>
<body>
	<h1>Eshoppe Admin</h1>
	<hr>
	New Product Category
	<hr>
	<form method="post"
		action="http://localhost:8080/eshoppe-rest/eshoppe/productCategory"
		enctype="multipart/form-data" id="form0">
		<table>
			<tr>
				<td class="label">Parent Category</td>
				<td><select name="parentCategory" id="parentCategory">
						<option value="-1">No Parent</option>
				</select></td>
			</tr>
			<tr>
				<td class="label">Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td class="label">Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td class="label">Properties</td>
				<td><input type="text" name="properties"></td>
			</tr>
			<tr>
				<td class="label">Images</td>
				<td><input type="file" name="image"><br> <input
					type="file" name="image"><br> <input type="file"
					name="image"><br> <input type="file" name="image"><br>
					<input type="file" name="image"><br> <input
					type="file" name="image"><br> <input type="file"
					name="image"><br> <input type="file" name="image"><br>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="Save" onclick="submitform();"></td>
			</tr>
		</table>
	</form>
	<hr>
</body>
</html>