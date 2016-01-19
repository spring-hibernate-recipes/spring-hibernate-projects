<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Dashboard</title>
<script type="text/javascript" src="resources/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/functions.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#projectProperties').click(function(e) {
			e.preventDefault();
			$('#contentArea').html(projectPropertiesForm());
		});
		$('#databaseProperties').click(function(e) {
			e.preventDefault();
			$('#contentArea').html(databasePropertiesForm());
		});
		$('#entities').click(function(e) {
			e.preventDefault();
			$('#contentArea').html(entityForm() + '<br/>' + entitiesTable());
		});
	});
</script>
<link rel="stylesheet" type="text/css" href="resources/style.css" />
</head>
<body>
	<div id="container">
		<div id="header">Dashboard</div>
		<div id="mainContent">
			<div id="sidebar">
				<ul>
					<li><a id="projectProperties" href="#">Project Properties</a></li>
					<li><a id="databaseProperties" href="#">Database</a></li>
					<li><a id="entities" href="#">Entities</a></li>
				</ul>
			</div>
			<div id="contentArea"></div>
		</div>
		<div id="footer">(C) 2016, Celestia Inc. All Rights Reserved.</div>
	</div>
</body>
</html>