<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.aryalinux.restapp.model.Reflector"%>
<%@page import="java.lang.reflect.ParameterizedType"%>
<%@page import="java.lang.reflect.Type"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript" src="resources/jquery-1.12.0.js"></script>
<script type="text/javascript">
	var entity = "employee";
	$(document).ready(function() {
		$.get("productline/structure", function(response) {
			$('#formDiv').html(response);
		});
	});
</script>
<title>ClassicModels</title>
</head>
<body>
	<div id="formDiv"></div>
</body>
</html>