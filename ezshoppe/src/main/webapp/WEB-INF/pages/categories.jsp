<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ezshoppe Administrator - Categories</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function loadCategories() {
		$('#parentId').empty();
		$.get('rest/category', function(response) {
			var categories = response.data;
			var parentIds = $('#parentId');
			for (i=0; i<categories.length; i++) {
				var category = categories[i];
				parentIds.append($("<option/>").val(category.id).text(
						category.description));
			}
		});
	}
	$(document).ready(function() {
		loadCategories();
	});
	function saveCategory() {
		var data = {
			name : $('#name').val(),
			description : $('#description').val(),
			parentId : $('#parentId').val()
		};
		$.post('rest/category', data, function(response) {
			alert(response.message + ', ID: ' + response.data);
			loadCategories();
		});
	}
</script>
</head>
<body>
	<form method="post" action="rest/category">
		<table>
			<tr>
				<td class="label">Name</td>
				<td><input name="name" id="name" /></td>
			</tr>
			<tr>
				<td class="label">Description</td>
				<td><input name="description" id="description" /></td>
			</tr>
			<tr>
				<td class="label">Parent Category</td>
				<td><select name="parentId" id="parentId"></select></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input type="button" value="Save"
					onclick="saveCategory(); return false;" /></td>
			</tr>
		</table>
	</form>
</body>
</html>