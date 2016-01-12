<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function formfield(field, label) {
		$(field).val(label);
		$(field).focus(function() {
			if ($(field).val() == label) {
				$(field).val('');
			}
		});
		$(field).blur(function() {
			if ($(field).val() == '') {
				$(field).val(label);
			}
		});
	}
	$(document).ready(function() {
		formfield('#Name', 'Name');
		formfield('#Description', 'Description');
		formfield('#Price', 'Price');
		formfield('#Brand', 'Brand');

		$('#form0').submit(function(e) {
			$.ajax({
				url : '/rest/product',
				type : 'POST',
				data : new FormData(this),
				processData : false,
				contentType : false
			}).done(function(response) {
				alert(response);
			});
			e.preventDefault();
		});
	});
	function addRow() {
		if ($('.PropertyValue:last').val() != '') {
			var html = '<tr>';
			html += '<td><input name="propertyName[]" class="PropertyName"></td>';
			html += '<td><input name="propertyValue[]" size="40" class="PropertyValue" onblur="addRow();"></td>';
			html += '</tr>';
			$('#propertyTable').append(html);
		}
	}
</script>
<style type="text/css">
body {
	font-family: 'Helvetica';
}

#picDiv {
	display: block;
	float: left;
	width: 200px;
	height: 200px;
	border: 10px solid #DDDDDD;
	margin-right: 20px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<form id="form0">
		<div id="picDiv">
			<input name="image" type="file">
		</div>
		<h2>Product Details</h2>
		<input id="Name" name="name"><br> <input
			name="description" id="Description"><br> <input
			id="Brand" name="brand"><br> <select
			name="categoryId" id="categoryId">
			<option value="0">Choose Category</option>
		</select><br> <input name="price" id="Price"><br>
		<div style="clear: both"></div>
		<h2>Properties</h2>
		<table id="propertyTable">
			<tr>
				<td>Property Name</td>
				<td>Property Value</td>
			</tr>
			<tr>
				<td><input name="propertyName[]" class="PropertyName"></td>
				<td><input name="propertyValue[]" size="40" class="PropertyValue"
					onblur="addRow();"></td>
			</tr>
		</table>
		<input type="submit" value="Save Product">
	</form>
</body>
</html>