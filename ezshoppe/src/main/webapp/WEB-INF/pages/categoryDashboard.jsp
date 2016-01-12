<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function loadCategories() {
		$('#categoryDiv').html();
		$.get("rest/category/top", function(response) {
			var categories = response.data;
			if (categories == null) {
				categories = [];
			}
			var list = getRecursive(categories, null);
			$('#categoryDiv').html(list);
		});
	}
	function save(textbox, parentId) {
		if ($(textbox).val()) {
			var data = {
				name : $(textbox).val(),
				description : $(textbox).val(),
				parentId : parentId
			};
			if (parentId == 0) {
				data.parentId = null;
			}

			$(textbox).val('');
			$.post('rest/category', data, function(response) {
				$('#messageDiv').html('Category added successfully.');
				$('#messageDiv').show(50);
				$('#messageDiv').hide(1000);
				loadCategories();
			});
		}
	}
	function getRecursive(arr, id) {
		var html = '<ul>';
		if (arr != null) {
			$.each(arr, function(k, item){
				html = html + '<li>' + item.name;
				html += getRecursive(item.children, item.id);
				html += '</li>';
			});
		}
		html += '<li><input type="text" onblur="save(this, ' + id + ');"></li>';
		html += '</ul>';
		return html;
	}
	
	$(document).ready(function() {
		loadCategories();
	});
</script>
<style type="text/css">
	#messageDiv {
		color: #fff;
	}
</style>
</head>
<body>
	<div id="messageDiv"></div>
	<div id="categoryDiv"></div>
</body>
</html>