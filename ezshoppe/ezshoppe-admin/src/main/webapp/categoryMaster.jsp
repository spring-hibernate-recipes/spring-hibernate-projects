<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.get("<%=REST_URL%>/category", function(response){
			var categories = response.data.categories;
			for (i = 0; i<categories.length; i++) {
				var category = categories[i];
				var row = '<tr>';
				row = row + '<td>' + category.id + '</td>';
				row = row + '</tr>';
			}
		});
	});
</script>
</head>
<body>
	<div id="container">
		<div id="header">ezShoppe Admin Console</div>
		<div id="mainContent">
			<div id="menuDiv"><%@include file="menu.jsp" %></div>
			<div id="contentArea">
				<div class="moduleHead">Category Master</div>
				<form method="post" action="<%=REST_URL%>/category">
					<table>
						<tr>
							<td class="label">Category Name</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td class="label">Image</td>
							<td><input type="file" name="image"></td>
						</tr>
						<tr>
							<td class="label">Label</td>
							<td><input type="text" name="label"></td>
						</tr>
						<tr>
							<td class="label"></td>
							<td><input type="checkbox" name="topLevel">Top level category</td>
						</tr>
						<tr>
							<td class="label">Parent Category</td>
							<td>
								<select id="categories" name="parentCategoryId">
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Create Category"></td>
						</tr>
					</table>
				</form>
				<br>
				<table width="100%" cellspacing="0" cellpadding="0" id="categoryListing">
					<tr>
						<td width="10%">ID</td>
						<td width="20%">Name</td>
						<td width="50%">Hierarchy</td>
						<td width="10%"></td>
						<td width="10%"></td>
					</tr>
				</table>
			</div>
			<div style="clear: both"></div>
		</div>
		<div id="footer">(C) 2016, ezShoppe.com, All Rights Reserved.</div>
	</div>
</body>
</html>